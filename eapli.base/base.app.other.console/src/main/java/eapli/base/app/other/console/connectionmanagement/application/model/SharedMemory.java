package eapli.base.app.other.console.connectionmanagement.application.model;

import java.util.Arrays;
import java.util.List;

public class SharedMemory {

    private int id;
    private int x;
    private int y;
    private int finalX;
    private int finalY;
    private double speed;
    private int battery = 100;
    private int[][] sensorsInfo;
    private int[][] map;
    private List<Position> path;
    private boolean[] isThereObstacle;
    private List<String> orders;

    private boolean isComingBack = false;
    private boolean isDone = false;

    public SharedMemory() {

    }

    public SharedMemory(int id, int x, int y, int finalX, int finalY, int speed, int[][] sensorsInfo, int[][] map, List<Position> path, boolean[] isThereObstacle, List<String> orders) {
        this.id = id;
        this.x = x;
        this.y = y;
        this.finalX = finalX;
        this.finalY = finalY;
        this.speed = speed;
        this.sensorsInfo = sensorsInfo;
        this.map = map;
        this.path = path;
        this.isThereObstacle = isThereObstacle;
        this.orders = orders;
    }

    public int getId() {
        return id;
    }

    public synchronized void setId(int id) {
        this.id = id;
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

    public double getSpeed() {
        return speed;
    }

    public synchronized void setSpeed(double speed) {
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

    public void setOrders(List<String> orders) {
        this.orders = orders;
    }

    public synchronized List<String> getOrders() {
        return orders;
    }

    public void setIsComingBack(boolean comingBack) {
        isComingBack = comingBack;
    }

    public synchronized boolean getIsComingBack() {
        return isComingBack;
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
