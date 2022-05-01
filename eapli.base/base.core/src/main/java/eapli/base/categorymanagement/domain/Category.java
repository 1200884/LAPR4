package eapli.base.categorymanagement.domain;

import eapli.base.productmanagement.Product.domain.Product;
import eapli.framework.domain.model.AggregateRoot;
import eapli.framework.domain.model.ValueObject;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Objects;

@Entity
public class Category implements ValueObject, AggregateRoot<Integer> {
    @Id
    @GeneratedValue
    private int category_ID;
    @Column (unique = true)
    private String description;

    @OneToMany (cascade = CascadeType.ALL)
    private Collection<Product> products = new ArrayList<>();

    protected Category() {
    }

    public Category(String description) {
        this.description = description;
    }

    public Integer getCategory_ID() {
        return category_ID;
    }

    public String getDescription() {
        return description;
    }

    public void addProduct(Product product) {
        products.add(product);
    }

    public void setDescription(String description1){
        this.description=description1;
    }

    @Override
    public String toString() {
        return  "Category ID = " + category_ID + "\nDescription = " + description;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Category category = (Category) o;
        return Objects.equals(category_ID, category.category_ID) && Objects.equals(description, category.description);
    }

    @Override
    public int hashCode() {
        return Objects.hash(category_ID, description);
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

