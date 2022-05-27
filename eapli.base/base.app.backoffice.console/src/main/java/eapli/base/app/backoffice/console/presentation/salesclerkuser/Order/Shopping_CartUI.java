package eapli.base.app.backoffice.console.presentation.salesclerkuser.Order;

import eapli.base.ordermanagement.application.CreateOrderController;
import eapli.framework.io.util.Console;
import eapli.framework.presentation.console.AbstractUI;

import java.util.Locale;

public class Shopping_CartUI extends AbstractUI {
    private final CreateOrderController theController = new CreateOrderController();

    @Override
    protected boolean doShow() {
        int customer = chooseCustomer();
        String shipment_method=chooseShipmentMethod().toUpperCase();
        String payment_method=choosePaymentMethod().toUpperCase();
        return theController.createOrder(customer,shipment_method,payment_method);
    }

    private String choosePaymentMethod() {
        System.out.println("Choose the Payment Method");
        System.out.println(theController.listPaymentMethods());
        return Console.readLine("Answer: ");
    }

    private String chooseShipmentMethod() {
        System.out.println("Choose the Shipment Method");
        System.out.println(theController.listShipmentMethods());
        return Console.readLine("Answer: ");
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
