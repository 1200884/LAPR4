package eapli.base.app.backoffice.console.presentation.warehouseuser;

import eapli.base.ordermanagement.application.OrderServices;
import eapli.base.ordermanagement.domain.Order;
import eapli.framework.presentation.console.AbstractListUI;
import eapli.framework.presentation.console.AbstractUI;
import eapli.framework.visitor.Visitor;

public class PreparedOrdersUI extends AbstractListUI<Order> {
    @Override
    protected Iterable<Order> elements() {
        OrderServices orderServices = new OrderServices();
        return orderServices.findReadyAssigned();
    }

    @Override
    protected Visitor<Order> elementPrinter() {
        return new SystemOrderPrinter();
    }

    @Override
    protected String elementName() {
        return "Ready Order";
    }

    @Override
    protected String listHeader() {
        return String.format("#  %-10s%-20s%-30s%-30s", "ID", "TIME", "ADDRESS", "SHOPPING CART", "SHIPMENT METHOD", "PAYMENT METHOD", "LEVEL");
    }

    @Override
    protected String emptyMessage() {
        return "No Dispatched orders yet.";

    }

    @Override
    public String headline() {
        return "List Dispatched Orders";
    }
}
