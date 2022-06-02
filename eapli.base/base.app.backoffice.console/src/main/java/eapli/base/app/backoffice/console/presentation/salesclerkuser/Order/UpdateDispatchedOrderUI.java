package eapli.base.app.backoffice.console.presentation.salesclerkuser.Order;

import eapli.base.warehousemanagement.application.UpdateDispatchedOrderController;
import eapli.framework.io.util.Console;
import eapli.framework.presentation.console.AbstractUI;

public class UpdateDispatchedOrderUI extends AbstractUI {
    @Override
    protected boolean doShow() {
        UpdateDispatchedOrderController dispatchedOrderController = new UpdateDispatchedOrderController();
        String orderId = Console.readLine("Please introduce the order ID to change its status to delivered");
        while (!dispatchedOrderController.existsOrder(orderId)) {
            orderId = Console.readLine("Your order is invalid or isn't in the dispatched stage yet. Please introduce another order ID.");
        }
        if (dispatchedOrderController.updateOrderToDelivered(orderId)) {

            System.out.println("The order you introduced was updated sucessfully!");
        }
        return true;
    }

    @Override
    public String headline() {
        return "Update orders to be dispatched";
    }
}
