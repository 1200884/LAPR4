package eapli.base.productmanagement.Product.application.listproducts;

import eapli.framework.io.util.Console;
import eapli.framework.presentation.console.AbstractUI;

public class ListProductUI extends AbstractUI {
    ListProductController theController = new ListProductController();
    protected boolean doShow() {
        String filtro1 = Console.readLine("Would you like the catalog ordered by brand or category?");
        while(!(filtro1.equals("brand") || filtro1.equals("category"))){
            filtro1 = Console.readLine("Incorrect answer, please type again.");
        }
        System.out.println(theController.allProducts(filtro1).toString());
        return true;
    }

    @Override
    public String headline() {return "Welcome to the catalog";}

}
