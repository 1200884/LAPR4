package eapli.base.customermanagement.domain.model;

import eapli.framework.domain.model.Immutable;
import eapli.framework.domain.model.ValueObject;

import javax.persistence.Embeddable;
import java.util.Objects;

@Immutable
@Embeddable

public class Product_Quantities implements ValueObject {
    private int product_id;
    private int quantity;
    public Product_Quantities (int product_id, int quantity){
        this.product_id=product_id;
        this.quantity=quantity;
    }

    protected Product_Quantities(){
    }



    public Integer getProduct_id() {
        return product_id;
    }

    public Integer getQuantity(){
        return quantity;
    }

    private void setProduct_id(int product_id) {
        this.product_id = product_id;
    }

    private void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public void addQuantity(int quantity){
        this.quantity += quantity;
    }

    @Override
    public String toString() {
        return "Product id : " + product_id + " quantity: " + quantity;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Product_Quantities product_quantities = (Product_Quantities) o;
        return Objects.equals(product_id, product_quantities.product_id) && Objects.equals(quantity, product_quantities.quantity);
    }
    @Override
    public int hashCode() {
        return Objects.hash(product_id, quantity);
    }
}
