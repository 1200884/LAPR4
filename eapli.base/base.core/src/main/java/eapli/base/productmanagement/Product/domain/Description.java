package eapli.base.productmanagement.Product.domain;

import eapli.framework.domain.model.Immutable;
import eapli.framework.domain.model.ValueObject;

import javax.persistence.Embeddable;
import java.util.Objects;
@Immutable
@Embeddable

public class Description implements ValueObject {
    private String short_description;
    private String extended_description;

    public Description (String short_description, String extended_description){
        this.extended_description=extended_description;
        this.short_description=short_description;
    }

    protected Description(){
    }

    public String getShort_description() {
        return short_description;
    }

    public String getExtended_description() {
        return extended_description;
    }

    private void setExtended_description(String extended_description) {
        this.extended_description = extended_description;
    }

    private void setShort_description(String short_description) {
        this.short_description = short_description;
    }

    @Override
    public String toString() {
        return "Short Description: " + short_description + "\nExtended Description: " + extended_description;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Description description  = (Description) o;
        return Objects.equals(short_description, description.short_description) && Objects.equals(extended_description, description.extended_description);
    }
    @Override
    public int hashCode() {
        return Objects.hash(short_description, extended_description);
    }
}
