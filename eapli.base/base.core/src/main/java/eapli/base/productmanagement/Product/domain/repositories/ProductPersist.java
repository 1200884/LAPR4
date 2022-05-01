package eapli.base.productmanagement.Product.domain.repositories;

import eapli.base.brandmanagement.domain.Brand;
import eapli.base.brandmanagement.domain.repository.BrandRepository;
import eapli.base.categorymanagement.domain.Category;
import eapli.base.categorymanagement.domain.repositories.CategoryRepository;
import eapli.base.customermanagement.domain.repositories.CustomerRepository;
import eapli.base.infrastructure.persistence.PersistenceContext;
import eapli.base.productmanagement.Product.domain.Product;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.ArrayList;

public class ProductPersist {

    @Autowired
    private static ProductRepository productRepository = PersistenceContext.repositories().products();

    @Autowired
    private static BrandRepository brandRepository = PersistenceContext.repositories().brands();

    @Autowired
    private static CategoryRepository categoryRepository = PersistenceContext.repositories().category();

    public void createProductPersist(Product product) {
        Brand brand = ((ArrayList<Brand>)brandRepository.findAll()).get(0);
        Category category = ((ArrayList<Category>)categoryRepository.findAll()).get(0);

        product.setCategory(category);
        product.setBrand(brand);

        category.addProduct(product);
        brand.addProduct(product);

        productRepository.save(product);
    }
}
