package eapli.base.customermanagement.domain.model;

import eapli.base.infrastructure.persistence.PersistenceContext;
import eapli.framework.domain.model.AggregateRoot;
import eapli.framework.domain.model.DomainEntity;

import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

@Entity
public class Customer implements Serializable, DomainEntity<Integer>, AggregateRoot<Integer>{
    @Id
    private int vat;
    private String birth_date;
    private String gender;
    @Column(nullable = false)
    private String email;
    @Column(nullable = false)
    private Integer phone_number;
    private String name;
    @ElementCollection
    private Set<Billing_Address> billing_addresses = new HashSet<>();
    @ElementCollection
    private Set<Delivering_Address> delivering_addresses = new HashSet<>();
    @Embedded
    private Shopping_Cart shopping_cart;


    protected Customer() {
    }

    public Customer(String name, int vat, int phone_number, String email) {
        this.vat = vat;
        this.name = name;
        this.phone_number = phone_number;
        this.email = email;
        this.shopping_cart=new Shopping_Cart(generateValue());
    }

    private int generateValue() {
        ArrayList<Customer> list = (ArrayList<Customer>) PersistenceContext.repositories().customers().findAll();
        return list.size()+1;
    }

    public Set<Billing_Address> getBilling_addresses() {
        return billing_addresses;
    }

    public Set<Delivering_Address> getDelivering_addresses() {
        return delivering_addresses;
    }

    public Shopping_Cart getShopping_cart() {
        return shopping_cart;
    }

    public void setBilling_addresses(Set<Billing_Address> billing_addresses) {
        this.billing_addresses = billing_addresses;
    }

    public void addBiling_adresses(Billing_Address billing_addresses) {
        this.billing_addresses.add(billing_addresses);
    }

    public void setDelivering_addresses(Set<Delivering_Address> delivering_addresses) {
        this.delivering_addresses = delivering_addresses;
    }

    public void addDelivering_adresses(Delivering_Address delivering_address) {
        this.delivering_addresses.add((delivering_address));
    }

    public void setShopping_cart(Shopping_Cart shopping_cart) {
        this.shopping_cart = shopping_cart;
    }


    public void setPhone_number(Integer phone_number) {
        this.phone_number = phone_number;
    }

    public void setVat(int vat) {
        this.vat = vat;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setBirth_date(String birth_date) {
        this.birth_date = birth_date;
    }

    public String getGender() {
        return gender;
    }

    public String getEmail() {
        return email;
    }

    public String getBirth_date() {
        return birth_date;
    }

    public int getPhone_number() {
        return phone_number;
    }

    public String getName() {
        return name;
    }

    public int getVat() {
        return vat;
    }

    @Override
    public boolean sameAs(Object other) {
        return false;
    }

    @Override
    public Integer identity() {
        return null;
    }

    @Override
    public String toString() {
        return "Customer{" +
                "vat=" + vat +
                ", email='" + email + '\'' +
                ", phone_number=" + phone_number +
                ", name='" + name + '\'' +
                '}';
    }
}
