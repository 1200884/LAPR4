package eapli.base.persistence.impl.inmemory;

import eapli.base.AGVmanagement.AGV.domain.AGV;
import eapli.base.AGVmanagement.AGV.domain.repository.AGVRepository;
import eapli.framework.infrastructure.repositories.impl.inmemory.InMemoryDomainRepository;

public class InMemoryAGVRepository extends InMemoryDomainRepository<AGV, Integer> implements AGVRepository {
    static {
        InMemoryInitializer.init();
    }
}
