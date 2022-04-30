package eapli.base.productmanagement.Product.domain.repositories;

import eapli.base.brandmanagement.domain.Brand;
import eapli.base.productmanagement.Product.domain.Category;
import eapli.base.productmanagement.Product.domain.Product;
import eapli.base.usermanagement.domain.BaseRoles;
import eapli.framework.domain.repositories.DomainRepository;

public interface ProductRepository extends DomainRepository<Integer, Product> {
    Iterable<Product> findByCategory(Category c);
    Iterable<Product> findByBrand(Brand b);

}
