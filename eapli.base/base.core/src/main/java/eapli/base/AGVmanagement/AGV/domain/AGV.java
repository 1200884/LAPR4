package eapli.base.AGVmanagement.AGV.domain;

import eapli.base.AGVmanagement.AGV.application.AGVService;
import eapli.base.AGVmanagement.AGV.domain.repository.Location;
import eapli.base.modelmanagement.Model.domain.Model;

import eapli.framework.domain.model.AggregateRoot;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;
import java.util.Random;

@Entity
public class AGV implements Serializable, AggregateRoot<Integer> {
    @Id
    private int id;
    double maximum_weight;
    private String shortDescription;
    private String baseLocation;
    @ManyToOne(cascade = CascadeType.PERSIST)
    private Model model;
    @Embedded
    private Status status;
    @Embedded
    private Location location;

    protected AGV() {
    }

    public AGV(double maximum_weight, String baseLocation, String shortDescription, Model model, Status status) {
        this.id = Integer.parseInt(generateId());
        this.maximum_weight = maximum_weight;
        this.shortDescription = shortDescription;
        this.model = model;
        this.baseLocation = baseLocation;
        this.status = status;
        this.status.setAvailability(Status.Availability.AVAILABLE);
        Location location = new Location(randomiselocation(), randomiselocation());
        this.location = location;
    }

    public Status getStatus() {
        return status;
    }

    public boolean hastasks() {
        return this.status.hastasks();
    }

    public int numberoftasks() {
        return this.status.numberoftasks();
    }

    public List<String> getagvtasks() {
        return this.status.gettasks();
    }

    public boolean hasOrder(String orderid) {
        return this.status.hasOrder(orderid);
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getId() {
        return id;
    }

    public void addTask(String task) {
        this.status.addTask(task);
        this.getLocation().setX(randomiselocation());
    }

    public void removeTask(String task) {
        this.status.removetask(task);
        this.getLocation().setY(randomiselocation());
    }

    public static String generateId() {
        Random rnd = new Random();
        int number = 0;
        String number2 = "";
        while (number2.length() != 9) {
            number = rnd.nextInt(999999999);
            number2 = String.valueOf(number);
        }
        return number2;
    }

    public double getMaximum_weight() {
        return maximum_weight;
    }

    public void setLocation(Location location) {
        this.location = location;
    }

    public Location getLocation() {
        return location;
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

    public String getBaseLocation() {
        return baseLocation;
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
        return "ID: " + id + "\nMax Weight: " + maximum_weight + "\nDescription: " + shortDescription + "\nBase Location: " + baseLocation + "\nModel:\n" + model + "\nStatus:\n" + status.gettasks();
    }

    public static int randomiselocation() {
        Random rnd = new Random();
        int number = rnd.nextInt(20);
        return number;
    }
}
