package eapli.base.persistence.impl.jpa;

import eapli.base.Application;
import eapli.base.productmanagement.Product.domain.Product;
import eapli.base.productmanagement.Product.domain.repositories.ProductRepository;
import eapli.framework.domain.repositories.TransactionalContext;
import eapli.framework.infrastructure.repositories.impl.jpa.JpaAutoTxRepository;

public class JpaProductRepository extends JpaAutoTxRepository<Product, Integer, Integer> implements ProductRepository {

    public JpaProductRepository(final TransactionalContext autoTx) {
        super(autoTx, "id");
    }

    public JpaProductRepository(final String puname) {
        super(puname, Application.settings().getExtendedPersistenceProperties(), "id");
    }
}
