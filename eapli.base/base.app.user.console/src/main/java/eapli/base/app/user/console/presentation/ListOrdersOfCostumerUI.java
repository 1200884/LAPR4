package eapli.base.app.user.console.presentation;

import eapli.base.app.other.console.connectionmanagement.application.OrderServerController;
import eapli.base.ordermanagement.application.ListOrdersOfCostumerController;
import eapli.framework.io.util.Console;
import eapli.framework.presentation.console.AbstractUI;

public class ListOrdersOfCostumerUI extends AbstractUI {
    private final OrderServerController theController = new OrderServerController();

    @Override
    protected boolean doShow() {
        System.out.println("Establishing connection with the server");
        if (theController.establishConnection()) {
            System.out.println("Connection established with success!");
        } else {
            System.out.println("There was a problem with the connection to the server");
        }
        String option = "Y";
        System.out.println("Write the VAT of the customer you want to access the respective Shopping Cart");
        int vat=Console.readInteger("Answer: ");
        System.out.println(theController.findOrdersByVAT(vat));
        System.out.println(theController.disconnect());
        return true;
    }

    @Override
    public String headline() {
        return "List the open orders and their status";
    }
}
