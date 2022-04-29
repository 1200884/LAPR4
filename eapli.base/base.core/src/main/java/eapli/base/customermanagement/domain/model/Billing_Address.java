package eapli.base.customermanagement.domain.model;

import eapli.framework.domain.model.Immutable;
import eapli.framework.domain.model.ValueObject;

import javax.persistence.Embeddable;
import java.util.Objects;

@Immutable
@Embeddable

public class Billing_Address implements ValueObject{
    private String address;
    private String country;

    protected Billing_Address() {
    }

    public Billing_Address (String address,String country){
    this.address=address;
    this.country=country;
    }


    public String getCountry() {
        return country;
    }

    public String getAddress() {
        return address;
    }


    private void setAddress(String address) {
        this.address = address;
    }

    private void setCountry(String country) {
        this.country = country;
    }

    @Override
    public String toString() {
        return "Billing_Address{" +
                "country='" + country + '\'' +
                ", address ='" + address + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Billing_Address billing_address = (Billing_Address) o;
        return Objects.equals(country, billing_address.country) && Objects.equals(address, billing_address.address);
    }
    @Override
    public int hashCode() {
        return Objects.hash(country, address);
    }
}
