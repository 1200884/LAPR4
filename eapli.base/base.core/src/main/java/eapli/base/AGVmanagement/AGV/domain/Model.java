package eapli.base.AGVmanagement.AGV.domain;

import eapli.framework.domain.model.ValueObject;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Model implements ValueObject {
    @Id
    @GeneratedValue
    private int id;
    private String name;
    private String description;

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
}
