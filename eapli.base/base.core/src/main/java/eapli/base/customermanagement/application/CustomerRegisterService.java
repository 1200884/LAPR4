package eapli.base.customermanagement.application;

import eapli.base.customermanagement.domain.model.Billing_Address;
import eapli.base.customermanagement.domain.model.Customer;
import eapli.base.customermanagement.domain.model.Delivering_Address;


import java.util.Collection;
import java.util.Iterator;

import java.util.Set;

public class CustomerRegisterService {
   CustomerPersist customerPersist=new CustomerPersist();


    private void createCustomer(String nome, int vat, int phonenumber, String email, Set<Billing_Address> billing_addresses, Set<Delivering_Address> delivering_addresses, String birth, String gender) {
        System.out.println("17 service");
        Customer customer = new Customer(nome, vat, phonenumber, email);
        customer.setBilling_addresses(billing_addresses);
        customer.setDelivering_addresses(delivering_addresses);
        customer.setBirth_date(birth);
        customer.setGender(gender);
        System.out.println("23 service");
        customerPersist.createcustomerpersist(customer);

    }
    public void registerCustomer(String nome, int vat, int phonenumber, String email, String billingadresscountry, String billingadressadress, String delivering_addresscountry, String delivering_adressadress, String birth, String gender) {
        System.out.println("lalala");
        Billing_Address billing_address =  new Billing_Address(billingadressadress, billingadresscountry);
        Delivering_Address delivering_address = new Delivering_Address(delivering_adressadress, delivering_addresscountry);
        Set<Billing_Address> b= new Set<>() {
            @Override
            public int size() {
                return 0;
            }

            @Override
            public boolean isEmpty() {
                return false;
            }

            @Override
            public boolean contains(Object o) {
                return false;
            }

            @Override
            public Iterator<Billing_Address> iterator() {
                return null;
            }

            @Override
            public Object[] toArray() {
                return new Object[0];
            }

            @Override
            public <T> T[] toArray(T[] a) {
                return null;
            }

            @Override
            public boolean add(Billing_Address billing_address) {
                return false;
            }

            @Override
            public boolean remove(Object o) {
                return false;
            }

            @Override
            public boolean containsAll(Collection<?> c) {
                return false;
            }

            @Override
            public boolean addAll(Collection<? extends Billing_Address> c) {
                return false;
            }

            @Override
            public boolean retainAll(Collection<?> c) {
                return false;
            }

            @Override
            public boolean removeAll(Collection<?> c) {
                return false;
            }

            @Override
            public void clear() {

            }
        };
        b.add(billing_address);
        Set<Delivering_Address> d= new Set<>() {
            @Override
            public int size() {
                return 0;
            }

            @Override
            public boolean isEmpty() {
                return false;
            }

            @Override
            public boolean contains(Object o) {
                return false;
            }

            @Override
            public Iterator<Delivering_Address> iterator() {
                return null;
            }

            @Override
            public Object[] toArray() {
                return new Object[0];
            }

            @Override
            public <T> T[] toArray(T[] a) {
                return null;
            }

            @Override
            public boolean add(Delivering_Address delivering_address) {
                return false;
            }

            @Override
            public boolean remove(Object o) {
                return false;
            }

            @Override
            public boolean containsAll(Collection<?> c) {
                return false;
            }

            @Override
            public boolean addAll(Collection<? extends Delivering_Address> c) {
                return false;
            }

            @Override
            public boolean retainAll(Collection<?> c) {
                return false;
            }

            @Override
            public boolean removeAll(Collection<?> c) {
                return false;
            }

            @Override
            public void clear() {

            }
        };
        d.add(delivering_address);
        System.out.println("30 service");
        System.out.println("delivering address"+delivering_address);
        createCustomer(nome, vat, phonenumber, email,  b, d, birth, gender);
    }
}
