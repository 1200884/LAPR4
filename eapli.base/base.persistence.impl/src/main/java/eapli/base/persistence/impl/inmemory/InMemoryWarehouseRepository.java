package eapli.base.persistence.impl.inmemory;

import eapli.base.customermanagement.domain.model.Customer;
import eapli.base.warehousemanagement.Domain.Repositories.WarehouseRepository;
import eapli.base.warehousemanagement.Domain.Warehouse;
import eapli.framework.infrastructure.repositories.impl.inmemory.InMemoryDomainRepository;

public class InMemoryWarehouseRepository extends InMemoryDomainRepository<Warehouse, Long> implements WarehouseRepository {
    static {
        InMemoryInitializer.init();
    }
}
