package eapli.base.app.other.console.connectionmanagement.application.model;

public class BatteryManagement implements Runnable {

    private SharedMemory sharedMemory;

    public BatteryManagement(SharedMemory sharedMemory) {
        this.sharedMemory = sharedMemory;
    }

    @Override
    public void run() {
        do {
            int speed = sharedMemory.getSpeed();
            if (speed != 0) {
                sharedMemory.setBattery(sharedMemory.getBattery()-speed);
            }
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }while (!sharedMemory.getDone());
    }
}
