package eapli.base.customermanagement.application;

import eapli.base.customermanagement.domain.model.Customer;
import eapli.base.customermanagement.domain.repositories.CustomerRepository;
import eapli.base.infrastructure.persistence.PersistenceContext;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.ArrayList;
import java.util.Optional;

public class CustomerPersist {
    @Autowired
    CustomerRepository customerRepository= PersistenceContext.repositories().customers();
    public void createcustomerpersist(Customer customer){
        customerRepository.save(customer);
    }
}