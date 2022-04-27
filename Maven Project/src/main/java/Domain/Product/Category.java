package Domain.Product;

import eapli.framework.domain.model.Immutable;
import eapli.framework.domain.model.ValueObject;

import javax.persistence.Embeddable;
import java.util.Objects;
@Immutable
@Embeddable

public class Category implements ValueObject {
    private Integer category_ID;
    private String description;

    public Category (){
    }

    public void setCategory_ID( Integer category_ID) {
        this.category_ID = category_ID;
    }

    public void setDescription( String description) {
        this.description = description;
    }

    public Integer getCategory_ID() {
        return category_ID;
    }

    public String getDescription() {
        return description;
    }

    @Override
    public String toString() {
        return "Category{" +
                "category_ID='" + category_ID + '\'' +
                ", Description ='" + description + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Category category  = (Category) o;
        return Objects.equals(category_ID, category.category_ID) && Objects.equals(description, category.description);
    }
    @Override
    public int hashCode() {
        return Objects.hash(category_ID, description);
    }
}

