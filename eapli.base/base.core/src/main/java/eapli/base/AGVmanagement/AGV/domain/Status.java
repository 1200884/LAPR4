package eapli.base.AGVmanagement.AGV.domain;


import eapli.framework.domain.model.Immutable;
import eapli.framework.domain.model.ValueObject;

import javax.persistence.ElementCollection;
import javax.persistence.Embeddable;

import java.util.*;

@Embeddable
@Immutable
public class Status implements ValueObject {
    private int battery_left;
    @ElementCollection
    private Set<String> task=new HashSet<>();
    public enum Availability{
        AVAILABLE,
        WORKING
    }
    private Availability availability;

    public Availability getAvailability() {
        return availability;

    }

    public void setAvailability(Availability availability) {
        this.availability = availability;
    }

    protected Status() {
    }

    public Status(int battery_left, String task) {
        this.battery_left = battery_left;
        addTask(task);
        if (this.task.size()>1){
            setAvailability(Availability.WORKING);
        }

    }

    public Set<String> gettasks() {

        return this.task;
    }

    public int numberoftasks() {
        return gettasks().size();
    }

    public boolean hastasks() {
        return !this.task.isEmpty();
    }

    public void removetask(String orderid) {
        this.task.removeIf(order -> order.equals(orderid));
        if (this.task.size()>1){
            setAvailability(Availability.WORKING);
        }
        if (this.task.size()<1){
            setAvailability(Availability.AVAILABLE);
        }
    }

    public boolean hasOrder(String orderid) {
        for (String order:this.task) {
            if (order.equals(orderid)) {
                return true;
            }
        }
        return false;
    }

    public int getBattery_left() {
        return battery_left;
    }

    public void addTask(String task) {
        this.task.add(task);
        if (this.task.size()>1){
            setAvailability(Availability.WORKING);
        }
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
