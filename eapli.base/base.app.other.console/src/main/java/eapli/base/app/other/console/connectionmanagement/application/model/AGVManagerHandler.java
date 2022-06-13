package eapli.base.app.other.console.connectionmanagement.application.model;

import eapli.base.AGVmanagement.AGV.application.AGVService;
import eapli.base.AGVmanagement.AGV.domain.AGV;
import eapli.base.app.other.console.connectionmanagement.application.ConnectionController;
import eapli.base.warehousemanagement.application.OrderAGVAssignmentController;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.InetAddress;
import java.net.Socket;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.List;

public class AGVManagerHandler implements Runnable {

    private final Socket socket;
    private DataOutputStream sOut;
    private DataInputStream sIn;
    private ConnectionController connectionController;

    public AGVManagerHandler(Socket socket) {
        this.socket = socket;
    }

    @Override
    public void run() {
        connectionController = new ConnectionController();
        System.out.println("Establecendo conexao com os agv digital twins");
        connectionController.establishAGVTwinConnection();
        System.out.println("Conexao com os agv digital twins feita");
        boolean check = true;
        byte version, code, length1, length2;
        InetAddress clientIP = socket.getInetAddress();
        System.out.println("New client connection from " + clientIP.getHostAddress() + ", port number " + socket.getPort());

        try {
            sOut = new DataOutputStream(socket.getOutputStream());
            sIn = new DataInputStream(socket.getInputStream());
            byte[] message = new byte[255];
            do {
                String s = "";
                sIn.read(message);
                version = message[0];
                if (version == 1) {
                    int finalLength;
                    code = message[1];
                    length1 = message[2];
                    length2 = message[3];
                    if (length1 != 0 || length2 != 0) {
                        finalLength = length1 + (256 * length2);
                        byte[] dataArray = new byte[finalLength];
                        System.arraycopy(message, 4, dataArray, 0, finalLength);
                        s = new String(dataArray, StandardCharsets.UTF_8);
                    }
                    switches:
                    switch (code) {
                        case 0:
                            sOut.write(ServerFunctions.ACK());
                            break;
                        case 1:
                            sOut.write(ServerFunctions.ACK());
                            check = false;
                            break;
                        case 2:
                            sOut.write(ServerFunctions.ACK());
                            break;
                        case 3://checking agvs tasks and giving one to the one with the less tasks
                            System.out.println("Sending message to the AGV Digital Twin to check his availability");
                            List<String> list = new ArrayList<>();
                            List<AGV> agvs = AGVService.getAgvs();
                            for (int i = 0; i < agvs.size(); i++) {
                                connectionController.sendMessage(version, (byte) 3, "", 125 + i);
                                String s1 = connectionController.receiveMessage(125+i);
                                list.add(s1);
                            }
                            System.out.println("Messages sent!");
                            int lessBusyAGV = 0;
                            int lessBusyAGVTasks = -1;
                            for (String string : list) {
                                String[] agvString = string.split(";", -2);
                                if (lessBusyAGVTasks == -1) {
                                    lessBusyAGVTasks = Integer.parseInt(agvString[5]);
                                    lessBusyAGV = Integer.parseInt(agvString[4]);
                                }else if (Integer.parseInt(agvString[5]) < lessBusyAGVTasks) {
                                    lessBusyAGVTasks = Integer.parseInt(agvString[5]);
                                    lessBusyAGV = Integer.parseInt(agvString[4]);
                                }
                            }
                            System.out.println("The least busy AGV is: " + lessBusyAGV);
                            for (AGV agv : agvs) {
                                if (agv.getId() == lessBusyAGV) {
                                    connectionController.sendMessage(version, (byte) 4, lessBusyAGV + ";" + s, agv.getPort());
                                    String receivedMessage = connectionController.receiveMessage(agv.getPort());
                                    String[] receivedMessageString = receivedMessage.split(";", -2);
                                    if (receivedMessageString[4].equals("Success")) {
                                        OrderAGVAssignmentController.assignTaskToAGV(agv, s);
                                        System.out.println("AGV e order atualizados");
                                        sOut.write(ServerFunctions.sendMessage(1, 3, String.valueOf(lessBusyAGV)));
                                        break switches;
                                    }
                                }
                            }
                            sOut.write(ServerFunctions.sendMessage(1, 3, String.valueOf(lessBusyAGV)));
                            break;
                        case 5://initializing the agvs digital twins
                            ArrayList<AGV> set = AGVService.getAgvs();
                            int i = 0;
                            for (AGV agv : set) {
                                if (agv.getPort() != 0) {
                                    updateAGV(agv);
                                } else {
                                    agv.setPort(125 + i);
                                    updateAGV(agv);
                                    AGVService agvService = new AGVService();
                                    agvService.updateAGV(agv);
                                }
                                i++;
                            }
                            break;
                        default:
                            System.out.println("There is no functionality for this code");
                    }
                }
            } while (check);

            System.out.println("Client " + clientIP.getHostAddress() + ", port number: " + socket.getPort() + " disconnected");
            for (int i = 0; i < AGVService.getAgvs().size(); i++) {
                connectionController.sendMessage((byte) 1, (byte) 1, "", 125+i);
                connectionController.receiveMessage(125+i);
            }
            connectionController.closeClientConnection();
            sOut.close();
            sIn.close();
            socket.close();
        } catch (IOException ex) {
            System.out.println("IOException");
        }
    }

    private void updateAGV(AGV agv) {
        connectionController.sendMessage((byte) 1, (byte) 5, agv.getId() + ";" + agv.getLocation().getX() + ";" + agv.getLocation().getY() + ";" + agv.getStatus().getAvailability(), agv.getPort());
        StringBuilder tasksString = new StringBuilder();
        List<String> tasks = agv.getStatus().gettasks();
        System.out.println(agv.getId());
        for (String task : tasks) {
            System.out.println(task);
            tasksString.append(task).append(";");
        }
        connectionController.sendMessage((byte) 1, (byte) 6, tasksString.toString(), agv.getPort());
    }
}
