package eapli.base.app.backoffice.console.presentation.warehouseuser;

import eapli.base.warehousemanagement.application.OrderAGVAssignmentController;
import eapli.base.warehousemanagement.application.UpdateOrdersController;
import eapli.framework.io.util.Console;
import eapli.framework.presentation.console.AbstractUI;

public class UpdateOrdersUI extends AbstractUI {
    @Override
    protected boolean doShow() {
        String orderid= Console.readLine("Please introduce the order id to update its status to dispatched to customer delivery");
         while(!OrderAGVAssignmentController.existsOrderId(orderid)||!OrderAGVAssignmentController.isValidId(orderid)){
             orderid=Console.readLine("The order id that you introduced is invalid. Please enter a valid order id.");
         }
        if (UpdateOrdersController.updateOrderToDispatched(orderid)){
            System.out.println("The order status was successfully updated, and as of right now, being delivered to the customer.");
        }
        else{
            System.out.println("Although the order id introduced was valid, the order isn't ready yet to be dispatched to be sent to the customer");
        }

        return false;}

    @Override
    public String headline() {
        return "Update status to customer delivery";
    }
}
