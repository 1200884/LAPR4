package eapli.base.customermanagement.domain.model;

import eapli.base.productmanagement.Product.domain.Product;
import eapli.framework.domain.model.Immutable;
import eapli.framework.domain.model.ValueObject;

import javax.persistence.Embeddable;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import java.util.Objects;

@Immutable
@Embeddable

public class Product_Quantities implements ValueObject {
    @OneToOne
    @JoinColumn(name = "product_id")
    private Product product;
    private int quantity;

    public void setProduct(Product product) {
        this.product = product;
    }

    public Product_Quantities (Product product, int quantity){
        this.product=product;
        this.quantity=quantity;
    }

    protected Product_Quantities(){
    }



    public Product getProduct() {
        return product;
    }

    public Integer getQuantity(){
        return quantity;
    }

    private void setProduct_id(Product product_id) {
        this.product = product_id;
    }

    private void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public void addQuantity(int quantity){
        this.quantity += quantity;
    }

    @Override
    public String toString() {
        return "Product id : " + product.getId() + " quantity: " + quantity;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Product_Quantities product_quantities = (Product_Quantities) o;
        return Objects.equals(product, product_quantities.product) && Objects.equals(quantity, product_quantities.quantity);
    }
    @Override
    public int hashCode() {
        return Objects.hash(product, quantity);
    }
}
