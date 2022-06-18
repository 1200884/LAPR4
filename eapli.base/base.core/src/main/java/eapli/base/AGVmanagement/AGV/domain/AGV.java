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
    private int port = 0;
    @ManyToOne(cascade = CascadeType.PERSIST)
    private Model model;
  @Embedded
  //  @OneToOne(cascade = CascadeType.ALL,fetch = FetchType.EAGER)
    private Status status;
    @Embedded
    private Location location;
    private int velocity;
    private static final int DEFAULTVELOCITY = 2;
    private static final int REDUCEDVELOCITY = 1;
    private int batteryleft;
    private static final int BATTERYFULLYCHARGED=1000;//minutes
    protected AGV() {
    }

    public AGV(double maximum_weight, String baseLocation, String shortDescription, Model model, Status status) {
        this.id = Integer.parseInt(generateId());
        this.maximum_weight = maximum_weight;
        this.shortDescription = shortDescription;
        this.model = model;
        this.velocity = 0;
        this.baseLocation = baseLocation;
        this.status = status;
        this.status.setAvailability(Status.Availability.AVAILABLE);
        Location location = new Location(0, 0);
        this.location = location;
        this.batteryleft=BATTERYFULLYCHARGED;
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

    public int getPort() {
        return port;
    }

    public void setPort(int port) {
        this.port = port;
    }

    public void addTask(String task) {
        this.velocity = DEFAULTVELOCITY;
        this.status.addTask(task);

    }

    public void removeTask(String task) {
        this.status.removetask(task);
        //this.getLocation().setX(randomiselocationx());
        //this.getLocation().setY(randomiselocationy());
        if (getagvtasks().size() == 0) {
            this.setLocation(new Location(0, 0));
        }
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

    public int getVelocity() {
        return velocity;
    }

    public void setVelocity(int velocity) {
        this.velocity = velocity;
    }

    public static int randomiselocationx() {
        Random rnd = new Random();
        int number = rnd.nextInt(20);
        return number;
    }

    public static int randomiselocationy() {
        Random rnd = new Random();
        int number = rnd.nextInt(18);
        return number;
    }

    public boolean moveRight() {
        this.batteryleft=batteryleft-1;
        if (firstrow(getLocation().getX() + 1, getLocation().getY()) && secondrow(getLocation().getX() + 1, getLocation().getY()) && thirdrow(getLocation().getX() + 1, getLocation().getY()) && fourthrow(getLocation().getX() + 1, getLocation().getY())) {
            this.setVelocity(0);
            //ou agv
            return true;
        }
        if (firstrow(getLocation().getX() + 2, getLocation().getY()) && secondrow(getLocation().getX() + 2, getLocation().getY()) && thirdrow(getLocation().getX() + 2, getLocation().getY()) && fourthrow(getLocation().getX() + 2, getLocation().getY())) {
            this.setVelocity(REDUCEDVELOCITY);
        }
        setLocation(new Location(getLocation().getX() + 1, getLocation().getY()));
        return false;
    }
    public boolean moveLeft() {
        this.batteryleft=batteryleft-1;
        if (firstrow(getLocation().getX() - 1, getLocation().getY()) && secondrow(getLocation().getX() - 1, getLocation().getY()) && thirdrow(getLocation().getX() - 1, getLocation().getY()) && fourthrow(getLocation().getX() - 1, getLocation().getY())) {
            this.setVelocity(0);
            return true;
        }
        if (firstrow(getLocation().getX() - 2, getLocation().getY()) && secondrow(getLocation().getX() - 2, getLocation().getY()) && thirdrow(getLocation().getX() - 2, getLocation().getY()) && fourthrow(getLocation().getX() - 2, getLocation().getY())) {
            this.setVelocity(REDUCEDVELOCITY);
        }
        setLocation(new Location(getLocation().getX() - 1, getLocation().getY()));
        return false;
    }

    public boolean moveUp() {
        this.batteryleft=batteryleft-1;
        if (firstrow(getLocation().getX(), getLocation().getY() + 1) && secondrow(getLocation().getX(), getLocation().getY() + 1) && thirdrow(getLocation().getX(), getLocation().getY() + 1) && fourthrow(getLocation().getX(), getLocation().getY() + 1)) {
            this.setVelocity(0);
            return true;
        }
        if (firstrow(getLocation().getX(), getLocation().getY() + 2) && secondrow(getLocation().getX(), getLocation().getY() + 2) && thirdrow(getLocation().getX(), getLocation().getY() + 2) && fourthrow(getLocation().getX(), getLocation().getY() + 2)) {
            this.setVelocity(REDUCEDVELOCITY);
        }
        setLocation(new Location(getLocation().getX(), getLocation().getY() + 1));
        return false;
    }
    public boolean moveDown() {
        this.batteryleft=batteryleft-1;
        if (firstrow(getLocation().getX(), getLocation().getY() - 1) && secondrow(getLocation().getX(), getLocation().getY() - 1) && thirdrow(getLocation().getX(), getLocation().getY() - 1) && fourthrow(getLocation().getX(), getLocation().getY() - 1)) {
            this.setVelocity(0);
            return true;
        }
        if (firstrow(getLocation().getX(), getLocation().getY() - 2) && secondrow(getLocation().getX(), getLocation().getY() - 2) && thirdrow(getLocation().getX(), getLocation().getY() - 2) && fourthrow(getLocation().getX(), getLocation().getY() - 2)) {
            this.setVelocity(REDUCEDVELOCITY);
        }
        setLocation(new Location(getLocation().getX(), getLocation().getY() - 1));
        return false;
    }


    public boolean firstrow(int x, int y) {
        return x > 3 && y == 1 && x < 16;
    }

    public boolean secondrow(int x, int y) {
        return x > 3 && y == 8 && x < 16;
    }

    public boolean thirdrow(int x, int y) {
        return x > 3 && y == 11 && x < 16;
    }

    public boolean fourthrow(int x, int y) {
        return x > 3 && y == 18 && x < 16;
    }
}
