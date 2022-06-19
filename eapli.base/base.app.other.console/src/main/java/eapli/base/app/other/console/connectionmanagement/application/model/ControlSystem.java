package eapli.base.app.other.console.connectionmanagement.application.model;

import java.util.ArrayList;
import java.util.List;

public class ControlSystem implements Runnable {

    private SharedMemory sharedMemory;

    public ControlSystem(SharedMemory sharedMemory) {
        this.sharedMemory = sharedMemory;
        List<Position> path = new ArrayList<>();
        sharedMemory.setPath(path);

        System.out.println("---------------------------------------");

        int[][] map = sharedMemory.getMap();
        for (int[] ints : map) {
            for (int k = 0; k < map[0].length; k++) {
                System.out.print(ints[k]);
            }
            System.out.println();
        }

        System.out.println("---------------------------------------");
        RoutePlanner routePlanner = new RoutePlanner(sharedMemory);
        Thread routePlannerThread = new Thread(routePlanner);
        routePlannerThread.start();

        Sensors sensors = new Sensors(sharedMemory);
        Thread sensorsThread = new Thread(sensors);
        sensorsThread.start();

        Positioning positioning = new Positioning(sharedMemory);
        Thread positioningThread = new Thread(positioning);
        positioningThread.start();

        BatteryManagement batteryManagement = new BatteryManagement(sharedMemory);
        Thread batteryManagementThread = new Thread(batteryManagement);
        batteryManagementThread.start();
    }

    @Override
    public void run() {
        do {
            if (sharedMemory.getIsThereObstacle()[0]) {
                sharedMemory.setSpeed(0.5);
            } else if (sharedMemory.getIsThereObstacle()[1]) {
                sharedMemory.setSpeed(0);
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                sharedMemory.setSpeed(0.5);
            } else {
                sharedMemory.setSpeed(1);
            }

            if (sharedMemory.getX() == sharedMemory.getFinalX() && sharedMemory.getY() == sharedMemory.getFinalY() && !sharedMemory.getIsComingBack()) {
                System.out.println("The AGV arrived at the destination");
                sharedMemory.getMap()[sharedMemory.getX()][sharedMemory.getY()] = 1;
                sharedMemory.setFinalX(0);
                sharedMemory.setFinalY(0);
                sharedMemory.getIsThereObstacle()[1] = true;
                sharedMemory.setIsComingBack(true);
            }

            if (sharedMemory.getX() == sharedMemory.getFinalX() && sharedMemory.getY() == sharedMemory.getFinalY() && sharedMemory.getIsComingBack()) {
                System.out.println("The AGV arrived at the dock");
                sharedMemory.setDone(true);
            }

            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        } while (!sharedMemory.getDone());
    }
}
