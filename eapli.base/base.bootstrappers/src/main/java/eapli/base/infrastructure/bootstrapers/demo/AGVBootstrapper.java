package eapli.base.infrastructure.bootstrapers.demo;

import eapli.base.AGVmanagement.AGV.domain.AGV;
import eapli.base.infrastructure.bootstrapers.AGVBootstrapperBase;
import eapli.base.modelmanagement.Model.domain.Model;
import eapli.base.warehousemanagement.Domain.AGVDocks;
import eapli.base.warehousemanagement.Domain.Aisle;
import eapli.base.warehousemanagement.Domain.Warehouse;
import eapli.framework.actions.Action;

import java.util.HashSet;
import java.util.Set;

public class AGVBootstrapper extends AGVBootstrapperBase implements Action {
    @Override
    public boolean execute() {
        Model model = createModel("BOT-AGV", "The best AGVs in the west");
        Set<Aisle> aisleSet = new HashSet<>();
        AGVDocks agvDocks = new AGVDocks(10L, 10L, 10L, 10L, 10L, 10L, 10L, "Acess");
        Set<AGVDocks> agvDocksSet = new HashSet<>();
        agvDocksSet.add(agvDocks);
        Warehouse warehouse = createWarehouse(10L, 10L, 10L, "2", aisleSet, agvDocksSet);
        AGV agv = createAGV(60, warehouse.getDocks().iterator().next(), "Fast and good AGV", model);
        return true;
    }

    private Model createModel(final String name, final String description) {
        return registerModel(name, description);
    }

    private Warehouse createWarehouse(Long length, Long width, Long square, String unit, Set<Aisle> aisle, Set<AGVDocks> docks) {
        return registerWarehouse(length, width, square, unit, aisle, docks);
    }

    private AGV createAGV(final double maxWeight, final AGVDocks baseLocation, final String shortDescription, final Model model) {
        return registerAGV(maxWeight, baseLocation, shortDescription, model);
    }
}
