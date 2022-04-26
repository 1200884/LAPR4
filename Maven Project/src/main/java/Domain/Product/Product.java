package Domain.Product;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Product {
    @Id
    private int id;
    private int photos_id;
    private int baseprice;
    private String name;
    private final int id_default = 0, photos_id_default = 0, base_price_default = 0;

    public Product(int id, String name, int photos_id, int baseprice) {
        this.id = id;
        this.name = name;
        this.photos_id = photos_id;
        this.baseprice = baseprice;
    }

    public Product() {
        this.id = id_default;
        String name_default = "No Name";
        this.name = name_default;
        this.baseprice = base_price_default;
        this.photos_id = photos_id_default;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setBaseprice(int baseprice) {
        this.baseprice = baseprice;
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
}
