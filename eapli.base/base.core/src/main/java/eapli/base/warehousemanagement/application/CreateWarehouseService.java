package eapli.base.warehousemanagement.application;

import eapli.base.infrastructure.persistence.PersistenceContext;
import eapli.base.warehousemanagement.Domain.AGVDocks;
import eapli.base.warehousemanagement.Domain.Aisle;
import eapli.base.warehousemanagement.Domain.Repositories.WarehouseRepository;
import eapli.base.warehousemanagement.Domain.Warehouse;

import java.util.Set;

public class CreateWarehouseService {

    WarehouseRepository repository = PersistenceContext.repositories().Warehouse();

    public void createWarehouse(Long length, Long width, Long square, String unit, Set<Aisle> aisle, Set<AGVDocks> docks) {
        Warehouse warehouse = new Warehouse(length,width,square,unit);
        warehouse.setAisle(aisle);
        warehouse.setDocks(docks);
        repository.save(warehouse);
        System.out.println(repository.findAll());
    }
}
