package eapli.base.customermanagement.application;

import java.util.Set;

import eapli.base.customermanagement.domain.model.Billing_Address;
import eapli.base.customermanagement.domain.model.Customer;
import eapli.base.customermanagement.domain.model.Delivering_Address;
import eapli.base.usermanagement.domain.BaseRoles;
import eapli.framework.infrastructure.authz.application.AuthorizationService;
import eapli.framework.infrastructure.authz.application.AuthzRegistry;

import static javax.persistence.Persistence.createEntityManagerFactory;

public class CustomerController {
    private final AuthorizationService authz = AuthzRegistry.authorizationService();
    CustomerPersist customerPersist=new CustomerPersist();
    public void createCustomer(String nome, int vat, int phonenumber, String email, Set<Billing_Address> billing_addresses, Set<Delivering_Address>delivering_addresses, String birth, String gender) {

        Customer customer = new Customer(nome,vat, phonenumber, email);
        customer.setBilling_addresses(billing_addresses);
        customer.setDelivering_addresses(delivering_addresses);
        customer.setBirth_date(birth);
        customer.setGender(gender);
        customerPersist.createcustomerpersist(customer);
    }



}
