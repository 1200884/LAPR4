package Domain.Product;

import eapli.framework.domain.model.Immutable;
import eapli.framework.domain.model.ValueObject;

import javax.persistence.Embeddable;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.criteria.CriteriaBuilder;
import java.util.Objects;

@Immutable
@Embeddable

public class Brand implements ValueObject {
    @GeneratedValue
    private final int brand_id;
    private final String name;
    private final String reference;

    public Brand() {
        int brand_id_default = 0;
        this.brand_id = brand_id_default;
        String name_default = "No name available";
        this.name = name_default;
        String reference_default = "No reference available";
        this.reference = reference_default;
    }

    public Brand(int brand_id, String name, String reference) {
        this.reference = reference;
        this.brand_id = brand_id;
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
