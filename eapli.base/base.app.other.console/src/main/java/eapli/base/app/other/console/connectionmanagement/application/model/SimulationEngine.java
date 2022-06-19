package eapli.base.app.other.console.connectionmanagement.application.model;

import eapli.base.app.other.console.connectionmanagement.application.ConnectionController;

import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.List;

public class SimulationEngine implements Runnable {

    private SharedMemory sharedMemory;
    private ConnectionController connectionController;

    public SimulationEngine() {

    }

    public SimulationEngine(SharedMemory sharedMemory) {
        this.sharedMemory = sharedMemory;
        connectionController = new ConnectionController();
        connectionController.establishAGVManagerConnection();
        connectionController.sendMessage((byte) 1, (byte) 8, "", 0);
        String[] line = connectionController.receiveMessage(0).split(";", -2);
        String[] pos = line[4].split(":", -2);
        List<int[]> provisoryList = new ArrayList<>();//20

        do {
            int[] provisoryInt = new int[pos.length - 1];//18
            for (int i = 0; i < provisoryInt.length - 1; i++) {
                provisoryInt[i] = Integer.parseInt(pos[i]);
            }
            provisoryList.add(provisoryInt);
            line = connectionController.receiveMessage(0).split(";", -2);
            pos = line[4].split(":", -2);

        } while (line[1].equals("8"));

        int[][] map = new int[provisoryList.size()][provisoryList.get(0).length];
        for (int i = 0; i < provisoryList.size(); i++) {
            for (int j = 0; j < provisoryList.get(0).length; j++) {
                map[i][j] = provisoryList.get(i)[j];
            }
        }

        /*System.out.println("========================================");

        for (int j = 0; j < map.length; j++) {
            for (int k = 0; k < map[0].length; k++) {
                System.out.print(map[j][k]);
            }
            System.out.println();
        }

        System.out.println("========================================");*/

        sharedMemory.setMap(map);
    }

    @Override
    public void run() {
        do {
            connectionController.sendMessage((byte) 1, (byte) 7, "", 0);
            String[] fullMessage = connectionController.receiveMessage(0).split(";", -2);
            String[] positions = fullMessage[4].split(";", -2);
            for (int i = 0; i < positions.length - 1; i++) {
                String[] XandY = positions[i].split(":", -2);
                sharedMemory.getMap()[Integer.parseInt(XandY[0])][Integer.parseInt(XandY[1])] = 1;
            }
            for (int i = 0; i < sharedMemory.getSensorsInfo().length; i++) {
                for (int j = 0; j < sharedMemory.getSensorsInfo()[0].length; j++) {
                    try {
                        sharedMemory.getSensorsInfo()[i][j] = sharedMemory.getMap()[sharedMemory.getX() - 2 + i][sharedMemory.getY() - 2 + j];
                    } catch (Exception e) {
                        sharedMemory.getSensorsInfo()[i][j] = 1;
                    }
                }
            }
            try {
                Thread.sleep(100);
            } catch (Exception e) {

            }
        } while (!sharedMemory.getDone());
    }
}
