package eapli.base.ordermanagement.domain;

import eapli.base.customermanagement.domain.model.Shopping_Cart;
import org.junit.Assert;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class OrdersTest {

    @Test
    void ensureIdHas9Letters() {
        Orders order = new Orders("Rua das Flores", new Shopping_Cart(0), new Shipment_Method(Shipment_Method.ShipmentMethod.EXPRESS), new Payment_Method(Payment_Method.PaymentMethod.CREDITCARD));
        Assert.assertTrue(order.getId().length()==9);
    }

    @Test
    void ensureMustHaveAddress() {
        assertThrows(IllegalArgumentException.class, () -> new Orders(null, new Shopping_Cart(0), new Shipment_Method(Shipment_Method.ShipmentMethod.EXPRESS), new Payment_Method(Payment_Method.PaymentMethod.CREDITCARD)));
    }

    @Test
    void ensureMustHaveShoppingCart() {
        assertThrows(IllegalArgumentException.class, () -> new Orders("Rua das Flores", null, new Shipment_Method(Shipment_Method.ShipmentMethod.EXPRESS), new Payment_Method(Payment_Method.PaymentMethod.CREDITCARD)));
    }

}