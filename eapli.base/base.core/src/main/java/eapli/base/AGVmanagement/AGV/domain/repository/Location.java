package eapli.base.AGVmanagement.AGV.domain.repository;

import eapli.framework.domain.model.AggregateRoot;
import eapli.framework.domain.model.Immutable;
import eapli.framework.domain.model.ValueObject;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.Table;
import javax.persistence.criteria.CriteriaBuilder;

@Embeddable
@Immutable
@Table(name="Location")
public class Location implements ValueObject {
    @Column(name = "x")
    private int x;
    @Column(name = "y")
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
