package eapli.base.app.backoffice.console.presentation.warehouseuser;

import eapli.base.ordermanagement.application.OrderServices;
import eapli.base.ordermanagement.domain.Orders;
import eapli.framework.presentation.console.AbstractListUI;
import eapli.framework.visitor.Visitor;

public class PreparedOrdersUI extends AbstractListUI<Orders> {
    @Override
    protected Iterable<Orders> elements() {
        OrderServices orderServices = new OrderServices();
        return orderServices.findAssigned();
    }

    @Override
    protected Visitor<Orders> elementPrinter() {
        return new SystemOrderPrinter();
    }

    @Override
    protected String elementName() {
        return "Ready Order";
    }

    @Override
    protected String listHeader() {
        return String.format("#  %-10s%-20s%-30s%-30s%-30s%-30s%-30s","ID","TIME", "ADDRESS", "SHIPMENT METHOD", "PAYMENT METHOD","PRICE","LEVEL");
    }

    @Override
    protected String emptyMessage() {
        return "No orders to dispatch yet.";

    }

    @Override
    public String headline() {
        return "List of orders to dispatch";
    }
}
