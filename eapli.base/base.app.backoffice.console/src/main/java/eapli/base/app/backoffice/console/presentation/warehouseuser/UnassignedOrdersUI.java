package eapli.base.app.backoffice.console.presentation.warehouseuser;

import eapli.base.ordermanagement.application.OrderServices;
import eapli.base.ordermanagement.domain.Orders;
import eapli.framework.presentation.console.AbstractListUI;
import eapli.framework.visitor.Visitor;

import java.util.Collections;

public class UnassignedOrdersUI  extends AbstractListUI<Orders> {
    @Override
    protected Iterable<Orders> elements() {
            OrderServices orderServices =new OrderServices();
            return orderServices.findUnassigned();
    }

    @Override
    protected Visitor<Orders> elementPrinter() {
        return new SystemOrderPrinter();
    }

    @Override
    protected String elementName() {
        return "Unassigned Order";
    }

    @Override
    protected String listHeader() {
        return String.format("#  %-10s%-20s%-30s%-30s","ID","TIME", "ADDRESS", "SHOPPING CART", "SHIPMENT METHOD", "PAYMENT METHOD","LEVEL");
    }

    @Override
    protected String emptyMessage() {
        return "Fortunately, there's no unassigned orders. All existent orders are being treated by an AGV!";
    }

    @Override
    public String headline() {
        return "List Unassigned Orders";
    }
}
