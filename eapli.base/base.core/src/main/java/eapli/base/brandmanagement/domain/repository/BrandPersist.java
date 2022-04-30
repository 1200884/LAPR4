package eapli.base.brandmanagement.domain.repository;

import eapli.base.brandmanagement.domain.Brand;
import eapli.base.infrastructure.persistence.PersistenceContext;
import org.springframework.beans.factory.annotation.Autowired;

public class BrandPersist {

    @Autowired
    private static BrandRepository brandRepository = PersistenceContext.repositories().brands();

    public void createBrandPersist(Brand brand) {
        brandRepository.save(brand);
    }
}
