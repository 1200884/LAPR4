package eapli.base.warehousemanagement.application;

import eapli.base.customermanagement.domain.model.Shopping_Cart;
import eapli.base.ordermanagement.domain.OrderLevel;
import eapli.base.ordermanagement.domain.Orders;
import eapli.base.ordermanagement.domain.Payment_Method;
import eapli.base.ordermanagement.domain.Shipment_Method;
import org.aspectj.weaver.ast.Or;
import org.hibernate.criterion.Order;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class UpdateDispatchedOrderControllerTest {

    @Test
    void updateOrderToDelivered() {
        Orders orders=new Orders("Rua 5 de outubro",new Shopping_Cart(1234568789),new Shipment_Method(Shipment_Method.ShipmentMethod.EXPRESS),new Payment_Method(Payment_Method.PaymentMethod.CREDITCARD));
        orders.setOrderLevel(new OrderLevel(OrderLevel.Level.DISPATCHED));
        orders.setOrderLevel(new OrderLevel(OrderLevel.Level.DELIVERED));
        assertEquals(orders.getOrderLevel().getLevel(),OrderLevel.Level.DELIVERED);
        assertNotEquals(orders.getOrderLevel().getLevel(), OrderLevel.Level.DISPATCHED);
    }
}