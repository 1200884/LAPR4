package eapli.base.persistence.impl.inmemory;

import eapli.base.brandmanagement.domain.Brand;
import eapli.base.brandmanagement.domain.repository.BrandRepository;
import eapli.framework.infrastructure.repositories.impl.inmemory.InMemoryDomainRepository;

public class InMemoryBrandRepository extends InMemoryDomainRepository<Brand, Integer> implements BrandRepository {
    static {
        InMemoryInitializer.init();
    }
}
