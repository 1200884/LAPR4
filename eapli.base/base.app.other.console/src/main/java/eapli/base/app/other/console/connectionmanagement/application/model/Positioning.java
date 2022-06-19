package eapli.base.app.other.console.connectionmanagement.application.model;

import java.util.List;

public class Positioning implements Runnable {

    private SharedMemory sharedMemory;

    public Positioning() {
    }

    public Positioning(SharedMemory sharedMemory) {
        this.sharedMemory = sharedMemory;
    }

    @Override
    public void run() {
        do {
            try {
                List<Position> path = sharedMemory.getPath();
                double speed = sharedMemory.getSpeed();
                if (path.size() > 1 && speed > 0) {
                    System.out.println("=============================================");

                    int[][] map = sharedMemory.getMap();
                    for (int j = 0; j < map.length; j++) {
                        for (int k = 0; k < map[0].length; k++) {
                            if (j == sharedMemory.getX() && k == sharedMemory.getY()) {
                                System.out.print("\033[0;31m" + "@" + "\033[0m");
                            }else if (map[j][k]==0){
                                System.out.print("|");
                            }else{
                                System.out.print(".");
                            }
                        }
                        System.out.println();
                    }

                    System.out.println("=============================================");
                    sharedMemory.getMap()[sharedMemory.getX()][sharedMemory.getY()] = 1;
                    calculatePosition(path.get(1).getX(), path.get(1).getY());
                    sharedMemory.getMap()[sharedMemory.getX()][sharedMemory.getY()] = 0;
                    path.remove(1);
                    System.out.println("AGV " + sharedMemory.getId() + " moved to position " + sharedMemory.getX() + ":" + sharedMemory.getY() + " with a speed of " + sharedMemory.getSpeed());
                    System.out.println("=============================================");
                    Thread.sleep((long) (1000 * (1 / sharedMemory.getSpeed())));
                }
            } catch (InterruptedException ignored) {
                System.out.println(ignored);
            }
        } while (!sharedMemory.getDone());
    }

    public void calculatePosition(int directionX, int directionY) {
        sharedMemory.setX(directionX);
        sharedMemory.setY(directionY);
    }
}
