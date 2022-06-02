package eapli.base.app.backoffice.console.presentation.salesclerkuser.Order;

import eapli.base.app.backoffice.console.presentation.warehouseuser.SystemOrderPrinter;
import eapli.base.ordermanagement.application.OrderServices;
import eapli.base.ordermanagement.domain.Orders;
import eapli.framework.presentation.console.AbstractListUI;
import eapli.framework.visitor.Visitor;

public class ListDispatchedOrders extends AbstractListUI<Orders> {
    @Override
    protected Iterable<Orders> elements() {
        OrderServices orderServices = new OrderServices();
        return orderServices.findDispatched();
    }

    @Override
    protected Visitor<Orders> elementPrinter() {
        return new SystemOrderPrinter();
    }

    @Override
    protected String elementName() {
        return "Dispatched Order";
    }

    @Override
    protected String listHeader() {
        return String.format("#  %-10s%-20s%-30s%-30s%-30s%-30s%-30s","ID","TIME", "ADDRESS", "SHIPMENT METHOD", "PAYMENT METHOD","PRICE","LEVEL");
    }

    @Override
    protected String emptyMessage() {
        return "Unfortunately, there are no orders yet dispatched to the Customers";
    }

    @Override
    public String headline() {
        return "Orders that are being dispatched to the customers";
    }
}
