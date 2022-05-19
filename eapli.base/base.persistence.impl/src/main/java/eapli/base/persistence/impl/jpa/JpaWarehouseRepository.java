package eapli.base.persistence.impl.jpa;

import eapli.base.Application;
import eapli.base.customermanagement.domain.model.Customer;
import eapli.base.warehousemanagement.Domain.Repositories.WarehouseRepository;
import eapli.base.warehousemanagement.Domain.Warehouse;
import eapli.framework.domain.repositories.TransactionalContext;
import eapli.framework.infrastructure.repositories.impl.jpa.JpaAutoTxRepository;

public class JpaWarehouseRepository extends JpaAutoTxRepository<Warehouse,Long,Long> implements WarehouseRepository {

    public JpaWarehouseRepository(final TransactionalContext autoTx) {
        super(autoTx, "id");
    }

    public JpaWarehouseRepository(final String puname) {
        super(puname, Application.settings().getExtendedPersistenceProperties(),
                "id");
    }
}
