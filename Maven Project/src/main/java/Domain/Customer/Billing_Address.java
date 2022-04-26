package Domain.Customer;

import com.sun.beans.decoder.ValueObject;
import com.sun.istack.NotNull;

public class Billing_Address{
    private String address;
    private String country;
    public Billing_Address (){
    }

    public void setcountry(@NotNull String country) {
        this.country = country;
    }

    public void setAddress(@NotNull String address) {
        this.address = address;
    }

    public String getCountry() {
        return country;
    }

    public String getAddress() {
        return address;
    }
}
