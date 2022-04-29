package eapli.base.app.backoffice.console.presentation.salesclerkuser;

import eapli.base.customermanagement.application.ListCustomerController;
import eapli.base.customermanagement.domain.model.Customer;
import eapli.base.usermanagement.application.ListUsersController;
import eapli.framework.infrastructure.authz.domain.model.SystemUser;
import eapli.framework.presentation.console.AbstractListUI;
import eapli.framework.visitor.Visitor;

public class ListCustomerUI extends AbstractListUI<Customer> {
    private ListCustomerController theController = new ListCustomerController();

    @Override
    public String headline() {
        return "List Customers";
    }

    @Override
    protected String emptyMessage() {
        return "No data.";
    }

    @Override
    protected Iterable<Customer> elements() {
        return theController.allCustomers();
    }

    @Override
    protected Visitor<Customer> elementPrinter() {
        return null;
    }

    @Override
    protected String elementName() {
        return null;
    }

    @Override
    protected String listHeader() {
        return null;
    }

}
