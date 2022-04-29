package eapli.base.customermanagement.domain.model;

import eapli.framework.domain.model.Immutable;
import eapli.framework.domain.model.ValueObject;

import javax.persistence.ElementCollection;
import javax.persistence.Embeddable;
import javax.persistence.GeneratedValue;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

@Immutable
@Embeddable

public class Shopping_Cart implements ValueObject {
    @GeneratedValue
    private int ID;
    @ElementCollection
    private Set<Product_Quantities> product_quantities = new HashSet<>();

    public Shopping_Cart(){
    }

    public Integer getID() {
        return ID;
    }

    public Set<Product_Quantities> getProduct_quantities() {
        return product_quantities;
    }

    public void addToCart(Product_Quantities product_quantities){
        this.product_quantities.add(product_quantities);
    }
    @Override
    public String toString() {
        return "Shopping_Cart{" +
                "ID=" + ID +
                ", product_quantities=" + product_quantities +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Shopping_Cart that = (Shopping_Cart) o;
        return ID == that.ID && Objects.equals(product_quantities, that.product_quantities);
    }

    @Override
    public int hashCode() {
        return Objects.hash(ID);
    }
}
