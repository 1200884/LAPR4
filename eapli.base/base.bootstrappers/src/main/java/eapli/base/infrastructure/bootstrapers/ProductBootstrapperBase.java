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
        try {
            Category category = categoryService.createnewcategory(description);
            return category;
        }catch (final IntegrityViolationException | ConcurrencyException e) {
            return null;
        }
    }

    protected Brand registerBrand(final String name, final String reference) {
        try {
            Brand brand = brandService.createBrand(name, reference);
            return brand;
        }catch (final IntegrityViolationException | ConcurrencyException e) {
            return null;
        }
    }

    protected Product registerProduct(final String name, final byte[] photo, final double basePrice, final Description description, final Category category, final Barcode barcode, final Brand brand) {
        try {
            Product product = productService.createProduct(name, photo, basePrice, description, category, barcode, brand);
            return product;
        }catch (final IntegrityViolationException | ConcurrencyException e) {
            return null;
        }
    }
}
