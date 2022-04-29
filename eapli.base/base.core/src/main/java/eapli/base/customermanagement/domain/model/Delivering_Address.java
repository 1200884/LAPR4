package eapli.base.customermanagement.domain.model;

import eapli.framework.domain.model.Immutable;
import eapli.framework.domain.model.ValueObject;

import javax.persistence.Embeddable;
import java.util.Objects;
@Immutable
@Embeddable

public class Delivering_Address implements ValueObject {
    private String address;
    private String country;
    public Delivering_Address (String address,String country){
        this.address=address;
        this.country=country;

    }

    protected Delivering_Address(){
    }


    public String getCountry() {
        return country;
    }

    public String getAddress() {
        return address;
    }



    private void setCountry(String country) {
        this.country = country;
    }

    private void setAddress(String address) {
        this.address = address;
    }



    @Override
    public String toString() {
        return "Delivering_Address{" +
                "country='" + country + '\'' +
                ", address ='" + address + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Delivering_Address delivering_address = (Delivering_Address) o;
        return Objects.equals(country, delivering_address.country) && Objects.equals(address, delivering_address.address);
    }
    @Override
    public int hashCode() {
        return Objects.hash(country, address);
    }
}
