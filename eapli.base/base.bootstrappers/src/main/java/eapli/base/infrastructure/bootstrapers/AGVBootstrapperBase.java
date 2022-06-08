package eapli.base.infrastructure.bootstrapers;

import eapli.base.AGVmanagement.AGV.application.AGVService;
import eapli.base.AGVmanagement.AGV.domain.AGV;
import eapli.base.AGVmanagement.AGV.domain.Status;
import eapli.base.modelmanagement.Model.application.ModelService;
import eapli.base.modelmanagement.Model.domain.Model;
import eapli.base.warehousemanagement.Domain.AGVDocks;
import eapli.base.warehousemanagement.Domain.Aisle;
import eapli.base.warehousemanagement.Domain.Warehouse;
import eapli.base.warehousemanagement.application.CreateWarehouseService;
import eapli.framework.domain.repositories.ConcurrencyException;
import eapli.framework.domain.repositories.IntegrityViolationException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.HashSet;
import java.util.Set;

public class AGVBootstrapperBase {
    private static final Logger LOGGER = LoggerFactory.getLogger(AGVBootstrapperBase.class);

    final ModelService modelService = new ModelService();
    final AGVService agvService = new AGVService();
    final CreateWarehouseService warehouseService = new CreateWarehouseService();

    public AGVBootstrapperBase() {
        super();
    }

    protected Model registerModel(final String name, final String description) {
        Model model = null;
        try {
            model = modelService.createModel(name, description);
        }catch (final IntegrityViolationException | ConcurrencyException e) {
            model = null;
        }
        return model;
    }

    protected Warehouse registerWarehouse(final Long length, final Long width, final Long square, final String unit, final Set<Aisle> aisle, final Set<AGVDocks> docks) {
        Warehouse warehouse = null;
        try {
            warehouse = warehouseService.createWarehouse(length, width, square, unit, aisle, docks);
        }catch (final IntegrityViolationException | ConcurrencyException e) {
            warehouse = null;
        }
        return warehouse;
    }

    protected AGV registerAGV(final double maximum_weight,final String baseLocation, final String shortDescription, final Model model) {
        AGV agv = null;
        try {

            agv = agvService.createAGV(maximum_weight, baseLocation, shortDescription, model);

        }catch (final IntegrityViolationException | ConcurrencyException e) {
            agv = null;
        }
        return agv;
    }
}
