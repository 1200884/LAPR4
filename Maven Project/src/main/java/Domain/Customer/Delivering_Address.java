package Domain.Customer;

import eapli.framework.domain.model.Immutable;
import eapli.framework.domain.model.ValueObject;

import javax.persistence.Embeddable;
import java.util.Objects;
@Immutable
@Embeddable

public class Delivering_Address implements ValueObject {
    private String address;
    private String country;
    private int tax;
    public Delivering_Address (int tax, String address,String country){
        this.address=address;
        this.country=country;
        this.tax=tax;
    }


    public String getCountry() {
        return country;
    }

    public String getAddress() {
        return address;
    }

    public Integer getTax(){
        return tax;
    }

    @Override
    public String toString() {
        return "Delivering_Address{" +
                "country='" + country + '\'' +
                ", address ='" + address + '\'' +
                ", tax = " + tax + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Delivering_Address delivering_address = (Delivering_Address) o;
        return Objects.equals(country, delivering_address.country) && Objects.equals(address, delivering_address.address) && Objects.equals(tax, delivering_address.tax);
    }
    @Override
    public int hashCode() {
        return Objects.hash(country, address, tax);
    }
}
