package Domain.Customer;

import eapli.framework.domain.model.Immutable;
import eapli.framework.domain.model.ValueObject;

import javax.persistence.Embeddable;
import java.util.Objects;

@Immutable
@Embeddable

public class Product_Quantities implements ValueObject {
    private final int shopping_cart_id;
    private final int product_id;
    private final int quantity;
    public Product_Quantities (int shopping_cart_id, int product_id, int quantity){
        this.product_id=product_id;
        this.quantity=quantity;
        this.shopping_cart_id=shopping_cart_id;
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
