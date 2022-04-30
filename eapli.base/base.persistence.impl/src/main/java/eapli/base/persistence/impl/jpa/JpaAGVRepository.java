package eapli.base.persistence.impl.jpa;

import eapli.base.AGVmanagement.AGV.domain.AGV;
import eapli.base.AGVmanagement.AGV.domain.repository.AGVRepository;
import eapli.base.Application;
import eapli.framework.domain.repositories.TransactionalContext;
import eapli.framework.infrastructure.repositories.impl.jpa.JpaAutoTxRepository;

public class JpaAGVRepository extends JpaAutoTxRepository<AGV, Integer, Integer> implements AGVRepository {

    public JpaAGVRepository(final TransactionalContext autoTx) {
        super(autoTx, "id");
    }

    public JpaAGVRepository(final String puname) {
        super(puname, Application.settings().getExtendedPersistenceProperties(), "id");
    }
}
