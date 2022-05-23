package eapli.base.AGVmanagement.AGV.domain;


import eapli.framework.domain.model.Immutable;
import eapli.framework.domain.model.ValueObject;

import javax.persistence.Embeddable;

import java.util.*;

@Embeddable
@Immutable
public class Status implements ValueObject {
    private int battery_left;
    private Map<String, Integer> task;

    public Status() {
    }

    public Status(int battery_left, String task, int tasktime) {
        this.battery_left = battery_left;
        addTask(task, tasktime);
    }

    public ArrayList<String> gettasks() {
        ArrayList<String> str = new ArrayList<>();
        for (Map.Entry<String, Integer> entry : task.entrySet()) {
            str.add(entry.getKey());
        }
        return str;
    }
    public int numberoftasks(){
        return gettasks().size();
    }

    public boolean hastasks(){
        return !this.task.isEmpty();
    }
    public void removelatesttask(){
        ArrayList<String> str = new ArrayList<>();
        for (Map.Entry<String, Integer> entry : task.entrySet()) {
            str.add(entry.getKey());
        }
        for (Map.Entry<String, Integer> entry : task.entrySet()) {
            if(Objects.equals(entry.getKey(), str.get(0))){
                this.task.remove(entry);
            }
        }
    }

    public int getBattery_left() {
        return battery_left;
    }

    public void addTask(String task, int tasktime) {
        this.task.put(task, tasktime);
    }

    private void setTask(String task) {
    }

    private void setBattery_left(int time_left) {
        this.battery_left = time_left;
    }

    @Override
    public String toString() {
        return "Task: " + task + "\nTime Left: " + battery_left;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Status status = (Status) o;
        return Objects.equals(battery_left, status.battery_left) && Objects.equals(task, status.task);
    }


    @Override
    public int hashCode() {
        return Objects.hash(battery_left, task);
    }
}
