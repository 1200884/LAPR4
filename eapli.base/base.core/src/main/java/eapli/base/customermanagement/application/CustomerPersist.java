package eapli.base.customermanagement.application;

import eapli.base.customermanagement.domain.model.Customer;
import eapli.base.customermanagement.domain.repositories.CustomerRepository;
import eapli.base.infrastructure.persistence.PersistenceContext;
import org.springframework.beans.factory.annotation.Autowired;

public class CustomerPersist {
    @Autowired
    CustomerRepository customerRepository= PersistenceContext.repositories().customers();
    public void createCustomerPersist(Customer customer){
        customerRepository.save(customer);
    }
}