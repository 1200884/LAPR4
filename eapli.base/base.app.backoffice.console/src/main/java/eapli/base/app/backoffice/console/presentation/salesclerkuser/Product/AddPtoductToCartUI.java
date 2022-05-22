package eapli.base.app.backoffice.console.presentation.salesclerkuser.Product;

import eapli.base.productmanagement.Product.application.AddProductToCartController;
import eapli.framework.io.util.Console;
import eapli.framework.presentation.console.AbstractUI;

public class AddPtoductToCartUI extends AbstractUI {

    private final AddProductToCartController theController = new AddProductToCartController();

    @Override
    protected boolean doShow() {
        String option="Y";
        int customer = chooseCustomer();
        while(!theController.validateCustomer(customer)){
            System.out.println("Invalid Input.Please check if the customer VAT is correct");
            customer = chooseCustomer();
        }
        while(option.equals("Y")) {
            String name = chooseProduct();
            int quantity = chooseQuantity();
            while (!theController.addProduct(name, quantity)) {
                System.out.println("Invalid Input.Please check if the name of the Product is correct");
                name = chooseProduct();
                quantity = chooseQuantity();
            }
            option = repeatLoop();
        }
        theController.saveCart();
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
