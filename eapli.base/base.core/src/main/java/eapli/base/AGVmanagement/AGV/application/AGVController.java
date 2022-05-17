package eapli.base.AGVmanagement.AGV.application;

import eapli.base.AGVmanagement.AGV.domain.AGV;
import eapli.base.infrastructure.persistence.PersistenceContext;
import eapli.base.modelmanagement.Model.domain.Model;
import eapli.base.modelmanagement.Model.domain.repositories.ModelRepository;

import java.util.ArrayList;
import java.util.List;

public class AGVController {

    private static ModelRepository modelRepository = PersistenceContext.repositories().models();

    private static final AGVService agvService = new AGVService();

    private static List<Model> modelList = new ArrayList<>();

    public String createAVG(double maxWeight, String baseLocation, String shortDescription, int modelID) {
        Model model = fetchModel(modelID);
        AGV agv = agvService.createAGV(maxWeight, baseLocation, shortDescription, model);
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
}
