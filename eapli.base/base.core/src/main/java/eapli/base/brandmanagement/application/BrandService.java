package eapli.base.brandmanagement.application;

import eapli.base.brandmanagement.domain.Brand;
import eapli.base.brandmanagement.domain.repository.BrandPersist;

public class BrandService {

    private static final BrandPersist brandPersist = new BrandPersist();

    public Brand createBrand(String name, String reference) {
        Brand brand = new Brand(name, reference);
        brandPersist.createBrandPersist(brand);
        return brand;
    }
}
