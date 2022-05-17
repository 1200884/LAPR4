package eapli.base.warehousemanagement.Domain;

import eapli.framework.domain.model.AggregateRoot;
import eapli.framework.domain.model.DomainEntity;

import javax.persistence.*;
import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

@Entity
public class Warehouse implements Serializable, DomainEntity<Long>, AggregateRoot<Long> {
    @Id
    @GeneratedValue
    private Long id;
    private Long width;
    private Long length;
    private Long square;
    private String unit;
    @OneToMany (cascade = CascadeType.ALL)
    private Set<Aisle> aisle = new HashSet<>();
    @ElementCollection
    private Set<AGVDocks> docks = new HashSet<>();

    protected Warehouse(){

    }

    public Warehouse(Long length,Long width,Long square,String unit){
        this.width=width;
        this.length=length;
        this.square=square;
        this.unit=unit;
    }

    @Override
    public boolean sameAs(Object other) {
        return false;
    }

    @Override
    public Long identity() {
        return null;
    }

    public void addAisle(Aisle aisle){
        this.aisle.add(aisle);
    }

    public void addDock(AGVDocks docks){
        this.docks.add(docks);
    }

    public Long getId() {
        return id;
    }

    public Long getSquare() {
        return square;
    }

    public Set<AGVDocks> getDocks() {
        return docks;
    }

    public Set<Aisle> getAisle() {
        return aisle;
    }

    public void setAisle(Set<Aisle> aisle) {
        this.aisle = aisle;
    }

    public void setDocks(Set<AGVDocks> docks) {
        this.docks = docks;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setSquare(Long square) {
        this.square = square;
    }

    public void setUnit(String unit) {
        this.unit = unit;
    }

    public String getUnit() {
        return unit;
    }

    public Long getWidth() {
        return width;
    }

    public Long getLength() {
        return length;
    }

    public void setWidth(Long width) {
        this.width = width;
    }

    public void setLength(Long length) {
        this.length = length;
    }

    @Override
    public String toString() {
        return "Warehouse: id=" + id + ", dimensions=" + width +", square=" + square +", unit='" + unit;
    }
}
