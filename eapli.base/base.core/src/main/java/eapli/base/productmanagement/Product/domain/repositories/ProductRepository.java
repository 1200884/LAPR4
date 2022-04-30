package eapli.base.productmanagement.Product.domain.repositories;

import eapli.base.productmanagement.Product.domain.Product;
import eapli.framework.domain.repositories.DomainRepository;

import java.util.Optional;

public interface ProductRepository extends DomainRepository<Integer, Product> {

    Optional<Product> findByVat(int vat);
}
