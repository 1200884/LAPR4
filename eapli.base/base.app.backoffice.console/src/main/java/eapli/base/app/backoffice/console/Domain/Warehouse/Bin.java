package eapli.base.app.backoffice.console.Domain.Warehouse;

import eapli.framework.domain.model.Immutable;
import eapli.framework.domain.model.ValueObject;

import javax.persistence.Embeddable;
import java.util.Objects;

@Immutable
@Embeddable

public class Bin implements ValueObject {
    private String size; //Não sei se é int ou String
    public Bin (){
    }

    public void setSize( String size) {
        this.size = size;
    }

    public String getSize() {
        return size;
    }

    @Override
    public String toString() {
        return "Bin{" +
                "size='" + size + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Bin bin = (Bin) o;
        return Objects.equals(size, bin.size);
    }
    @Override
    public int hashCode() {
        return Objects.hash(size);
    }
}
