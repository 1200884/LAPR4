package Domain.Customer;

import eapli.framework.domain.model.Immutable;
import eapli.framework.domain.model.ValueObject;

import javax.persistence.Embeddable;
import javax.persistence.GeneratedValue;
import java.util.Objects;

@Immutable
@Embeddable

public class Shopping_Cart implements ValueObject {
    @GeneratedValue
    private int ID;
    private final int customer_id;

    public Shopping_Cart(int customer_id) {
        this.customer_id = customer_id;
    }

    public Integer getID() {
        return ID;
    }

    public Integer getCustomer_id() {
        return customer_id;
    }

    @Override
    public String toString() {
        return "Shopping_Cart{" +
                "ID='" + ID + '\'' +
                ", Customer_ID ='" + customer_id + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Shopping_Cart shopping_cart = (Shopping_Cart) o;
        return Objects.equals(ID, shopping_cart.ID) && Objects.equals(customer_id, shopping_cart.customer_id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(ID, customer_id);
    }
}
