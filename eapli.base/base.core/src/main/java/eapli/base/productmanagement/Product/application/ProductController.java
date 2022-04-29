package eapli.base.productmanagement.Product.application;

import eapli.base.productmanagement.Product.domain.Barcode;
import eapli.base.productmanagement.Product.domain.Brand;
import eapli.base.productmanagement.Product.domain.Category;
import eapli.base.productmanagement.Product.domain.Product;
import eapli.base.productmanagement.Product.repositories.CategoryRepository;

public class ProductController {

    public String creteProduct(String name, byte[] photo, double basePrice, int categoryNum, int brandNum) {
        Product product = new Product(name, photo, basePrice, fetchCategory(categoryNum), createBarcode(), fetchBrand(brandNum));
        //product persist
        return product.toString();
    }

    private Category fetchCategory(int categoryNum) {  // ir buscar a lista que foi dada ao utilizador e ir buscar o msm numero
        Category category = new Category(1, "prov");
        return category;
    }

    private Brand fetchBrand(int brandNum) {  // ir buscar a lista que foi dada ao utilizador e ir buscar o msm numero
        Brand brand = new Brand(1, "prov", "prov");
        return brand;
    }

    private Barcode createBarcode() {
        Barcode barcode = new Barcode("Code128");
        return barcode;
    }

    public String findCategories() {
        CategoryRepository categoryRepository;
        return "";
    }
}
