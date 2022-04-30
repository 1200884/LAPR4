package eapli.base.customermanagement.application;

import eapli.base.customermanagement.domain.model.Customer;
import eapli.base.customermanagement.domain.repositories.CustomerRepository;
import eapli.base.infrastructure.persistence.PersistenceContext;
import org.springframework.stereotype.Component;

@Component
public class ListCustomerServices {

    CustomerRepository repository = PersistenceContext.repositories().customers();

    public Iterable<Customer> allCustomers() {
        Iterable<Customer> list = repository.findAll();
        return list;
    }

}
