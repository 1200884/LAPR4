package eapli.base.productmanagement.Product.domain.repositories;

import eapli.base.infrastructure.persistence.PersistenceContext;
import eapli.base.productmanagement.Product.domain.Product;
import org.springframework.beans.factory.annotation.Autowired;

public class ProductPersist {

    @Autowired
    private static ProductRepository productRepository = PersistenceContext.repositories().products();

    public void createProductPersist(Product product) {
        productRepository.save(product);
    }
}
