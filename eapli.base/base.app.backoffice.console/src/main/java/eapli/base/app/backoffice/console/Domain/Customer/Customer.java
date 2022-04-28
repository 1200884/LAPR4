package eapli.base.app.backoffice.console.Domain.Customer;

import eapli.base.app.backoffice.console.Domain.Product.Product;

import javax.persistence.*;
import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

@Entity
public class Customer implements Serializable {
    @Id
    private int vat;
    private int phone_number;
    private String birth_date, gender, email, name;
    private final int vat_default = 0, phone_numberdefault = 0;
    private final String birth_datedefault = "No birth daate available", gender_default = "No gender available", email_default = "No email available";
    @ElementCollection
    private Set<Billing_Address> billing_addresses = new HashSet<>();
    @ElementCollection
    private Set<Delivering_Address> delivering_addresses = new HashSet<>();
    @ElementCollection
    private Set<Product_Quantities> product_quantities = new HashSet<>();
    @Embedded
    private Shopping_Cart shopping_cart;
    @Embedded
    private Validation validation;

    protected Customer() {
        this.email = email_default;
        this.vat = vat_default;
        this.phone_number = phone_numberdefault;
        this.name = "No name available";
    }

    public Customer(String name, int vat, int phone_number, String email) {
        this.vat = vat;
        this.name = name;
        this.phone_number = phone_number;
        this.email = email;
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

    public void setProduct_quantities(Set<Product_Quantities> product_quantities) {
        this.product_quantities = product_quantities;
    }

    public void addProduct_quantities(Product_Quantities product_quantities) {
        this.product_quantities.add(product_quantities);
    }

    public void setValidation(Validation validation) {
        this.validation = validation;
    }

    public void setShopping_cart(Shopping_Cart shopping_cart) {
        this.shopping_cart = shopping_cart;
    }

    public Set<Product_Quantities> getProduct_quantities() {
        return product_quantities;
    }

    public Validation getValidation() {
        return validation;
    }

    public void setPhone_number(int phone_number) {
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

    public int getVat() {
        return vat;
    }
}
