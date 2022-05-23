package eapli.base.ordermanagement.domain;

import eapli.base.customermanagement.domain.model.Shopping_Cart;
import eapli.base.ordermanagement.application.OrderServices;
import eapli.framework.domain.model.AggregateRoot;
import eapli.framework.domain.model.DomainEntity;
import org.aspectj.weaver.ast.Or;

import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.Id;
import java.io.Serializable;
import java.time.format.DateTimeFormatter;
import java.time.LocalDateTime;
import java.util.Random;


@Entity
public class Order implements Serializable, DomainEntity<String>, AggregateRoot<String> {

    @Id
    private String id;
    private String time;
    private String address;
    @Embedded
    private Shipment_Method shipmentMethod;
    @Embedded
    private Payment_Method payment_method;
    @Embedded
    private Price price;
    @Embedded
    private Shopping_Cart shopping_cart;
    @Embedded
    private OrderLevel orderLevel;
    /* @Embedded
     Carrier(?)*/
    private static final int IDLENGTH = 9;

    //9 digitos regra de negócio
    protected Order() {
    }

    public String generateTime() {
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");
        LocalDateTime now = LocalDateTime.now();
        return dtf.format(now);

    }

    public Order(String address, Shopping_Cart shopping_cart, Shipment_Method shipmentMethod, Payment_Method payment_method,OrderLevel orderLevel) {
        this.id = generateId();
        this.time = generateTime();
        this.address = address;
        this.shipmentMethod = shipmentMethod;
        this.payment_method = payment_method;
        this.shopping_cart=shopping_cart;
        this.orderLevel=orderLevel;
    }

    public OrderLevel getOrderLevel() {
        return orderLevel;
    }

    public void setOrderLevel(OrderLevel orderLevel) {
        this.orderLevel = orderLevel;
    }

    public String getId() {
        return id;
    }

    public Shopping_Cart getShopping_cart() {
        return shopping_cart;
    }

    public void setShopping_cart(Shopping_Cart shopping_cart) {
        this.shopping_cart = shopping_cart;
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

    public static boolean isValidId(String id) {
        if (id.length() == IDLENGTH) {
            for (int i = 0; i < IDLENGTH; i++) {
                if (!(id.charAt(i) >= '0' && id.charAt(i) <= '9')) {
                    return false;
                }
            }
            return true;
        }
        return false;
    }

    public static String generateId() {
        boolean flag=false;
        while(!flag) {
            Random rnd = new Random();
            int number = rnd.nextInt(999999999);
            if (!existsId(String.valueOf(number))) {
                flag=true;
                return String.format("%06d", number);
            }
        }
        return null;
    }

    public static boolean existsId(String id) {
        OrderServices orderServices = new OrderServices();
        return orderServices.existsid(id);
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
    public String identity() {
        return null;
    }
}