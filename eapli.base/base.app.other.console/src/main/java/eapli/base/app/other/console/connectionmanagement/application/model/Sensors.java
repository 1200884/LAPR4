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
            for (Sensor sensor : sensors) {
                boolean isThereClose = sensor.checkClose(sharedMemory.getX(), sharedMemory.getY(), sharedMemory.getMap()) >= 1;
                boolean isThereFurther = sensor.checkFurther(sharedMemory.getX(), sharedMemory.getY(), sharedMemory.getMap()) >= 1;
                sharedMemory.getIsThereObstacle()[1] = isThereClose;
                sharedMemory.getIsThereObstacle()[0] = isThereFurther;
            }
        } while (!sharedMemory.getDone());
    }
}
