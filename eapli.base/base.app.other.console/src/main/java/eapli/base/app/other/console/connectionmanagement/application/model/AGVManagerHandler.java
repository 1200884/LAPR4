package eapli.base.app.other.console.connectionmanagement.application.model;

import eapli.base.AGVmanagement.AGV.application.AGVService;
import eapli.base.AGVmanagement.AGV.domain.AGV;
import eapli.base.AGVmanagement.AGV.domain.Status;
import eapli.base.AGVmanagement.AGV.domain.repository.Location;
import eapli.base.app.other.console.connectionmanagement.application.ConnectionController;
import eapli.base.ordermanagement.application.OrderServices;
import eapli.base.ordermanagement.domain.OrderLevel;
import eapli.base.warehousemanagement.application.JSONReader;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.InetAddress;
import java.net.Socket;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.List;

import static eapli.base.AGVmanagement.AGV.domain.Status.Availability.AVAILABLE;

public class AGVManagerHandler implements Runnable {

    private final Socket socket;
    private DataOutputStream sOut;
    private DataInputStream sIn;
    private ConnectionController connectionController;

    private static final int TWIN_STARTING_PORT = 125;

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

        AGVService agvService = new AGVService();
        try {
            sOut = new DataOutputStream(socket.getOutputStream());
            sIn = new DataInputStream(socket.getInputStream());
            byte[] message = new byte[1023];
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
                                connectionController.sendMessage(version, (byte) 3, "", TWIN_STARTING_PORT + i);
                                String s1 = connectionController.receiveMessage(TWIN_STARTING_PORT + i);
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
                                } else if (Integer.parseInt(agvString[5]) < lessBusyAGVTasks) {
                                    lessBusyAGVTasks = Integer.parseInt(agvString[5]);
                                    lessBusyAGV = Integer.parseInt(agvString[4]);
                                }
                            }
                            System.out.println("The least busy AGV is: " + lessBusyAGV + " with " + lessBusyAGVTasks + " tasks");
                            for (AGV agv : agvs) {
                                if (agv.getId() == lessBusyAGV) {
                                    connectionController.sendMessage(version, (byte) 4, lessBusyAGV + ";" + s, agv.getPort());
                                    String receivedMessage = connectionController.receiveMessage(agv.getPort());
                                    String[] receivedMessageString = receivedMessage.split(";", -2);
                                    if (receivedMessageString[4].equals("Success")) {
                                        assignTaskToAGV(agv, s);
                                        System.out.println("AGV and order updated");
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
                                    updateAGV(agv, agv.getStatus().gettasks());
                                } else {
                                    agv.setPort(TWIN_STARTING_PORT + i);
                                    updateAGV(agv, agv.getStatus().gettasks());
                                    agvService.updateAGV(agv);
                                }
                                i++;
                            }
                            break;
                        case 7://get all agv's positions
                            StringBuilder positions = new StringBuilder();
                            for (int j = TWIN_STARTING_PORT; j < TWIN_STARTING_PORT + 5; j++) {
                                connectionController.sendMessage((byte) 1, (byte) 7, "", j);
                                String agvPosition = connectionController.receiveMessage(j);
                                positions.append(agvPosition).append(";");

                                if (!agvPosition.equals("")) {

                                    try {
                                        ArrayList<AGV> agvList = AGVService.getAgvs();
                                        String[] fullMessage = agvPosition.split(";", -2);
                                        String[] position = fullMessage[4].split(":", -2);
                                        agvList.get(j - TWIN_STARTING_PORT).setLocation(new Location(Integer.parseInt(position[0]), Integer.parseInt(position[1])));
                                        agvService.updateAGV(agvList.get(j - TWIN_STARTING_PORT));
                                        System.out.println("Pos updated");
                                    }catch (Exception e) {
                                        System.out.println("There was a problem updating the AGVs location in the database");
                                        System.out.println(e);
                                    }
                                }
                            }

                            sOut.write(ServerFunctions.sendMessage(1, 7, positions.toString()));
                            break;
                        case 8://mandar o mapa
                            int[][] map = JSONReader.walls();
                            for (int j = 0; j < map.length; j++) {
                                StringBuilder mapString = new StringBuilder();
                                for (int k = 0; k < map[0].length; k++) {
                                    mapString.append(map[j][k]).append(":");
                                }
                                sOut.write(ServerFunctions.sendMessage(1, 8, mapString.toString()));
                            }

                            System.out.println("========================================");

                            for (int j = 0; j < map.length; j++) {
                                for (int k = 0; k < map[0].length; k++) {
                                    System.out.print(map[j][k]);
                                }
                                System.out.println();
                            }

                            System.out.println("========================================");

                            sOut.write(ServerFunctions.sendMessage(1, 9, ""));

                            System.out.println("Message sent with success");
                            break;
                        /*case 9:
                            ArrayList<AGV> agvList = AGVService.getAgvs();
                            for (AGV agv : agvList) {
                                if (s.equals(String.valueOf(agv.getId()))) {
                                    agv.getagvtasks().remove(0);
                                    agv.getStatus().setAvailability(AVAILABLE);
                                }
                            }
                            break;*/
                        default:
                            System.out.println("There is no functionality for this code");
                    }
                }
            } while (check);

            System.out.println("Client " + clientIP.getHostAddress() + ", port number: " + socket.getPort() + " disconnected");
            try {
                for (int i = 0; i < AGVService.getAgvs().size(); i++) {
                    connectionController.sendMessage((byte) 1, (byte) 1, "", TWIN_STARTING_PORT + i);
                    connectionController.receiveMessage(TWIN_STARTING_PORT + i);
                }
                connectionController.closeClientConnection();
                sOut.close();
                sIn.close();
                socket.close();
            }catch (Exception ignored) {

            }
        } catch (IOException ex) {
            System.out.println("IOException");
        }
    }

    private synchronized void updateAGV(AGV agv, List<String> tasks) {
        connectionController.sendMessage((byte) 1, (byte) 5, agv.getId() + ";" + agv.getLocation().getX() + ";" + agv.getLocation().getY() + ";" + agv.getStatus().getAvailability(), agv.getPort());
        StringBuilder tasksString = new StringBuilder();
        for (String task : tasks) {
            tasksString.append(task).append(";");
        }
        connectionController.sendMessage((byte) 1, (byte) 6, tasksString.toString(), agv.getPort());
    }

    private static void assignTaskToAGV(AGV agv, String orderID) {
        AGVService agvService = new AGVService();
        OrderServices orderServices = new OrderServices();
        OrderLevel orderLevel = new OrderLevel(OrderLevel.Level.ASSIGNED);
        try {
            orderServices.findbyid(orderID);
        } catch (Exception e) {
            return;
        }
        if (orderServices.findbyid(orderID) == null) {
            return;
        }
        orderServices.findbyid(orderID).setOrderLevel(orderLevel);
        orderServices.updateOrders(orderServices.findbyid(orderID));
        agv.addTask(orderID);
        agvService.updateAGV(agv);
    }
}
