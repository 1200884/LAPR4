package eapli.base.productmanagement.Product.repositories;

import eapli.base.productmanagement.Product.domain.Category;
import eapli.framework.domain.repositories.DomainRepository;

import java.util.Optional;

public interface CategoryRepository extends DomainRepository<Integer, Category> {

    Optional<Category> findCategory(Category category);
}
