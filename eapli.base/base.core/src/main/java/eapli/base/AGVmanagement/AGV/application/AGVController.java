package eapli.base.AGVmanagement.AGV.application;

import eapli.base.AGVmanagement.AGV.domain.AGV;
import eapli.base.infrastructure.persistence.PersistenceContext;
import eapli.base.modelmanagement.Model.domain.Model;
import eapli.base.modelmanagement.Model.domain.repositories.ModelRepository;
import eapli.base.warehousemanagement.Domain.AGVDocks;
import eapli.base.warehousemanagement.Domain.Repositories.WarehouseRepository;
import eapli.base.warehousemanagement.Domain.Warehouse;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class AGVController {

    private static ModelRepository modelRepository = PersistenceContext.repositories().models();

    private static WarehouseRepository warehouseRepository = PersistenceContext.repositories().Warehouse();

    private static final AGVService agvService = new AGVService();

    private static List<Model> modelList = new ArrayList<>();

    private static List<Warehouse> warehouseList = new ArrayList<>();

    private static Set<AGVDocks> docks = new HashSet<>();

    public String createAVG(double maxWeight, int baseLocation, String shortDescription, int modelID) {
        Model model = fetchModel(modelID);
        AGVDocks agvDocks = fetchDocks(baseLocation);
        AGV agv = agvService.createAGV(maxWeight, agvDocks, shortDescription, model);
        return agv.toString();
    }

    private Model fetchModel(int modelNum) {
        for (Model model : modelList) {
            if (model.getId() == modelNum) return model;
        }
        return null;
    }

    public boolean verifyModel(int modelNum) {
        return fetchModel(modelNum) != null;
    }

    public String findModels() {
        Iterable<Model> iterable = modelRepository.findAll();
        modelList.clear();
        iterable.forEach(modelList::add);
        StringBuilder string = new StringBuilder();
        for (Model model : modelList) {
            string.append(model.toString()).append("\n");
        }
        return string.toString();
    }

    private Warehouse fetchWarehouse(int warehouseNum) {
        for (Warehouse warehouse : warehouseList) {
            if (warehouse.getId() == warehouseNum) return warehouse;
        }
        return null;
    }

    public boolean verifyWarehouse(int warehouseNum) {
        return fetchWarehouse(warehouseNum) != null;
    }

    public String findWarehouses() {
        Iterable<Warehouse> iterable = warehouseRepository.findAll();
        warehouseList.clear();
        iterable.forEach(warehouseList::add);
        StringBuilder string = new StringBuilder();
        for (Warehouse warehouse : warehouseList) {
            string.append(warehouse.toString()).append("\n");
        }
        return string.toString();
    }

    private AGVDocks fetchDocks(int dockNum) {
        for (AGVDocks agvDocks : docks) {
            if (agvDocks.getId() == dockNum) return agvDocks;
        }
        return null;
    }

    public boolean verifyDock(int dockNum) {
        return fetchDocks(dockNum) != null;
    }

    public String findDocks(int warehouseNum) {
        Warehouse warehouse = fetchWarehouse(warehouseNum);
        docks.clear();
        docks = warehouse.getDocks();
        StringBuilder string = new StringBuilder();
        for (AGVDocks dock : docks) {
            string.append(dock.toString()).append("\n");
        }
        return string.toString();
    }
}
