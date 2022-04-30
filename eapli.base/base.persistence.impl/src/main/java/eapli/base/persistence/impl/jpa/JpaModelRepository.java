package eapli.base.persistence.impl.jpa;

import eapli.base.Application;
import eapli.base.modelmanagement.Model.domain.Model;
import eapli.base.modelmanagement.Model.domain.repositories.ModelRepository;
import eapli.framework.domain.repositories.TransactionalContext;
import eapli.framework.infrastructure.repositories.impl.jpa.JpaAutoTxRepository;

public class JpaModelRepository extends JpaAutoTxRepository<Model, Integer, Integer> implements ModelRepository {

    public JpaModelRepository(final TransactionalContext autoTx) {
        super(autoTx, "id");
    }

    public JpaModelRepository(final String puname) {
        super(puname, Application.settings().getExtendedPersistenceProperties(), "id");
    }
}
