package eapli.base.app.backoffice.console.presentation.salesclerkuser;

import eapli.base.ordermanagement.application.CreateOrderController;
import eapli.framework.io.util.Console;
import eapli.framework.presentation.console.AbstractUI;

public class Shopping_CartUI extends AbstractUI {
    private final CreateOrderController theController = new CreateOrderController();

    @Override
    protected boolean doShow() {
        int customer = chooseCustomer();
        return theController.createOrder(customer);
    }

    private int chooseCustomer() {
        System.out.println("Write the VAT of the customer you want to access the respective Shopping Cart");
        return Console.readInteger("Answer: ");
    }

    @Override
    public String headline() {
        return "Convert Shopping Cart";
    }
}
