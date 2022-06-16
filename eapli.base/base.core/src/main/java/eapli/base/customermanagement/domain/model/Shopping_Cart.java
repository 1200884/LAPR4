package eapli.base.customermanagement.domain.model;

import eapli.base.customermanagement.domain.repositories.CustomerRepository;
import eapli.base.infrastructure.persistence.PersistenceContext;
import eapli.framework.domain.model.Immutable;
import eapli.framework.domain.model.ValueObject;

import javax.persistence.ElementCollection;
import javax.persistence.Embeddable;
import javax.persistence.GeneratedValue;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

@Immutable
@Embeddable

public class Shopping_Cart implements ValueObject {

    private int shoppingCart_ID;
    @ElementCollection
    private Set<Product_Quantities> product_quantities = new HashSet<>();

    protected Shopping_Cart(){

    }
    public Shopping_Cart(int id){
        this.shoppingCart_ID=id;
    }

    public Integer getID() {
        return shoppingCart_ID;
    }

    public Set<Product_Quantities> getProduct_quantities() {
        return product_quantities;
    }

    public void addToCart(Product_Quantities product_quantities){
        this.product_quantities.add(product_quantities);
    }
    @Override
    public String toString() {
        return "Shopping_Cart: \n"+ product_quantities.toString();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Shopping_Cart that = (Shopping_Cart) o;
        return shoppingCart_ID == that.shoppingCart_ID && Objects.equals(product_quantities, that.product_quantities);
    }

    @Override
    public int hashCode() {
        return Objects.hash(shoppingCart_ID);
    }
}
