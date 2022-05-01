package eapli.base.infrastructure.bootstrapers;

import eapli.base.brandmanagement.application.BrandService;
import eapli.base.brandmanagement.domain.Brand;
import eapli.base.categorymanagement.application.CategoryService;
import eapli.base.categorymanagement.domain.Category;
import eapli.base.productmanagement.Product.application.ProductService;
import eapli.base.productmanagement.Product.domain.Barcode;
import eapli.base.productmanagement.Product.domain.Description;
import eapli.base.productmanagement.Product.domain.Product;
import eapli.framework.domain.repositories.ConcurrencyException;
import eapli.framework.domain.repositories.IntegrityViolationException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class ProductBootstrapperBase {

    private static final Logger LOGGER = LoggerFactory.getLogger(ProductBootstrapperBase.class);

    final CategoryService categoryService = new CategoryService();
    final BrandService brandService = new BrandService();
    final ProductService productService = new ProductService();

    protected ProductBootstrapperBase() {
        super();
    }

    protected Category registerCategory(final String description) {
        Category category = null;
        try {
            category = categoryService.createnewcategory(description);
        }catch (final IntegrityViolationException | ConcurrencyException e) {
            category = null;
        }
        return category;
    }

    protected Brand registerBrand(final String name, final String reference) {
        Brand brand = null;
        try {
            brand = brandService.createBrand(name, reference);
        }catch (final IntegrityViolationException | ConcurrencyException e) {
            brand = null;
        }
        return brand;
    }

    protected Product registerProduct(final String name, final byte[] photo, final double basePrice, final Description description, final Category category, final Barcode barcode, final Brand brand) {
        Product product = null;
        try {
            product = productService.createProduct(name, photo, basePrice, description, category, barcode, brand);
        }catch (final IntegrityViolationException | ConcurrencyException e) {
            product = null;
        }
        return product;
    }
}
