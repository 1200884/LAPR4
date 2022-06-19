package eapli.base.app.other.console.connectionmanagement.application.model;

import java.util.Arrays;
import java.util.List;

public class SharedMemory {

    private int x;
    private int y;
    private int finalX;
    private int finalY;
    private int speed;
    private int battery = 100;
    private int[][] sensorsInfo;
    private int[][] map;
    private List<Position> path;
    private boolean[] isThereObstacle;

    private boolean isDone = false;

    public SharedMemory() {

    }

    public SharedMemory(int x, int y, int finalX, int finalY, int speed, int[][] sensorsInfo, int[][] map, List<Position> path, boolean[] isThereObstacle) {
        this.x = x;
        this.y = y;
        this.finalX = finalX;
        this.finalY = finalY;
        this.speed = speed;
        this.sensorsInfo = sensorsInfo;
        this.map = map;
        this.path = path;
        this.isThereObstacle = isThereObstacle;
    }

    public int getX() {
        return x;
    }

    public synchronized void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public synchronized void setY(int y) {
        this.y = y;
    }

    public int getFinalX() {
        return finalX;
    }

    public synchronized void setFinalX(int finalX) {
        this.finalX = finalX;
    }

    public int getFinalY() {
        return finalY;
    }

    public synchronized void setFinalY(int finalY) {
        this.finalY = finalY;
    }

    public int getSpeed() {
        return speed;
    }

    public synchronized void setSpeed(int speed) {
        this.speed = speed;
    }

    public int getBattery() {
        return battery;
    }

    public synchronized void setBattery(int battery) {
        this.battery = battery;
    }

    public int[][] getSensorsInfo() {
        return sensorsInfo;
    }

    public synchronized void setSensorsInfo(int[][] sensorsInfo) {
        this.sensorsInfo = sensorsInfo;
    }

    public int[][] getMap() {
        return map;
    }

    public synchronized void setMap(int[][] map) {
        this.map = map;
    }

    public List<Position> getPath() {
        return path;
    }

    public synchronized void setPath(List<Position> path) {
        this.path = path;
    }

    public boolean[] getIsThereObstacle() {
        return isThereObstacle;
    }

    public synchronized void setIsThereObstacle(boolean[] isThereObstacle) {
        this.isThereObstacle = isThereObstacle;
    }

    public void setDone(boolean done) {
        isDone = done;
    }

    public synchronized boolean getDone() {
        return isDone;
    }

    @Override
    public String toString() {
        return "SharedMemory{" +
                "\nx=" + x +
                "\ny=" + y +
                "\nfinalX=" + finalX +
                "\nfinalY=" + finalY +
                "\nspeed=" + speed +
                "\nsensorsInfo=" + Arrays.toString(sensorsInfo) +
                "\nmap=" + Arrays.toString(map) +
                "\npath=" + path +
                "\nisThereObstacle=" + Arrays.toString(isThereObstacle) +
                "\n}";
    }
}
