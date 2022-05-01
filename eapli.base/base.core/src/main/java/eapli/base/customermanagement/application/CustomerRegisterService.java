package eapli.base.customermanagement.application;

import eapli.base.customermanagement.domain.model.Billing_Address;
import eapli.base.customermanagement.domain.model.Customer;
import eapli.base.customermanagement.domain.model.Delivering_Address;
import org.springframework.stereotype.Component;


import javax.transaction.Transactional;
import java.util.*;

@Component
public class CustomerRegisterService {
   CustomerPersist customerPersist=new CustomerPersist();


    private void createCustomer(String nome, int vat, int phonenumber, String email, Set<Billing_Address> billing_addresses, Set<Delivering_Address> delivering_addresses, String birth, String gender) {
        Customer customer = new Customer(nome, vat, phonenumber, email);
        customer.setBilling_addresses(billing_addresses);
        customer.setDelivering_addresses(delivering_addresses);
        customer.setBirth_date(birth);
        customer.setGender(gender);
        customerPersist.createcustomerpersist(customer);

    }

    @Transactional
    public void registerCustomer(String nome, int vat, int phonenumber, String email, String billingadresscountry, String billingadressadress, String delivering_addresscountry, String delivering_adressadress, String birth, String gender) {
        Billing_Address billing_address =  new Billing_Address(billingadressadress, billingadresscountry);
        Delivering_Address delivering_address = new Delivering_Address(delivering_adressadress, delivering_addresscountry);
        Set<Billing_Address> b= new HashSet<>();
        b.add(billing_address);
        Set<Delivering_Address> d= new HashSet<>();
        d.add(delivering_address);
        createCustomer(nome, vat, phonenumber, email,  b, d, birth, gender);
    }
}
