package eapli.base.productmanagement.Product.domain;

import eapli.framework.domain.model.Immutable;
import eapli.framework.domain.model.ValueObject;

import javax.persistence.Embeddable;
import java.util.Objects;
import java.util.Random;

@Immutable
@Embeddable

public class Barcode implements ValueObject {

    private static final int LOW = 10000000;
    private static final int MAX = 99999999;

    private int barcode_ID;
    private String type_of_barcode;

    public Barcode (){
    }

    public Barcode(String type_of_barcode){
        Random r = new Random();
        int prov = r.nextInt(MAX-LOW) + LOW;
        while (!isBarcodeValid(prov)){
            prov = r.nextInt(MAX-LOW) + LOW;
        }
        this.barcode_ID = prov;
        this.type_of_barcode=type_of_barcode;
    }

    public boolean isBarcodeValid(int num) {
        return LOW <= num && num <= MAX;
    }

    public Integer getBarcode_ID() {
        return barcode_ID;
    }

    public String getType_of_barcode() {
        return type_of_barcode;
    }

    private void setBarcode_ID(int barcode_ID) {
        this.barcode_ID = barcode_ID;
    }

    private void setType_of_barcode(String type_of_barcode) {
        this.type_of_barcode = type_of_barcode;
    }

    @Override
    public String toString() {
        return "ID: " + barcode_ID + "\nType of barcode: " + type_of_barcode;
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
