package eapli.base.app.other.console.connectionmanagement.application.model;

public class Sensors implements Runnable {

    private Sensor[] sensors = new Sensor[8];
    private SharedMemory sharedMemory;

    public Sensors() {

    }

    public Sensors(SharedMemory sharedMemory) {
        for (int i = 0; i < sensors.length; i++) {
            sensors[i] = new Sensor(i);
        }
        this.sharedMemory = sharedMemory;
    }

    @Override
    public void run() {
        do {
            sharedMemory.getIsThereObstacle()[0] = false;
            sharedMemory.getIsThereObstacle()[1] = false;
            for (Sensor sensor : sensors) {
                boolean isThereClose = sensor.checkClose(sharedMemory.getX(), sharedMemory.getY(), sharedMemory.getMap()) == 0;
                boolean isThereFurther = sensor.checkFurther(sharedMemory.getX(), sharedMemory.getY(), sharedMemory.getMap()) == 0;
                sharedMemory.getIsThereObstacle()[1] = isThereClose;
                sharedMemory.getIsThereObstacle()[0] = isThereFurther;
            }
            try {
                Thread.sleep((long) (1000 * (1 / sharedMemory.getSpeed())));
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        } while (!sharedMemory.getDone());
    }
}
