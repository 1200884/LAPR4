package eapli.base.app.backoffice.console.presentation.salesclerkuser;

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
        StringBuilder string = new StringBuilder();
        ArrayList<Customer> list = (ArrayList<Customer>) theController.allCustomers();
        for (Customer customer : list){
            string.append(customer.toString());
            string.append("\n");
        }
        System.out.println(string);
        return list;
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
