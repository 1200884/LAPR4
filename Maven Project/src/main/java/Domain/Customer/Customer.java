package Domain.Customer;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Customer {
    @Id
    private int vat;
    int phone_number;
    private String birth_date, gender, email;
    private final int vat_default = 0, phone_numberdefault = 0;
    private final String birth_datedefault = "No birth daate available", gender_default = "No gender available", email_default = "No email available";

    public Customer() {
        this.birth_date = birth_datedefault;
        this.email = email_default;
        this.gender = gender_default;
        this.vat = vat_default;
        this.phone_number = phone_numberdefault;
    }

    public Customer(int vat, int phone_number, String birth_date, String gender, String email) {
        this.vat = vat;
        this.phone_number = phone_number;
        this.birth_date = birth_date;
        this.gender = gender;
        this.email = email;
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
