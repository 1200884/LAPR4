package eapli.base.AGVmanagement.AGV.application;

import eapli.base.AGVmanagement.AGV.domain.Model;

public class ModelController {

    private static final ModelService modelService = new ModelService();

    public String createModel(String name, String description) {
        Model model = modelService.createModel(name, description);
        return model.toString();
    }
}
