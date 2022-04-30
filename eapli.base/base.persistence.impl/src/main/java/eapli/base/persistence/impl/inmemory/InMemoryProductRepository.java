package eapli.base.persistence.impl.inmemory;

import eapli.base.productmanagement.Product.domain.Product;
import eapli.base.productmanagement.Product.domain.repositories.ProductRepository;
import eapli.framework.infrastructure.repositories.impl.inmemory.InMemoryDomainRepository;

public class InMemoryProductRepository extends InMemoryDomainRepository<Product, Integer> implements ProductRepository {
    static {
        InMemoryInitializer.init();
    }
}
