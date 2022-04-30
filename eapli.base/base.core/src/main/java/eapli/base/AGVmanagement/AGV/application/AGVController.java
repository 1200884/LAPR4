package eapli.base.AGVmanagement.AGV.application;

import eapli.base.AGVmanagement.AGV.domain.AGV;
import eapli.base.AGVmanagement.AGV.domain.Model;
import eapli.base.AGVmanagement.AGV.domain.repository.ModelRepository;

import java.util.List;

public class AGVController {

    private static ModelRepository modelRepository;

    private static final AGVService agvService = new AGVService();

    private static List<Model> modelList;

    public String createAVG(double maxWeight, String baseLocation, String shortDescription, int modelID) {
        Model model = fetchModel(modelID);
        AGV agv = agvService.createAGV(maxWeight, baseLocation, shortDescription, modelID, model);
        return agv.toString();
    }

    private Model fetchModel(int modelNum) {
        return modelList.get(modelNum);
    }

    public String findModels() {
        Iterable<Model> iterable = modelRepository.findAll();
        iterable.forEach(modelList::add);
        StringBuilder string = new StringBuilder();
        for (int i = 0; i < modelList.size(); i++) {
            string.append(i).append(":\n").append(modelList.get(i).toString());
        }
        return string.toString();
    }
}
