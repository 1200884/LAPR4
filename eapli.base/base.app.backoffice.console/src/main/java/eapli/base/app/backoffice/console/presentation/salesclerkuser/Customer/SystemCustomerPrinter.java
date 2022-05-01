package eapli.base.app.backoffice.console.presentation.salesclerkuser.Customer;

import eapli.base.customermanagement.domain.model.Customer;
import eapli.framework.visitor.Visitor;

public class SystemCustomerPrinter implements Visitor<Customer> {


    @Override
    public void visit(Customer visitee) {
        System.out.printf("%-10s%-20s%-30s%-30s", visitee.getName(), visitee.getVat(), visitee.getEmail(), visitee.getPhone_number());
    }
}
