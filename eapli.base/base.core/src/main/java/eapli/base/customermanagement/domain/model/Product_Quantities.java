package eapli.base.customermanagement.domain.model;

import eapli.framework.domain.model.Immutable;
import eapli.framework.domain.model.ValueObject;

import javax.persistence.Embeddable;
import java.util.Objects;

@Immutable
@Embeddable

public class Product_Quantities implements ValueObject {
    private int shopping_cart_id;
    private int product_id;
    private int quantity;
    public Product_Quantities (int shopping_cart_id, int product_id, int quantity){
        this.product_id=product_id;
        this.quantity=quantity;
        this.shopping_cart_id=shopping_cart_id;
    }

    protected Product_Quantities(){
    }


    public Integer getShopping_cart_id(){
        return shopping_cart_id;
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

    private void setShopping_cart_id(int shopping_cart_id) {
        this.shopping_cart_id = shopping_cart_id;
    }

    @Override
    public String toString() {
        return "Product_Quantities{" +
                "shopping_cart_id='" + shopping_cart_id + '\'' +
                ", product_id ='" + product_id + '\'' +
                ", quantity = " + quantity + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Product_Quantities product_quantities = (Product_Quantities) o;
        return Objects.equals(shopping_cart_id, product_quantities.shopping_cart_id) && Objects.equals(product_id, product_quantities.product_id) && Objects.equals(quantity, product_quantities.quantity);
    }
    @Override
    public int hashCode() {
        return Objects.hash(shopping_cart_id, product_id, quantity);
    }
}
