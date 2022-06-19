package eapli.base.app.other.console.connectionmanagement.application.model;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.InetAddress;
import java.net.Socket;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class AGVDigitalTwinHandler implements Runnable {

    private int agvID;
    private int posX = 0;
    private int posY = 0;
    private List<String> tasks = new ArrayList<>();
    private String status = "Available";
    private int[][] map;

    private final Socket socket;
    private DataOutputStream sOut;
    private DataInputStream sIn;

    public AGVDigitalTwinHandler(Socket socket) {
        this.socket = socket;
    }

    @Override
    public void run() {
        boolean check = true;
        byte version, code, length1, length2;
        InetAddress clientIP = socket.getInetAddress();
        System.out.println("New client connection from " + clientIP.getHostAddress() + ", port number " + socket.getPort());

        SharedMemory sharedMemory = new SharedMemory();

        try {
            sOut = new DataOutputStream(socket.getOutputStream());
            sIn = new DataInputStream(socket.getInputStream());
            do {
                String s = null;
                byte[] message = new byte[1023];
                sIn.read(message);
                version = message[0];
                if (version == 1) {
                    code = message[1];
                    length1 = message[2];
                    length2 = message[3];
                    if (length1 != 0 || length2 != 0) {
                        int finalLength = length1 + (256 * length2);
                        byte[] dataArray = new byte[finalLength];
                        System.arraycopy(message, 4, dataArray, 0, finalLength);
                        s = new String(dataArray, StandardCharsets.UTF_8);
                    }
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
                        case 3://returnin the amount of the tasks the agv has
                            System.out.println("AGVID " + agvID);
                            System.out.println("size " + tasks.size());
                            sOut.write(ServerFunctions.sendMessage(1, code, agvID + ";" + tasks.size()));
                            break;
                        case 4://adding task to the task list
                            if (s != null) {
                                String[] strings = s.split(";", -2);
                                String agvID = strings[0];
                                if (Objects.equals(agvID, String.valueOf(this.agvID))) {
                                    System.out.println("This is the right agv");
                                    tasks.add(strings[1]);
                                    this.status = "Working";

                                    assignTask(sharedMemory);
                                    sOut.write(ServerFunctions.sendMessage(1, 4, "Success"));
                                } else {
                                    System.out.println("This is not the wanted agv");
                                    sOut.write(ServerFunctions.sendMessage(1, 4, "No Success"));
                                }
                            } else {
                                System.out.println("The data you sent is empty");
                            }
                            break;
                        case 5://codigo para lhe atribuir as coisas, a sua posicao e id
                            if (s != null) {
                                String[] strings = s.split(";", -2);
                                this.agvID = Integer.parseInt(strings[0]);
                                this.posX = Integer.parseInt(strings[1]);
                                this.posY = Integer.parseInt(strings[2]);
                                this.status = strings[3];
                            }
                            System.out.println("AGV " + this.agvID + " atualizado");
                            break;
                        case 6://dar assign as tasks
                            if (s != null) {
                                String[] strings = s.split(";", -2);
                                for (String string : strings) {
                                    if (!string.equals("null") && !string.equals("")) {
                                        this.tasks.add(string);
                                    }
                                }
                                if (this.tasks.size() >= 1) {
                                    assignTask(sharedMemory);
                                }
                            }
                            System.out.println("AGV " + this.agvID + " com tasks atualizadas");

                            break;
                        case 7://ir buscar a sua localizacao
                            sOut.write(ServerFunctions.sendMessage(1, 7, posX + ":" + posY));
                            break;
                        default:
                            System.out.println("There is no functionality for this code");
                    }
                }
            } while (check);

            System.out.println("Client " + clientIP.getHostAddress() + ", port number: " + socket.getPort() + " disconnected");
            sOut.close();
            sIn.close();
            socket.close();
        } catch (IOException ex) {
            ex.printStackTrace();
            System.out.println(ex);
            System.out.println("There was a problem with the input/output streams");
        }
    }

    private void assignTask(SharedMemory sharedMemory) {
        List<String> tasksCoords = new ArrayList<>();
        for (int i = 0; i < tasks.size(); i++) {
            int finalX = 15;
            int finalY = 15;
            sharedMemory.setFinalX(finalX);
            sharedMemory.setFinalY(finalY);
            String coords = finalX + ":" + finalY;
            tasksCoords.add(coords);
        }
        sharedMemory.setOrders(tasksCoords);
        boolean[] isThereObstacle = {false, false};
        sharedMemory.setId(agvID);
        sharedMemory.setIsThereObstacle(isThereObstacle);
        sharedMemory.setX(posX);
        sharedMemory.setY(posY);

        int[][] sensorsInfo = new int[5][5];
        sharedMemory.setSensorsInfo(sensorsInfo);

        SimulationEngine simulationEngine = new SimulationEngine(sharedMemory);
        Thread simulationEngineThread = new Thread(simulationEngine);
        simulationEngineThread.start();

        ControlSystem controlSystem = new ControlSystem(sharedMemory);
        Thread sensorsThread = new Thread(controlSystem);
        sensorsThread.start();
    }
}
