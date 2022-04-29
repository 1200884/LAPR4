package eapli.base.AGVmanagement.AGV.domain;

import javax.persistence.*;

@Entity
public class AGV {
    @Id
    @GeneratedValue
    private int id;
    int maximum_weight;
    private String shortDescription;
    private String baseLocation;
    @ManyToOne
    private Model model;
    @Embedded
    private Status status;

    protected AGV() {
    }

    public AGV(int maximum_weight, String baseLocation, String shortDescription, Model model) {
        this.maximum_weight = maximum_weight;
        this.shortDescription = shortDescription;
        this.model = model;
        this.baseLocation = baseLocation;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getId() {
        return id;
    }

    public int getMaximum_weight() {
        return maximum_weight;
    }

    public Model getModel() {
        return model;
    }

    public String getShortDescription() {
        return shortDescription;
    }

    public void setMaximum_weight(int maximum_weight) {
        this.maximum_weight = maximum_weight;
    }

    public void setModel(Model model) {
        this.model = model;
    }

    public void setShortDescription(String short_description) {
        this.shortDescription = short_description;
    }
}
