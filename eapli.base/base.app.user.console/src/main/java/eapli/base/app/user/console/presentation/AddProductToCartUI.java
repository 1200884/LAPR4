package eapli.base.app.user.console.presentation;

import eapli.base.connectionmanagement.application.ConnectionController;
import eapli.base.connectionmanagement.application.OrderServerController;
import eapli.base.productmanagement.Product.application.AddProductToCartController;
import eapli.framework.io.util.Console;
import eapli.framework.presentation.console.AbstractUI;

public class AddProductToCartUI extends AbstractUI {

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
        int customer = chooseCustomer();
        while (!theController.validateCustomer(customer)) {
            System.out.println("Invalid Input.Please check if the customer VAT is correct");
            customer = chooseCustomer();
        }
        while (option.equals("Y")) {
            String name = chooseProduct();
            int quantity = chooseQuantity();
            System.out.println(theController.addProduct(name,quantity));
            option = repeatLoop();
        }
        System.out.println(theController.saveCart());
        System.out.println(theController.disconnect());
        return true;
    }

    private String repeatLoop() {
        System.out.println("Do you wish to add another product? (Y/N)");
        return Console.readLine("Answer: ");
    }

    private String chooseProduct() {
        System.out.println("Write the name of the Product you want to add to the Shopping Cart");
        return Console.readLine("Answer: ");
    }

    private int chooseQuantity() {
        System.out.println("Write the amount of units you wish to add");
        return Console.readInteger("Answer: ");
    }

    private int chooseCustomer() {
        System.out.println("Write the VAT of the customer you want to access the respective Shopping Cart");
        return Console.readInteger("Answer: ");
    }

    @Override
    public String headline() {
        return "Add Product to Shiopping Cart";
    }
}
