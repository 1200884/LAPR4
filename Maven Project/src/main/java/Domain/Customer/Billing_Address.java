package Domain.Customer;

import Domain.AGV.Status;
import com.sun.istack.NotNull;
import eapli.framework.domain.model.Immutable;
import eapli.framework.domain.model.ValueObject;

import javax.persistence.Embeddable;
import java.util.Objects;

@Immutable
@Embeddable

public class Billing_Address implements ValueObject{
    private final String address;
    private final String country;
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
