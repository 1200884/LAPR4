package eapli.base.modelmanagement.Model.application;

import eapli.base.modelmanagement.Model.domain.Model;
import eapli.base.modelmanagement.Model.domain.repositories.ModelPersist;

public class ModelService {

    private static final ModelPersist modelPersist = new ModelPersist();

    public Model createModel(String name, String description) {
        Model model = new Model(name, description);
        modelPersist.createModelPersist(model);
        return model;
    }
}
