package eapli.base.productmanagement.Product.domain;

import eapli.framework.domain.model.AggregateRoot;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Arrays;


@Entity
public class Product implements Serializable, AggregateRoot<Integer> {
    @Id
    @GeneratedValue
    private int id;
    private byte[] photo;
    private double base_price;
    private String name;

    @ManyToOne
    private Category category;
    @Embedded
    private Description description;
    @Embedded
    private Barcode barcode;
    @ManyToOne
    private Brand brand;

    public Product(String name, byte[] photo, double base_price, Category category, Barcode barcode, Brand brand) {
        this.name = name;
        this.photo = photo;
        this.base_price = base_price;
        this.category=category;
        this.barcode=barcode;
        this.brand=brand;
    }

    protected Product() {
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

    public void setName(String name) {
        this.name = name;
    }

    public void setBase_price(int base_price) {
        this.base_price = base_price;
    }

    public Category getCategory() {
        return category;
    }

    public double getBase_price() {
        return base_price;
    }

    public void setPhoto(byte[] photo) {
        this.photo = photo;
    }

    public byte[] getPhoto() {
        return photo;
    }

    public int getId() {
        return id;
    }

    public Barcode getBarcode() {
        return barcode;
    }

    @Override
    public String toString() {
        return "ID:\n" + id + "\nPhoto:\n" + Arrays.toString(photo) +"\nBase Price:\n" + base_price + "\nName:\n" + name + "\nCategory:\n" + category + "\nDescription:\n" + description + "\nBarcode:\n" + barcode + "\nBrand:\n" + brand;
    }

    @Override
    public boolean sameAs(Object other) {
        return false;
    }

    @Override
    public Integer identity() {
        return null;
    }
}



