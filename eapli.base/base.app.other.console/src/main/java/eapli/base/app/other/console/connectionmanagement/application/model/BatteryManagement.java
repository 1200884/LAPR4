package eapli.base.app.other.console.connectionmanagement.application.model;

public class BatteryManagement implements Runnable {

    private SharedMemory sharedMemory;

    public BatteryManagement(SharedMemory sharedMemory) {
        this.sharedMemory = sharedMemory;
    }

    @Override
    public void run() {
        do {
            double speed = sharedMemory.getSpeed();
            if (speed != 0) {
                sharedMemory.setBattery((int) (sharedMemory.getBattery() - speed));
            }
            if (sharedMemory.getX() == 0 && sharedMemory.getY() == 0) {
                sharedMemory.setBattery(sharedMemory.getBattery() + 2);
            }
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        } while (!sharedMemory.getDone());
    }
}
