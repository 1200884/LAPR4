package eapli.base.app.backoffice.console.Domain.AGV;

import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class AGV {
    @Id
    @GeneratedValue
    private int id;
    int maximum_weight;
    private final int id_default = 0, maximum_weight_default = Integer.MAX_VALUE;
    private String model, short_description;
    private final String model_default = "No Model Available", short_descriptiondefault = "No description available";
    private String location;
    private final String location_default = "No location Available";
    @Embedded
    private Status status;

    protected AGV() {
        this.id = id_default;
        this.maximum_weight = maximum_weight_default;
        this.model = model_default;
        this.short_description = short_descriptiondefault;
        this.location = location_default;
    }

    public AGV(int maximum_weight, String location, String short_description, String model) {
        this.maximum_weight = maximum_weight;
        this.short_description = short_description;
        this.model = model;
        this.location = location;
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

    public String getModel() {
        return model;
    }

    public String getShort_description() {
        return short_description;
    }

    public void setMaximum_weight(int maximum_weight) {
        this.maximum_weight = maximum_weight;
    }

    public String getModel_default() {
        return model_default;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public void setShort_description(String short_description) {
        this.short_description = short_description;
    }
}
