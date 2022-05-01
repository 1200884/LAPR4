package eapli.base.brandmanagement.domain;

import eapli.base.productmanagement.Product.domain.Product;
import eapli.framework.domain.model.AggregateRoot;
import eapli.framework.domain.model.ValueObject;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Objects;

@Entity
public class Brand implements ValueObject, AggregateRoot<Integer> {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int brand_id;
    private String name;
    private String reference;

    @OneToMany (cascade = CascadeType.ALL)
    private Collection<Product> products = new ArrayList<>();

    protected Brand() {
    }

    public Brand(String name, String reference) {
        this.reference = reference;
        this.name = name;
    }

    public int getBrand_id() {
        return brand_id;
    }

    public String getName() {
        return name;
    }

    public String getReference() {
        return reference;
    }

    public void addProduct(Product product) {
        products.add(product);
    }

    @Override
    public String toString() {
        return "Brand{" +
                "brand_id='" + brand_id + '\'' +
                ", name ='" + name + '\'' +
                ", reference = " + reference + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Brand brand = (Brand) o;
        return Objects.equals(brand_id, brand.brand_id) && Objects.equals(name, brand.name) && Objects.equals(reference, brand.reference);
    }

    @Override
    public int hashCode() {
        return Objects.hash(brand_id, name, reference);
    }

    @Override
    public boolean sameAs(Object other) {
        return false;
    }

    @Override
    public Integer identity() {
        return null;
    }
}
