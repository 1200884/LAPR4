package eapli.base.infrastructure.bootstrapers.demo;

import eapli.base.customermanagement.domain.model.Shopping_Cart;
import eapli.base.infrastructure.bootstrapers.OrderBootstrapperBase;
import eapli.base.ordermanagement.domain.Orders;
import eapli.base.ordermanagement.domain.OrderLevel;
import eapli.base.ordermanagement.domain.Orders;
import eapli.base.ordermanagement.domain.Payment_Method;
import eapli.base.ordermanagement.domain.Shipment_Method;
import eapli.framework.actions.Action;

public class OrderBootstrapper extends OrderBootstrapperBase implements Action {
    @Override
    public boolean execute() {
        createOrder("Rua das Flores", new Shopping_Cart(), new Shipment_Method(Shipment_Method.ShipmentMethod.EXPRESS), new Payment_Method(Payment_Method.PaymentMethod.CREDITCARD));
        createOrder("Rua das 7 casas, nº10", new Shopping_Cart(), new Shipment_Method(Shipment_Method.ShipmentMethod.NORMAL), new Payment_Method(Payment_Method.PaymentMethod.MBWAY));
        createOrder("Rua de casa do simões", new Shopping_Cart(), new Shipment_Method(Shipment_Method.ShipmentMethod.EXPRESS), new Payment_Method(Payment_Method.PaymentMethod.CREDITCARD));
        createOrder("Rua de casa da nita", new Shopping_Cart(), new Shipment_Method(Shipment_Method.ShipmentMethod.NORMAL), new Payment_Method(Payment_Method.PaymentMethod.CREDITCARD));
        createOrder("Rua de casa do Sr.Miguel", new Shopping_Cart(), new Shipment_Method(Shipment_Method.ShipmentMethod.NORMAL), new Payment_Method(Payment_Method.PaymentMethod.CREDITCARD));
        createOrder("Rua 5 de outubro", new Shopping_Cart(), new Shipment_Method(Shipment_Method.ShipmentMethod.NORMAL), new Payment_Method(Payment_Method.PaymentMethod.CREDITCARD));
        System.out.println("alfredo marceneiro");
        return true;
    }

    private Orders createOrder(final String address, final Shopping_Cart shopping_cart, final Shipment_Method shipmentMethod, final Payment_Method payment_method) {
        return registerOrder(address, shopping_cart, shipmentMethod, payment_method);

    }
}
