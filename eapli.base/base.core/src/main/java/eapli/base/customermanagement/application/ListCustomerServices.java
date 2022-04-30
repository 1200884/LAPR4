package eapli.base.customermanagement.application;

import eapli.base.customermanagement.domain.model.Customer;
import eapli.base.customermanagement.domain.repositories.CustomerRepository;
import eapli.base.infrastructure.persistence.PersistenceContext;
import eapli.framework.infrastructure.authz.application.PasswordPolicy;
import eapli.framework.infrastructure.authz.domain.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

@Component
public class ListCustomerServices {

    CustomerRepository repository = PersistenceContext.repositories().customers();

    public Iterable<Customer> allCustomers() {
        System.out.println("OLAAAAAAAAAAAAAAAA");
        return repository.findAll();
    }

}
