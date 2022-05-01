package eapli.base.infrastructure.bootstrapers.demo;

import eapli.base.brandmanagement.domain.Brand;
import eapli.base.categorymanagement.domain.Category;
import eapli.base.infrastructure.bootstrapers.ProductBootstrapperBase;
import eapli.base.productmanagement.Product.domain.Barcode;
import eapli.base.productmanagement.Product.domain.Description;
import eapli.base.productmanagement.Product.domain.Product;
import eapli.framework.actions.Action;

public class ProductBootstrapper extends ProductBootstrapperBase implements Action {

    @Override
    public boolean execute() {
        Brand brand = createBrand("Pink Lady", "123");
        System.out.println("Brand criada");
        Category category = createCategory("Fruta");
        System.out.println("Categoria criada");
        registerProduct("Maçã", new byte[1], 15, new Description("Boa", "Muito boa"), category, new Barcode("Code123"), brand);
        System.out.println("Produto criado");
        return true;
    }

    private Category createCategory(final String description) {
        return registerCategory(description);
    }

    private Brand createBrand(final String name, final String reference) {
        return registerBrand(name, reference);
    }

    private Product createProduct(final String name, final byte[] photo, final double basePrice, final Description description, final Category category, final Barcode barcode, final Brand brand) {
        return registerProduct(name, photo, basePrice, description, category, barcode, brand);
    }
}
