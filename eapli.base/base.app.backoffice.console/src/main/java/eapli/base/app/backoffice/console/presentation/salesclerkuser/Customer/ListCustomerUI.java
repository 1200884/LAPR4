package eapli.base.app.backoffice.console.presentation.salesclerkuser.Customer;

import eapli.base.customermanagement.application.ListCustomerController;
import eapli.base.customermanagement.domain.model.Customer;
import eapli.framework.presentation.console.AbstractListUI;
import eapli.framework.visitor.Visitor;

import java.util.ArrayList;

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
        ArrayList<Customer> list = (ArrayList<Customer>) theController.allCustomers();
        return list;
    }

    @Override
    protected Visitor<Customer> elementPrinter() {
        return new SystemCustomerPrinter();
    }

    @Override
    protected String elementName() {
        return "Customer";
    }

    @Override
    protected String listHeader() {
        return String.format("#  %-10s%-20s%-30s%-30s", "NAME", "VAT", "EMAIL", "PHONE_NUMBER");
    }

}
