package eapli.base.AGVmanagement.AGV.domain;

import eapli.base.modelmanagement.Model.domain.Model;
import eapli.framework.domain.model.AggregateRoot;

import javax.persistence.*;
import java.io.Serializable;

@Entity
public class AGV implements Serializable, AggregateRoot<Integer> {
    @Id
    @GeneratedValue (strategy = GenerationType.SEQUENCE)
    private int id;
    double maximum_weight;
    private String shortDescription;
    private String baseLocation;

    @ManyToOne (cascade = CascadeType.PERSIST)
    private Model model;
    @Embedded
    private Status status;

    protected AGV() {
    }

    public AGV(double maximum_weight, String baseLocation, String shortDescription, Model model, Status status) {
        this.maximum_weight = maximum_weight;
        this.shortDescription = shortDescription;
        this.model = model;
        this.baseLocation = baseLocation;
        this.status = status;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getId() {
        return id;
    }

    public double getMaximum_weight() {
        return maximum_weight;
    }

    public Model getModel() {
        return model;
    }

    public void setModel(Model model) {
        this.model = model;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    public void setBaseLocation(String baseLocation) {
        this.baseLocation = baseLocation;
    }

    public String getShortDescription() {
        return shortDescription;
    }

    public void setMaximum_weight(int maximum_weight) {
        this.maximum_weight = maximum_weight;
    }

    public void setShortDescription(String short_description) {
        this.shortDescription = short_description;
    }

    @Override
    public boolean sameAs(Object other) {
        return false;
    }

    @Override
    public Integer identity() {
        return null;
    }

    @Override
    public String toString() {
        return "ID: " + id + "\nMax Weight: " + maximum_weight +"\nDescription: " + shortDescription +"\nBase Location: " + baseLocation + "\nModel:\n" + model + "\nStatus:\n" + status;
    }
}
