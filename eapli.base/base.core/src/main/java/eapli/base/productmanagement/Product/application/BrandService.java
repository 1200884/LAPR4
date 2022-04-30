package eapli.base.productmanagement.Product.application;

import eapli.base.productmanagement.Product.domain.Brand;
import eapli.base.productmanagement.Product.domain.repositories.BrandPersist;

public class BrandService {

    private static final BrandPersist brandPersist = new BrandPersist();

    public Brand createBrand(String name, String reference) {
        Brand brand = new Brand(name, reference);
        brandPersist.createBrandPersist(brand);
        return brand;
    }
}
