package Domain.Product;

import eapli.framework.domain.model.Immutable;
import eapli.framework.domain.model.ValueObject;

import javax.persistence.Embeddable;
import javax.persistence.criteria.CriteriaBuilder;
import java.util.Objects;

@Immutable
@Embeddable

public class Brand implements ValueObject {
    private Integer brand_id;
    private String name;
    private String reference;
    public Brand (){
    }

    public void setBrand_id( Integer brand_id) {
        this.brand_id = brand_id;
    }

    public void setName( String name) {
        this.name = name;
    }
    public void setReference(String reference){
        this.reference = reference;
    }

    public Integer getBrand_id() {
        return brand_id;
    }

    public String getName() {
        return name;
    }
    public String getReference(){
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
        Brand brand  = (Brand) o;
        return Objects.equals(brand_id, brand.brand_id) && Objects.equals(name, brand.name) && Objects.equals(reference, brand.reference);
    }
    @Override
    public int hashCode() {
        return Objects.hash(brand_id, name, reference);
    }
}
