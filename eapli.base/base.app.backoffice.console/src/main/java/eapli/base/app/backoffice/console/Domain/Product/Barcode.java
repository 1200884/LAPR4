package eapli.base.app.backoffice.console.Domain.Product;

import eapli.framework.domain.model.Immutable;
import eapli.framework.domain.model.ValueObject;

import javax.persistence.Embeddable;
import java.util.Objects;

@Immutable
@Embeddable

public class Barcode implements ValueObject {
    private int barcode_ID;
    private String type_of_barcode;

    public Barcode (){
    }

    public Barcode(int barcode_ID,String type_of_barcode){
        this.barcode_ID=barcode_ID;
        this.type_of_barcode=type_of_barcode;
    }

    public Integer getBarcode_ID() {
        return barcode_ID;
    }

    public String getType_of_barcode() {
        return type_of_barcode;
    }

    @Override
    public String toString() {
        return "Barcode{" +
                "Barcode_ID='" + barcode_ID + '\'' +
                ", Type_of_barcode ='" + type_of_barcode + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Barcode barcode = (Barcode) o;
        return Objects.equals(barcode_ID, barcode.barcode_ID) && Objects.equals(type_of_barcode, barcode.type_of_barcode);
    }
    @Override
    public int hashCode() {
        return Objects.hash(barcode_ID, type_of_barcode);
    }
}
