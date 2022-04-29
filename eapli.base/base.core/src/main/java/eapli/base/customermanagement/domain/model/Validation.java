package eapli.base.customermanagement.domain.model;

import eapli.framework.domain.model.Immutable;
import eapli.framework.domain.model.ValueObject;

import javax.persistence.Embeddable;
import java.util.Objects;

@Immutable
@Embeddable

public class Validation implements ValueObject {
    private String email;
    private String phone_number;
    public Validation (String email,String phone_number){
        this.email=email;
        this.phone_number=phone_number;
    }

    protected Validation(){
    }
    public String getEmail() {
        return email;
    }

    public String getPhone_number() {
        return phone_number;
    }

    private void setEmail(String email) {
        this.email = email;
    }

    private void setPhone_number(String phone_number) {
        this.phone_number = phone_number;
    }

    @Override
    public String toString() {
        return "Validation{" +
                "Email='" + email + '\'' +
                ", Phone_Number ='" + phone_number + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Validation validation = (Validation) o;
        return Objects.equals(email, validation.email) && Objects.equals(phone_number, validation.phone_number);
    }
    @Override
    public int hashCode() {
        return Objects.hash(email, phone_number);
    }
}
