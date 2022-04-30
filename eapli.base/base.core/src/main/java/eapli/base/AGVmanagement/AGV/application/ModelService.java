package eapli.base.AGVmanagement.AGV.application;

import eapli.base.AGVmanagement.AGV.domain.Model;
import eapli.base.AGVmanagement.AGV.domain.repository.ModelPersist;

public class ModelService {

    private static final ModelPersist modelPersist = new ModelPersist();

    public Model createModel(String name, String description) {
        Model model = new Model(name, description);
        modelPersist.createModelPersist(model);
        return model;
    }
}
