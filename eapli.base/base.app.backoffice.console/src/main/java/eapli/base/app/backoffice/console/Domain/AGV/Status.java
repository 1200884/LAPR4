package eapli.base.app.backoffice.console.Domain.AGV;


import eapli.framework.domain.model.Immutable;
import eapli.framework.domain.model.ValueObject;

import javax.persistence.Embeddable;

import java.util.Objects;

@Embeddable
@Immutable
public class Status implements ValueObject {
    private int time_left;
    private String task;
    private int time_left_default=0;
    private String task_default="No task available";
    public Status() {
    }

    public Status(int time_left, String task) {
        this.time_left = time_left;
        this.task = task;
    }

    public String getTask() {
        return task;
    }

    public int getTime_left() {
        return time_left;
    }

    @Override
    public String toString() {
        return "Status{" +
                "time_left='" + time_left + '\'' +
                ", task='" + task + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Status status = (Status) o;
        return Objects.equals(time_left, status.time_left) && Objects.equals(task, status.task);
    }


    @Override
    public int hashCode() {
        return Objects.hash(time_left, task);
    }
}
