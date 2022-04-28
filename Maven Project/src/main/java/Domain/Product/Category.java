package Domain.Product;

import eapli.framework.domain.model.Immutable;
import eapli.framework.domain.model.ValueObject;

import javax.persistence.Embeddable;
import javax.persistence.GeneratedValue;
import java.util.Objects;

@Immutable
@Embeddable

public class Category implements ValueObject {
    @GeneratedValue
    private final int category_ID;
    private final String description;
    private final int category_ID_default = 0;
    private final String description_default = "No description available";

    public Category() {
        this.category_ID = category_ID_default;
        this.description = description_default;
    }

    public Category(int category_ID, String description) {
        this.category_ID = category_ID;
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
        Category category = (Category) o;
        return Objects.equals(category_ID, category.category_ID) && Objects.equals(description, category.description);
    }

    @Override
    public int hashCode() {
        return Objects.hash(category_ID, description);
    }
}

