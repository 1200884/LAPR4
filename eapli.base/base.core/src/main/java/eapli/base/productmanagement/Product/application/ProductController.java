package eapli.base.productmanagement.Product.application;

import eapli.base.infrastructure.persistence.PersistenceContext;
import eapli.base.productmanagement.Product.domain.Barcode;
import eapli.base.brandmanagement.domain.Brand;
import eapli.base.categorymanagement.domain.Category;
import eapli.base.productmanagement.Product.domain.Description;
import eapli.base.productmanagement.Product.domain.Product;
import eapli.base.brandmanagement.domain.repository.BrandRepository;
import eapli.base.categorymanagement.domain.repositories.CategoryRepository;

import java.util.ArrayList;
import java.util.List;

public class ProductController {

    private static CategoryRepository categoryRepository = PersistenceContext.repositories().category();
    private static BrandRepository brandRepository = PersistenceContext.repositories().brands();

    private static final ProductService productService = new ProductService();

    private static List<Category> categoryList = new ArrayList<>();
    private static List<Brand> brandList = new ArrayList<>();

    public String createProduct(String name, byte[] photo, double basePrice, String shortDescription, String longDescription, int categoryNum, int brandNum) {
        Description description = new Description(shortDescription, longDescription);
        Category category = fetchCategory(categoryNum);
        Barcode barcode = createBarcode();
        Brand brand = fetchBrand(brandNum);
        Product product = productService.createProduct(name, photo, basePrice, description, category, barcode, brand);
        return product.toString();
    }

    private Category fetchCategory(int categoryNum) {
        return categoryList.get(categoryNum);
    }

    private Brand fetchBrand(int brandNum) {
        return brandList.get(brandNum);
    }

    private Barcode createBarcode() {
        return new Barcode("Code128");
    }

    public String findCategories() {
        Iterable<Category> iterable = categoryRepository.findAll();
        iterable.forEach(categoryList::add);
        StringBuilder string = new StringBuilder();
        for (int i = 0; i < categoryList.size(); i++) {
            string.append(i).append(":\n").append(categoryList.get(i).toString());
        }
        return string.toString();
    }

    public String findBrand() {
        Iterable<Brand> iterable = brandRepository.findAll();
        iterable.forEach(brandList::add);
        StringBuilder string = new StringBuilder();
        for (int i = 0; i < brandList.size(); i++) {
            string.append(i).append(":\n").append(brandList.get(i).toString());
        }
        return string.toString();
    }
}
