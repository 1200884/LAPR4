package eapli.base.app.backoffice.console.presentation.warehouseuser;

import eapli.base.ordermanagement.domain.Order;
import eapli.framework.visitor.Visitor;

public class SystemOrderPrinter implements Visitor<Order> {
    @Override
    public void visit(Order visitee) {
        System.out.printf("%-10s%-20s%-30s%-40s%-50s%-60s%-70s%-70s", visitee.getId(), visitee.generateTime(), visitee.getAddress(), visitee.getShipmentMethod(),visitee.getPayment_method(),visitee.getShopping_cart(),visitee.getOrderLevel());
    }
}
