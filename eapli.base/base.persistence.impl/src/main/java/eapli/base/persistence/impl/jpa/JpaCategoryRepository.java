package eapli.base.persistence.impl.jpa;

import eapli.base.Application;
import eapli.base.categorymanagement.domain.Category;
import eapli.base.categorymanagement.domain.repositories.CategoryRepository;
import eapli.framework.domain.repositories.TransactionalContext;
import eapli.framework.infrastructure.repositories.impl.jpa.JpaAutoTxRepository;

import java.util.Optional;

public class JpaCategoryRepository extends JpaAutoTxRepository<Category, Integer, Integer> implements CategoryRepository {
    public JpaCategoryRepository(final TransactionalContext autoTx) {
        super(autoTx, "category_id");
    }

    public JpaCategoryRepository(final String puname) {
        super(puname, Application.settings().getExtendedPersistenceProperties(), "category_id");
    }

}
