package eapli.base.persistence.impl.jpa;

import eapli.base.Application;
import eapli.base.brandmanagement.domain.Brand;
import eapli.base.productmanagement.Product.domain.Category;
import eapli.base.productmanagement.Product.domain.Product;
import eapli.base.productmanagement.Product.domain.repositories.ProductRepository;
import eapli.framework.domain.repositories.TransactionalContext;
import eapli.framework.infrastructure.repositories.impl.jpa.JpaAutoTxRepository;

import javax.persistence.TypedQuery;

public class JpaProductRepository extends JpaAutoTxRepository<Product, Integer, Integer> implements ProductRepository {

    public JpaProductRepository(final TransactionalContext autoTx) {
        super(autoTx, "id");
    }

    public JpaProductRepository(final String puname) {
        super(puname, Application.settings().getExtendedPersistenceProperties(), "id");
    }

    @Override
    public Iterable<Product> findByCategory(Category c) {
        final TypedQuery<Product> query = entityManager().createQuery(
                "SELECT p1 FROM Product p1 WHERE p1.category = :c", Product.class);
        query.setParameter("c", c);
        return query.getResultList();
    }

    @Override
    public Iterable<Product> findByBrand(Brand b) {
        final TypedQuery<Product> query = entityManager().createQuery(
                "SELECT p1 FROM Product p1 WHERE p1.brand = :b", Product.class);
        query.setParameter("b", b);
        return query.getResultList();
    }
}
