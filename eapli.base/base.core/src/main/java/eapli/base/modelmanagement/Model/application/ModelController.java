package eapli.base.modelmanagement.Model.application;

import eapli.base.modelmanagement.Model.domain.Model;

public class ModelController {

    private static final ModelService modelService = new ModelService();

    public String createModel(String name, String description) {
        Model model = modelService.createModel(name, description);
        return model.toString();
    }
}
