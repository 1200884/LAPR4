package eapli.base.app.backoffice.console.Domain.Product;

import javax.persistence.*;
import java.io.Serializable;


@Entity
public class Product implements Serializable {
    @Id
    @GeneratedValue
    private int id;
    private int photos_id;
    private int baseprice;
    private String name;
    private final int id_default = 0, photos_id_default = 0, base_price_default = 0;
    private final String NAME_DEFAULT = "No Name";

    @ManyToOne
    private Category category;
    @Embedded
    private Description description;
    @Embedded
    private Barcode barcode;
    @Embedded
    private Brand brand;

    public Product(String name, int photos_id, int baseprice, Category category,Barcode barcode1,Brand brand) {
        this.name = name;
        this.photos_id = photos_id;
        this.baseprice = baseprice;
        //this.category=category;
        barcode=barcode1;
        this.brand=brand;
    }

    protected Product() {
        this.id = id_default;
        this.name = NAME_DEFAULT;
        this.baseprice = base_price_default;
        this.photos_id = photos_id_default;
    }
    public Description getDescription() {
        return description;
    }

    public void setDescription(Description description1) {
        description = description1;
    }

    public String getName() {
        return name;
    }

    public void setBaseprice(int baseprice) {
        this.baseprice = baseprice;
    }

    public Category getCategory() {
        return category;
    }

    public int getBaseprice() {
        return baseprice;
    }

    public void setPhotos_id(int photos_id) {
        this.photos_id = photos_id;
    }

    public int getPhotos_id() {
        return photos_id;
    }

    public int getId() {
        return id;
    }

    public Barcode getBarcode() {
        return barcode;
    }

    public void setBarcode(Barcode barcode1) {
        barcode = barcode1;
    }
}