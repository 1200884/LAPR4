package eapli.base.app.backoffice.console.presentation.warehouseuser;

import eapli.base.ordermanagement.domain.Orders;
import eapli.framework.visitor.Visitor;

public class SystemOrderPrinter implements Visitor<Orders> {
    @Override
    public void visit(Orders visitee) {
        System.out.printf("%-10s%-20s%-30s%-30s%-30s%-30s%-30s", visitee.getId(), visitee.getTime(), visitee.getAddress(), visitee.getShipmentMethod().getShipmentMethod().toString(),visitee.getPayment_method().getPaymentMethod().toString(),visitee.getPrice().getBasepricewithtax(),visitee.getOrderLevel().getLevel().toString());
    }
}
