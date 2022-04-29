package eapli.base.productmanagement.Product.domain;

import eapli.framework.domain.model.ValueObject;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.util.Objects;

@Entity

public class Brand implements ValueObject {
    @Id
    @GeneratedValue
    private int brand_id;
    private String name;
    private String reference;

    protected Brand() {
    }

    public Brand(String name, String reference) {
        this.reference = reference;
        this.name = name;
    }

    public Integer getBrand_id() {
        return brand_id;
    }

    public String getName() {
        return name;
    }

    public String getReference() {
        return reference;
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
}
