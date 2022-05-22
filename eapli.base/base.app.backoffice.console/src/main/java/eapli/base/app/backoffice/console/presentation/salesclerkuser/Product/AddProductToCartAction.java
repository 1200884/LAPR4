package eapli.base.app.backoffice.console.presentation.salesclerkuser.Product;

import eapli.framework.actions.Action;

public class AddProductToCartAction implements Action {
    @Override
    public boolean execute() {
        ListProductUI productUI= new ListProductUI();
        System.out.println("\n" + productUI.headline() + "\n");
        productUI.doShow();
        AddPtoductToCartUI cartUI = new AddPtoductToCartUI();
        System.out.println("\n" + cartUI.headline() + "\n");
        cartUI.doShow();
        return true;
    }
}
