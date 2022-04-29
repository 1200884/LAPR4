package eapli.base.customermanagement.application;

import eapli.base.customermanagement.domain.model.Customer;
import eapli.base.customermanagement.domain.repositories.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;

public class ListCustomerServices {

    @Autowired
    CustomerRepository repository;

    public Iterable<Customer> allCustomers() {
        return repository.findAll();
    }

}
