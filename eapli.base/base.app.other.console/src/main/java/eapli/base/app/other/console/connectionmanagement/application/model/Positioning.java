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
                System.out.println(path);
                int speed = sharedMemory.getSpeed();
                if (path.size() > 1 && speed > 0) {
                    System.out.println("Proxima posicao " + path.get(1));
                    calculatePosition(path.get(1).getX(), path.get(1).getY());
                    path.remove(1);
                    System.out.println("Currently in position " + sharedMemory.getX() + ":" + sharedMemory.getY() + " with a speed of " + sharedMemory.getSpeed());
                    Thread.sleep(10000 * (1 / sharedMemory.getSpeed()));
                }
            } catch (InterruptedException ignored) {

            }
        } while (!sharedMemory.getDone());
    }

    public void calculatePosition(int directionX, int directionY) {
        System.out.println("directionX = " + directionX);
        System.out.println("directionY = " + directionY);
        sharedMemory.setX(directionX);
        sharedMemory.setY(directionY);
    }
}
