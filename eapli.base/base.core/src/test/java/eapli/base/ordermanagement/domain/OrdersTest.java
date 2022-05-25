package eapli.base.ordermanagement.domain;

import eapli.base.customermanagement.domain.model.Shopping_Cart;
import org.junit.Assert;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class OrdersTest {

    @Test
    void generateTime() {
    }

    @Test
    void isValidId() {

    }

    @Test
    void generateId() {
        Orders order = new Orders("Rua das Flores", new Shopping_Cart(), new Shipment_Method(Shipment_Method.ShipmentMethod.EXPRESS), new Payment_Method(Payment_Method.PaymentMethod.CREDITCARD));
        String id=order.getId();
        Assert.assertEquals(order.getId(),id);
    }
}