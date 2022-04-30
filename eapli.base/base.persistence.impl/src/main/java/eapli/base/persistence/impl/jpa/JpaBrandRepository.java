package eapli.base.persistence.impl.jpa;

import eapli.base.Application;
import eapli.base.brandmanagement.domain.Brand;
import eapli.base.brandmanagement.domain.repository.BrandRepository;
import eapli.framework.domain.repositories.TransactionalContext;
import eapli.framework.infrastructure.repositories.impl.jpa.JpaAutoTxRepository;

public class JpaBrandRepository extends JpaAutoTxRepository<Brand, Integer, Integer> implements BrandRepository {

    public JpaBrandRepository(final TransactionalContext autoTx) {
        super(autoTx, "brand_id");
    }

    public JpaBrandRepository(final String puname) {
        super(puname, Application.settings().getExtendedPersistenceProperties(), "brand_id");
    }
}
