package eapli.base.modelmanagement.Model.domain;

import eapli.base.AGVmanagement.AGV.domain.AGV;
import eapli.base.productmanagement.Product.domain.Product;
import eapli.framework.domain.model.AggregateRoot;
import eapli.framework.domain.model.ValueObject;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Collection;

@Entity
public class Model implements ValueObject, AggregateRoot<Integer> {
    @Id
    @GeneratedValue
    private int id;
    private String name;
    private String description;

    @OneToMany(cascade = CascadeType.ALL)
    private Collection<AGV> AGVs = new ArrayList<>();

    protected Model() {
    }

    public Model(String name, String description) {
        this.name = name;
        this.description = description;
    }

    public int getId() {
        return id;
    }

    public String getDescription() {
        return description;
    }

    public String getName() {
        return name;
    }

    public void addAGV(AGV agv) {
        AGVs.add(agv);
    }

    @Override
    public String toString() {
        return "ID: " + id + "\nName: " + name + "\nDescription: " + description;
    }

    @Override
    public boolean sameAs(Object other) {
        return false;
    }

    @Override
    public Integer identity() {
        return null;
    }
}
