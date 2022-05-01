package eapli.base.productmanagement.Product.application;

import eapli.base.productmanagement.Product.domain.Barcode;
import eapli.base.brandmanagement.domain.Brand;
import eapli.base.categorymanagement.domain.Category;
import eapli.base.productmanagement.Product.domain.Product;
import eapli.base.productmanagement.Product.domain.repositories.ProductPersist;

public class ProductService {

    private static final ProductPersist productPersist = new ProductPersist();

    public Product createProduct(String name, byte[] photo, double basePrice, Category category, Barcode barcode, Brand brand) {
        Product product = new Product(name, photo, basePrice, category, barcode, brand);
        productPersist.createProductPersist(product);
        return product;
    }
}
