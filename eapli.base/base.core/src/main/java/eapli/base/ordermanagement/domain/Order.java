package eapli.base.ordermanagement.domain;

import eapli.framework.domain.model.AggregateRoot;
import eapli.framework.domain.model.DomainEntity;

import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.Id;
import java.io.Serializable;

@Entity
public class Order implements Serializable, DomainEntity<Integer>, AggregateRoot<Integer> {
    @Id
    private int id;

    private String time;
    private String address;
    @Embedded
    private Shipment_Method shipmentMethod;
    @Embedded
    private Payment_Method payment_method;
    @Embedded
    private Price price;
    /* @Embedded
     Carrier(?)*/

    private static final int IDLENGTH=9;
    //9 digitos regra de negócio
    protected Order() {
    }

    public Order(int id, String time, String address, Shipment_Method shipmentMethod, Payment_Method payment_method, Price price) {
        this.id=id;
        this.time=time;
        this.address=address;
        this.shipmentMethod=shipmentMethod;
        this.payment_method=payment_method;
        this.price=price;
    }

    public int getId() {
        return id;
    }

    public Price getPrice() {
        return price;
    }

    public Payment_Method getPayment_method() {
        return payment_method;
    }

    public Shipment_Method getShipmentMethod() {
        return shipmentMethod;
    }

    public String getAddress() {
        return address;
    }

    public String getTime() {
        return time;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setShipmentMethod(Shipment_Method shipmentMethod) {
        this.shipmentMethod = shipmentMethod;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public void setPayment_method(Payment_Method payment_method) {
        this.payment_method = payment_method;
    }

    public void setPrice(Price price) {
        this.price = price;
    }

    public void setTime(String time) {
        this.time = time;
    }
     public static boolean isValidId(String id){
        if(id.length()==IDLENGTH){
            for(int i=0;i<IDLENGTH;i++){
                if(!(id.charAt(i)>='0'&&id.charAt(i)<='9')){
                    return false;
                }
            }
            return true;
        }
        return false;
     }




    @Override
    public String toString() {
        return "Order{" +
                "id=" + id +
                ", time='" + time + '\'' +
                ", address='" + address + '\'' +
                ", shipmentMethod=" + shipmentMethod +
                ", payment_method=" + payment_method +
                ", price=" + price +
                '}';
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