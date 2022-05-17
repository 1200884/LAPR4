package eapli.base.productmanagement.Product.application;

import eapli.base.infrastructure.persistence.PersistenceContext;
import eapli.base.modelmanagement.Model.domain.Model;
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
        return product.toStringShow();
    }

    private Category fetchCategory(int categoryNum) {
        for (Category category : categoryList) {
            if (category.getCategory_ID() == categoryNum) return category;
        }
        return null;
    }

    public boolean verifyCategory(int categoryNum) {
        return fetchCategory(categoryNum) != null;
    }

    private Brand fetchBrand(int brandNum) {
        for (Brand brand : brandList) {
            if (brand.getBrand_id() == brandNum) return brand;
        }
        return null;
    }

    public boolean verifyBrand(int brandNum) {
        return fetchBrand(brandNum) != null;
    }

    private Barcode createBarcode() {
        return new Barcode("Code128");
    }

    public String findCategories() {
        Iterable<Category> iterable = categoryRepository.findAll();
        categoryList.clear();
        iterable.forEach(categoryList::add);
        StringBuilder string = new StringBuilder();
        for (Category category : categoryList) {
            string.append(category.toString()).append("\n");
        }
        return string.toString();
    }

    public String findBrand() {
        Iterable<Brand> iterable = brandRepository.findAll();
        brandList.clear();
        iterable.forEach(brandList::add);
        StringBuilder string = new StringBuilder();
        for (Brand brand : brandList) {
            string.append(brand.toString()).append("\n");
        }
        return string.toString();
    }
}
