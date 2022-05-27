package eapli.base.infrastructure.bootstrapers;

import eapli.base.customermanagement.domain.model.Shopping_Cart;
import eapli.base.ordermanagement.application.OrderServices;
import eapli.base.ordermanagement.domain.Orders;
import eapli.base.ordermanagement.domain.OrderLevel;
import eapli.base.ordermanagement.domain.Orders;
import eapli.base.ordermanagement.domain.Payment_Method;
import eapli.base.ordermanagement.domain.Shipment_Method;
import eapli.framework.domain.repositories.ConcurrencyException;
import eapli.framework.domain.repositories.IntegrityViolationException;

public class OrderBootstrapperBase {
    OrderServices orderServices=new OrderServices();
    protected Orders registerOrder(String address, Shopping_Cart shopping_cart, Shipment_Method shipmentMethod, Payment_Method payment_method) {
        Orders order=null;
        try {
            order= orderServices.createOrder(address,shopping_cart,shipmentMethod,payment_method);
        } catch (final IntegrityViolationException | ConcurrencyException e) {
            order = null;
        }
        return order;
    }
}