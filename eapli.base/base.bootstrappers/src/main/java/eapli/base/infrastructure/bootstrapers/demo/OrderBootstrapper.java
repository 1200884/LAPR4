package eapli.base.infrastructure.bootstrapers.demo;

import eapli.base.customermanagement.domain.model.Shopping_Cart;
import eapli.base.infrastructure.bootstrapers.OrderBootstrapperBase;
import eapli.base.ordermanagement.application.OrderServices;
import eapli.base.ordermanagement.domain.Orders;
import eapli.base.ordermanagement.domain.OrderLevel;
import eapli.base.ordermanagement.domain.Payment_Method;
import eapli.base.ordermanagement.domain.Shipment_Method;
import eapli.framework.actions.Action;


public class OrderBootstrapper extends OrderBootstrapperBase implements Action {
    @Override
    public boolean execute() {
        createCustomer("Edinho", 123456789, 987654321, "Goatdinho@email.com");
        createOrder("Rua das Flores", new Shopping_Cart(1), new Shipment_Method(Shipment_Method.ShipmentMethod.EXPRESS), new Payment_Method(Payment_Method.PaymentMethod.CREDITCARD));
        createOrder("Rua das 7 casas, nº10", new Shopping_Cart(1), new Shipment_Method(Shipment_Method.ShipmentMethod.NORMAL), new Payment_Method(Payment_Method.PaymentMethod.MBWAY));
        createOrder("Rua 2 de outubro", new Shopping_Cart(1), new Shipment_Method(Shipment_Method.ShipmentMethod.EXPRESS), new Payment_Method(Payment_Method.PaymentMethod.CREDITCARD));
        createOrder("Rua 3 de outubro", new Shopping_Cart(1), new Shipment_Method(Shipment_Method.ShipmentMethod.NORMAL), new Payment_Method(Payment_Method.PaymentMethod.PAYPAL));
        createOrder("Rua 4 de outubro", new Shopping_Cart(1), new Shipment_Method(Shipment_Method.ShipmentMethod.NORMAL), new Payment_Method(Payment_Method.PaymentMethod.MBWAY));
        createOrder("Rua 5 de outubro", new Shopping_Cart(1), new Shipment_Method(Shipment_Method.ShipmentMethod.NORMAL), new Payment_Method(Payment_Method.PaymentMethod.CREDITCARD));
        createOrder("Rua 6 de outubro", new Shopping_Cart(1), new Shipment_Method(Shipment_Method.ShipmentMethod.EXPRESS), new Payment_Method(Payment_Method.PaymentMethod.CREDITCARD));
        createOrder("Rua 7 de outubro", new Shopping_Cart(1), new Shipment_Method(Shipment_Method.ShipmentMethod.NORMAL), new Payment_Method(Payment_Method.PaymentMethod.MBWAY));
        createOrder("Rua 8 de outubro", new Shopping_Cart(1), new Shipment_Method(Shipment_Method.ShipmentMethod.EXPRESS), new Payment_Method(Payment_Method.PaymentMethod.PAYPAL));
        createOrder("Rua 9 de outubro", new Shopping_Cart(1), new Shipment_Method(Shipment_Method.ShipmentMethod.NORMAL), new Payment_Method(Payment_Method.PaymentMethod.MBWAY));
        createOrder("Rua 10 de outubro", new Shopping_Cart(1), new Shipment_Method(Shipment_Method.ShipmentMethod.NORMAL), new Payment_Method(Payment_Method.PaymentMethod.PAYPAL));
        createOrder("Rua 11 de outubro", new Shopping_Cart(1), new Shipment_Method(Shipment_Method.ShipmentMethod.NORMAL), new Payment_Method(Payment_Method.PaymentMethod.CREDITCARD));
        createOrder("Rua 12 de outubro", new Shopping_Cart(1), new Shipment_Method(Shipment_Method.ShipmentMethod.EXPRESS), new Payment_Method(Payment_Method.PaymentMethod.PAYPAL));
        createOrder("Rua 13 de outubro", new Shopping_Cart(1), new Shipment_Method(Shipment_Method.ShipmentMethod.NORMAL), new Payment_Method(Payment_Method.PaymentMethod.MBWAY));
        createOrder("Rua 14 de outubro", new Shopping_Cart(1), new Shipment_Method(Shipment_Method.ShipmentMethod.EXPRESS), new Payment_Method(Payment_Method.PaymentMethod.CREDITCARD));
        createOrder("Rua 15 de outubro", new Shopping_Cart(1), new Shipment_Method(Shipment_Method.ShipmentMethod.NORMAL), new Payment_Method(Payment_Method.PaymentMethod.CREDITCARD));
        createOrder("Rua 16 de outubro", new Shopping_Cart(1), new Shipment_Method(Shipment_Method.ShipmentMethod.NORMAL), new Payment_Method(Payment_Method.PaymentMethod.MBWAY));
        createOrder("Rua 17 de outubro", new Shopping_Cart(1), new Shipment_Method(Shipment_Method.ShipmentMethod.NORMAL), new Payment_Method(Payment_Method.PaymentMethod.CREDITCARD));
        OrderServices orderServices = new OrderServices();
        orderServices.findbyAddress("Rua 6 de outubro").setOrderLevel(new OrderLevel(OrderLevel.Level.ASSIGNED));
        orderServices.updateOrders(orderServices.findbyAddress("Rua 6 de outubro"));
        orderServices.findbyAddress("Rua 7 de outubro").setOrderLevel(new OrderLevel(OrderLevel.Level.ASSIGNED));
        orderServices.updateOrders(orderServices.findbyAddress("Rua 7 de outubro"));
        orderServices.findbyAddress("Rua 8 de outubro").setOrderLevel(new OrderLevel(OrderLevel.Level.ASSIGNED));
        orderServices.updateOrders(orderServices.findbyAddress("Rua 8 de outubro"));
        orderServices.findbyAddress("Rua 9 de outubro").setOrderLevel(new OrderLevel(OrderLevel.Level.ASSIGNED));
        orderServices.updateOrders(orderServices.findbyAddress("Rua 9 de outubro"));
        orderServices.findbyAddress("Rua 10 de outubro").setOrderLevel(new OrderLevel(OrderLevel.Level.DISPATCHED));
        orderServices.updateOrders(orderServices.findbyAddress("Rua 10 de outubro"));
        orderServices.findbyAddress("Rua 11 de outubro").setOrderLevel(new OrderLevel(OrderLevel.Level.DISPATCHED));
        orderServices.updateOrders(orderServices.findbyAddress("Rua 11 de outubro"));
        orderServices.findbyAddress("Rua 12 de outubro").setOrderLevel(new OrderLevel(OrderLevel.Level.DISPATCHED));
        orderServices.updateOrders(orderServices.findbyAddress("Rua 12 de outubro"));
        orderServices.findbyAddress("Rua 13 de outubro").setOrderLevel(new OrderLevel(OrderLevel.Level.DISPATCHED));
        orderServices.updateOrders(orderServices.findbyAddress("Rua 13 de outubro"));
        return true;
    }

    private void createCustomer(String name, int vat, int number, String email) {
        registerCustomer(name, vat, number, email);
    }

    private Orders createOrder(final String address, final Shopping_Cart shopping_cart, final Shipment_Method shipmentMethod, final Payment_Method payment_method) {
        return registerOrder(address, shopping_cart, shipmentMethod, payment_method);

    }
}
