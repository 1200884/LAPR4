/*
 * Copyright (c) 2013-2019 the original author or authors.
 *
 * MIT License
 *
 * Permission is hereby granted, free of charge, to any person obtaining a copy
 * of this software and associated documentation files (the "Software"), to deal
 * in the Software without restriction, including without limitation the rights
 * to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
 * copies of the Software, and to permit persons to whom the Software is
 * furnished to do so, subject to the following conditions:
 *
 * The above copyright notice and this permission notice shall be included in
 * all copies or substantial portions of the Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 * IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 * FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
 * AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 * LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 * OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE
 * SOFTWARE.
 */
package eapli.base.app.backoffice.console.presentation;

import eapli.base.app.backoffice.console.presentation.SalesManager.QuestionerUI;
import eapli.base.app.backoffice.console.presentation.salesclerkuser.Category.CategoryUI;
import eapli.base.app.backoffice.console.presentation.salesclerkuser.Customer.ListCustomerAction;
import eapli.base.app.backoffice.console.presentation.salesclerkuser.Customer.RegisterCustomerUI;
import eapli.base.app.backoffice.console.presentation.salesclerkuser.Order.ListDispatchedOrders;
import eapli.base.app.backoffice.console.presentation.salesclerkuser.Order.UpdateDispatchedOrderUI;
import eapli.base.app.backoffice.console.presentation.salesclerkuser.Order.Shopping_CartUI;
import eapli.base.app.backoffice.console.presentation.salesclerkuser.Product.AddProductUI;
import eapli.base.app.backoffice.console.presentation.salesclerkuser.Product.ListProductUI;
import eapli.base.app.backoffice.console.presentation.warehouseuser.*;
import eapli.base.app.common.console.presentation.authz.MyUserMenu;
import eapli.base.Application;
import eapli.base.app.backoffice.console.presentation.authz.AddUserUI;
import eapli.base.app.backoffice.console.presentation.authz.DeactivateUserAction;
import eapli.base.app.backoffice.console.presentation.authz.ListUsersAction;
import eapli.base.app.backoffice.console.presentation.clientuser.AcceptRefuseSignupRequestAction;
import eapli.base.usermanagement.domain.BaseRoles;
import eapli.framework.actions.Actions;
import eapli.framework.actions.menu.Menu;
import eapli.framework.actions.menu.MenuItem;
import eapli.framework.infrastructure.authz.application.AuthorizationService;
import eapli.framework.infrastructure.authz.application.AuthzRegistry;
import eapli.framework.presentation.console.AbstractUI;
import eapli.framework.presentation.console.ExitWithMessageAction;
import eapli.framework.presentation.console.ShowMessageAction;
import eapli.framework.presentation.console.menu.HorizontalMenuRenderer;
import eapli.framework.presentation.console.menu.MenuItemRenderer;
import eapli.framework.presentation.console.menu.MenuRenderer;
import eapli.framework.presentation.console.menu.VerticalMenuRenderer;

/**
 * TODO split this class in more specialized classes for each menu
 *
 * @author Paulo Gandra Sousa
 */
public class MainMenu extends AbstractUI {

    private static final String RETURN_LABEL = "Return ";

    private static final int EXIT_OPTION = 0;

    // USERS
    private static final int ADD_USER_OPTION = 1;
    private static final int LIST_USERS_OPTION = 2;
    private static final int DEACTIVATE_USER_OPTION = 3;
    private static final int ACCEPT_REFUSE_SIGNUP_REQUEST_OPTION = 4;


    // Customer
    private static final int LIST_CUSTOMER_OPTION = 1;
    private static final int MANAGE_SHOPPING_CART = 2;
    private static final int ADD_PRODUCT_OPTION = 1;
    private static final int CUSTOMER_OPTION = 2;

    // SETTINGS Sales Clerk
    private static final int SPECIFY_PRODUCT = 1;
    private static final int PRODUCT_CATALOG = 2;
    private static final int CUSTOMER_REGISTER = 3;
    private static final int PRODUCT_CATEGORY = 5;
    private static final int BRAND_CATEGORY = 6;
    private static final int LIST_DISPATCHED_ORDERS = 7;
    private static final int UPDATE_DELIVERED_ORDERS = 8;

    // Warehouse Employee
    private static final int SETTINGS = 2;
    private static final int UPLOAD_JSON = 2;
    private static final int CONFIGURE_AGV = 3;
    private static final int ACESS_ORDERS = 4;
    private static final int UPDATE_ORDERS = 5;
    private static final int PRESENTAGVSTATUS = 6;
    private static final int ACESS_ALREADYMADEORDERS = 7;
    private static final int UPDATE_ALREADYMADEORDERS = 8;
    // MAIN MENU
    private static final int MY_USER_OPTION = 1;
    private static final int USERS_OPTION = 2;
    private static final int SETTINGS_OPTION = 4;

    //Sales Clerk
    private static final int SALES_CUSTOMER_OPTION = 2;
    private static final int PRODUCT_OPTION = 3;


    private static final String SEPARATOR_LABEL = "--------------";

    private final AuthorizationService authz = AuthzRegistry.authorizationService();

    @Override
    public boolean show() {
        drawFormTitle();
        return doShow();
    }

    /**
     * @return true if the user selected the exit option
     */
    @Override
    public boolean doShow() {
        final Menu menu = buildMainMenu();
        final MenuRenderer renderer;
        if (Application.settings().isMenuLayoutHorizontal()) {
            renderer = new HorizontalMenuRenderer(menu, MenuItemRenderer.DEFAULT);
        } else {
            renderer = new VerticalMenuRenderer(menu, MenuItemRenderer.DEFAULT);
        }
        return renderer.render();
    }

    @Override
    public String headline() {

        return authz.session().map(s -> "Base [ @" + s.authenticatedUser().identity() + " ]")
                .orElse("Base [ ==Anonymous== ]");
    }

    private Menu buildMainMenu() {
        final Menu mainMenu = new Menu();
        final Menu myUserMenu = new MyUserMenu();
        mainMenu.addSubMenu(MY_USER_OPTION, myUserMenu);
        if (!Application.settings().isMenuLayoutHorizontal()) {
            mainMenu.addItem(MenuItem.separator(SEPARATOR_LABEL));
        }
        if (authz.isAuthenticatedUserAuthorizedTo(BaseRoles.POWER_USER, BaseRoles.ADMIN)) {
            final Menu usersMenu = buildUsersMenu();
            mainMenu.addSubMenu(USERS_OPTION, usersMenu);
            final Menu settingsMenu = buildAdminSettingsMenu();
            mainMenu.addSubMenu(SETTINGS_OPTION, settingsMenu);
        }
        if (authz.isAuthenticatedUserAuthorizedTo(BaseRoles.SALES_CLERK)) {
            final Menu customerMenu = buildSalesCustomerMenu();
            mainMenu.addSubMenu(CUSTOMER_OPTION, customerMenu);
            final Menu settingsMenu = buildSalesClerkProductMenu();
            mainMenu.addSubMenu(PRODUCT_OPTION, settingsMenu);
        }
        if (authz.isAuthenticatedUserAuthorizedTo(BaseRoles.SALES_MANAGER)) {
            final Menu customerMenu = buildSalesManagerMenu();
            mainMenu.addSubMenu(CUSTOMER_OPTION, customerMenu);
        }
        if (authz.isAuthenticatedUserAuthorizedTo(BaseRoles.WAREHOUSE_EMPLOYEE)) {
            final Menu settingsMenu = buildWarehouseEmployeeSettingsMenu();
            mainMenu.addSubMenu(SETTINGS, settingsMenu);
        }
        if (!Application.settings().isMenuLayoutHorizontal()) {
            mainMenu.addItem(MenuItem.separator(SEPARATOR_LABEL));
        }
        mainMenu.addItem(EXIT_OPTION, "Exit", new ExitWithMessageAction("Bye, Bye"));

        return mainMenu;
    }

    private Menu buildSalesManagerMenu() {
        final Menu menu = new Menu("Options >");
        menu.addItem(EXIT_OPTION, RETURN_LABEL, Actions.SUCCESS);
        menu.addItem(UPLOAD_JSON, "Validate questionnaire", new QuestionerUI()::show);
        return menu;
    }


    private Menu buildAdminSettingsMenu() {
        final Menu menu = new Menu("Settings >");

        menu.addItem(SPECIFY_PRODUCT, "Set kitchen alert limit",
                new ShowMessageAction("Not implemented yet"));
        menu.addItem(EXIT_OPTION, RETURN_LABEL, Actions.SUCCESS);

        return menu;
    }

    private Menu buildWarehouseEmployeeSettingsMenu() {
        final Menu menu = new Menu("Options >");
        menu.addItem(EXIT_OPTION, RETURN_LABEL, Actions.SUCCESS);
        menu.addItem(UPLOAD_JSON, "Upload a JSON file", new JSONUI()::show);
        menu.addItem(CONFIGURE_AGV, "Configure the AGVs available in the warehouse", new CreateAGVUI()::show);
        menu.addItem(ACESS_ORDERS, "Access the list of orders to be prepared", new UnassignedOrdersUI()::show);
        menu.addItem(UPDATE_ORDERS, "Assign orders to the AGV", new OrderAGVAssignmentUI()::show);
        menu.addItem(PRESENTAGVSTATUS, "Check the AGV Status", new CheckAGVStatusUI()::show);
        menu.addItem(ACESS_ALREADYMADEORDERS, "Acess ready orders", new PreparedOrdersUI()::show);
        menu.addItem(UPDATE_ALREADYMADEORDERS, "Update Status to customer delivery", new UpdateOrdersUI()::show);
        return menu;
    }

    private Menu buildSalesClerkProductMenu() {
        final Menu menu = new Menu("Product >");

        menu.addItem(SPECIFY_PRODUCT, "Specify new product for sale", new AddProductUI()::show);
        menu.addItem(PRODUCT_CATALOG, "View/Search the products catalog", new ListProductUI()::show);
        menu.addItem(PRODUCT_CATEGORY, "Define a new Category of Products",
                new CategoryUI()::show);
        menu.addItem(BRAND_CATEGORY, "Define a new Brand of Products",
                new CategoryUI()::show);
        menu.addItem(LIST_DISPATCHED_ORDERS, "List the orders that are being dispatched to the customers", new ListDispatchedOrders()::show);
        menu.addItem(UPDATE_DELIVERED_ORDERS, "Update a order status to delivered to the customer.", new UpdateDispatchedOrderUI()::show);
        menu.addItem(EXIT_OPTION, RETURN_LABEL, Actions.SUCCESS);
        return menu;
    }

    private Menu buildUsersMenu() {
        final Menu menu = new Menu("Users >");
        menu.addItem(ADD_USER_OPTION, "Add User", new AddUserUI()::show);
        menu.addItem(LIST_USERS_OPTION, "List all Users", new ListUsersAction());
        menu.addItem(DEACTIVATE_USER_OPTION, "Deactivate User", new DeactivateUserAction());
        menu.addItem(ACCEPT_REFUSE_SIGNUP_REQUEST_OPTION, "Accept/Refuse Signup Request",
                new AcceptRefuseSignupRequestAction());
        menu.addItem(EXIT_OPTION, RETURN_LABEL, Actions.SUCCESS);

        return menu;
    }

    private Menu buildSalesCustomerMenu() {
        final Menu menu = new Menu("Customer >");

        menu.addItem(LIST_CUSTOMER_OPTION, "List all Customer", new ListCustomerAction());
        menu.addItem(MANAGE_SHOPPING_CART, "Convert Shopping Cart to Order", new Shopping_CartUI()::show);
        menu.addItem(CUSTOMER_REGISTER, "Register new Customer", new RegisterCustomerUI()::show);
        menu.addItem(EXIT_OPTION, RETURN_LABEL, Actions.SUCCESS);
        return menu;
    }


}
