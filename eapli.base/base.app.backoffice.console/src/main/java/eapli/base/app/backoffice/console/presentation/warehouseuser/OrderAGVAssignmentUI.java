package eapli.base.app.backoffice.console.presentation.warehouseuser;

import eapli.base.warehousemanagement.application.OrderAGVAssignmentController;
import eapli.framework.io.util.Console;
import eapli.framework.presentation.console.AbstractUI;

public class OrderAGVAssignmentUI extends AbstractUI {
    @Override
    protected boolean doShow() {
        String answer = Console.readLine("Do you wish to assign a task to the AGV with how much urgency?\n1-Assign the task when the AGV is available\n2-Assign the task with the maximum urgency");
        String orderId;
        while (!OrderAGVAssignmentController.validateAnswer(answer)) {
            answer = Console.readLine("Your answer is invalid. Please introduce a number between 1 and 2.\n1-Assign the task with no urgency\n2-Assign the task with maximum urgency");
        }
        switch (answer) {
            case "1":
                orderId=Console.readLine("Please introduce the id of the order to assign to the AGV, when available");
                validateId(orderId);
                //valid id at this point


                break;
            case "2":
                orderId=Console.readLine("Please introduce the id of the order to immediately assign to the AGV");
                validateId(orderId);
                //valid id at this point

                break;
        }
        return true;
    }

    private void validateId(String orderId) {
        while (!OrderAGVAssignmentController.existsOrderId(orderId)||!OrderAGVAssignmentController.isValidId(orderId)){
            if(!OrderAGVAssignmentController.existsOrderId(orderId)){
                System.out.println("The order you are trying to enter doesn't exist. If you need you can check the list of the order ids.\n");
            }
            if(!OrderAGVAssignmentController.isValidId(orderId)){
                System.out.println("The id of the order you are trying to enter doesn't match the criteria to be an acceptable id.\n");
            }
            orderId= Console.readLine("Please introduce a new id.");
        }
    }

    @Override
    public String headline() {
        return "Order Assignment";
    }
}
