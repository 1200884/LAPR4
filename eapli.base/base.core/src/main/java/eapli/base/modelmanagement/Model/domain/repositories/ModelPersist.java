package eapli.base.modelmanagement.Model.domain.repositories;

import eapli.base.infrastructure.persistence.PersistenceContext;
import eapli.base.modelmanagement.Model.domain.Model;
import org.springframework.beans.factory.annotation.Autowired;

public class ModelPersist {

    @Autowired
    private static ModelRepository modelRepository = PersistenceContext.repositories().Models();

    public void createModelPersist(Model model) {
        modelRepository.save(model);
    }
}
