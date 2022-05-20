package eapli.base.AGVmanagement.AGV.domain;


import eapli.framework.domain.model.Immutable;
import eapli.framework.domain.model.ValueObject;

import javax.persistence.Embeddable;

import java.util.Objects;

@Embeddable
@Immutable
public class Status implements ValueObject {
    private int battery_left;
    private String task;

    public Status() {
    }

    public Status(int battery_left, String task) {
        this.battery_left = battery_left;
        this.task = task;
    }

    public String getTask() {
        return task;
    }

    public int getBattery_left() {
        return battery_left;
    }

    private void setTask(String task) {
        this.task = task;
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
