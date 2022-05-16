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
    @Embedded
    private Dimensions dimensions;
    private Long square;
    private String unit;
    @ElementCollection
    private Set<Aisle> aisle = new HashSet<>();
    @ElementCollection
    private Set<Row> rows = new HashSet<>();
    @ElementCollection
    private Set<AGVDocks> docks = new HashSet<>();

    protected Warehouse(){

    }

    public Warehouse(Long length,Long width,Long square,String unit){
        this.dimensions=new Dimensions(width,length);
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

    public Dimensions getDimensions() {
        return dimensions;
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

    public void setDimensions(Dimensions dimensions) {
        this.dimensions = dimensions;
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

    public Set<Row> getRows() {
        return rows;
    }

    public void setRows(Set<Row> rows) {
        this.rows = rows;
    }

    public void addRow(Row row){
        this.rows.add(row);
    }

    @Override
    public String toString() {
        return "Warehouse: id=" + id + ", dimensions=" + dimensions +", square=" + square +", unit='" + unit;
    }
}
