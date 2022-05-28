package eapli.base.AGVmanagement.AGV.domain.repository;

import eapli.framework.domain.model.Immutable;
import eapli.framework.domain.model.ValueObject;

import javax.persistence.Embeddable;

@Embeddable
@Immutable
public class Location implements ValueObject {
    private int x;
    private int y;

    public Location(int x, int y){
        this.x=x;
        this.y=y;
    }

    protected Location() {

    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public void setX(int x) {
        this.x = x;
    }

    public void setY(int y) {
        this.y = y;
    }

    @Override
    public String toString() {
        return "Location{" +
                "x=" + x +
                ", y=" + y +
                '}';
    }
}
