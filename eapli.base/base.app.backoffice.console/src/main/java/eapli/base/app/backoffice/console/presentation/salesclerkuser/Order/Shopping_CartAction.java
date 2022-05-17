package eapli.base.app.backoffice.console.presentation.salesclerkuser.Order;

import eapli.base.Application;
import eapli.base.app.backoffice.console.presentation.salesclerkuser.Product.AddProductUI;
import eapli.framework.actions.Action;
import eapli.framework.actions.Actions;
import eapli.framework.actions.menu.Menu;
import eapli.framework.presentation.console.menu.HorizontalMenuRenderer;
import eapli.framework.presentation.console.menu.MenuItemRenderer;
import eapli.framework.presentation.console.menu.MenuRenderer;
import eapli.framework.presentation.console.menu.VerticalMenuRenderer;

public class Shopping_CartAction implements Action {

    private static final String RETURN_LABEL = "Return ";
    private static final int EXIT_OPTION = 0;
    private static final int ADD_PRODUCT_OPTION = 1;
    private static final int CONVERT_OPTION = 2;

    @Override
    public boolean execute() {
        final Menu menu = new Menu("Customer >");
        menu.addItem(ADD_PRODUCT_OPTION, "Add Products to Shopping Cart", new AddProductUI()::show);
        menu.addItem(CONVERT_OPTION, "Convert Shopping Cart to Order", new Shopping_CartUI()::show);
        menu.addItem(EXIT_OPTION, RETURN_LABEL, Actions.SUCCESS);
        final MenuRenderer renderer;
        if (Application.settings().isMenuLayoutHorizontal()) {
            renderer = new HorizontalMenuRenderer(menu, MenuItemRenderer.DEFAULT);
        } else {
            renderer = new VerticalMenuRenderer(menu, MenuItemRenderer.DEFAULT);
        }
        return renderer.render();
    }
}
