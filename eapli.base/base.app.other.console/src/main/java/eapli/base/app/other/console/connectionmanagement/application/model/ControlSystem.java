package eapli.base.app.other.console.connectionmanagement.application.model;

import java.util.ArrayList;
import java.util.List;

public class ControlSystem implements Runnable {

    private SharedMemory sharedMemory;
    private List<String> orders;
    private boolean isComingBack = false;

    public ControlSystem(SharedMemory sharedMemory, List<String> orders) {
        this.orders = orders;
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
                sharedMemory.setSpeed(1);
            }else if (sharedMemory.getIsThereObstacle()[1]) {
                sharedMemory.setSpeed(0);
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                sharedMemory.setSpeed(1);
            }else {
                sharedMemory.setSpeed(2);
            }

            if (sharedMemory.getX() == sharedMemory.getFinalX() && sharedMemory.getY() == sharedMemory.getFinalY() && !isComingBack) {
                System.out.println("The AGV arrived at the destination");
                sharedMemory.setFinalX(0);
                sharedMemory.setFinalY(0);
                this.isComingBack = true;
            }

            if (sharedMemory.getX() == sharedMemory.getFinalX() && sharedMemory.getY() == sharedMemory.getFinalY() && isComingBack) {
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
