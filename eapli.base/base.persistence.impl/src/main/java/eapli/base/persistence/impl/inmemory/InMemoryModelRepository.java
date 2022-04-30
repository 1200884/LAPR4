package eapli.base.persistence.impl.inmemory;

import eapli.base.modelmanagement.Model.domain.Model;
import eapli.base.modelmanagement.Model.domain.repositories.ModelRepository;
import eapli.framework.infrastructure.repositories.impl.inmemory.InMemoryDomainRepository;

public class InMemoryModelRepository extends InMemoryDomainRepository<Model, Integer> implements ModelRepository {
    static {
        InMemoryInitializer.init();
    }
}
