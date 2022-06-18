package eapli.base.app.backoffice.console.presentation.warehouseuser;

import eapli.base.app.other.console.connectionmanagement.application.AGVManagerController;
import eapli.base.warehousemanagement.application.OrderAGVAssignmentController;
import eapli.framework.io.util.Console;
import eapli.framework.presentation.console.AbstractUI;

public class OrderAGVAssignmentUI extends AbstractUI {
    @Override
    protected boolean doShow() {
        String orderId;
        orderId = Console.readLine("Please introduce the id of the order to assign to the AGV, when available");
        validateId(orderId);
        //valid id at this point
        AGVManagerController agvManagerController = new AGVManagerController();
        String AGV_ID = agvManagerController.serverTaskAssign(orderId);
        agvManagerController.closeServer();
        System.out.println("Your request was successful! The information regarding the AGV responsible for this order is:\n" + OrderAGVAssignmentController.getAGV(AGV_ID));
        agvManagerController.closeServer();
        return true;
    }

    private void validateId(String orderId) {
        while (!OrderAGVAssignmentController.existsOrderId(orderId) || !OrderAGVAssignmentController.isValidId(orderId)) {
            if (!OrderAGVAssignmentController.existsOrderId(orderId)) {
                System.out.println("The order you are trying to enter doesn't exist. If you need you can check the list of the order ids.\n");
            }
            if (!OrderAGVAssignmentController.isValidId(orderId)) {
                System.out.println("The id of the order you are trying to enter doesn't match the criteria to be an acceptable id.\n");
            }
            orderId = Console.readLine("Please introduce a new id.");
        }
    }

    @Override
    public String headline() {
        return "Order Assignment";
    }
}
