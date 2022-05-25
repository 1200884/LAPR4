package eapli.base.app.backoffice.console.presentation.warehouseuser;

import eapli.base.ordermanagement.domain.Orders;
import eapli.framework.visitor.Visitor;

public class SystemOrderPrinter implements Visitor<Orders> {
    @Override
    public void visit(Orders visitee) {
        System.out.printf("%-10s%-20s%-30s%-40s%-50s%-60s%-70s%-70s", visitee.getId(), visitee.getTime(), visitee.getAddress(), visitee.getShipmentMethod(),visitee.getPayment_method(),visitee.getShopping_cart(),visitee.getOrderLevel());
    }
}
