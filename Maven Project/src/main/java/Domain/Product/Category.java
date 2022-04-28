package Domain.Product;

import eapli.framework.domain.model.ValueObject;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.util.Objects;

@Entity
public class Category implements ValueObject {
    @Id
    @GeneratedValue
    private int category_ID;
    private String description;

    public Category() {
        this.category_ID = 0;
        this.description = "No description available";
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

    public void setDescription(String description1){
        this.description=description1;
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

