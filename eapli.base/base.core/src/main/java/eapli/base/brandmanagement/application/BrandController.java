package eapli.base.brandmanagement.application;

import eapli.base.brandmanagement.domain.Brand;

public class BrandController {

    private static final BrandService brandService = new BrandService();

    public String createBrand(String name, String reference) {
        Brand brand = brandService.createBrand(name, reference);
        return brand.toString();
    }
}
