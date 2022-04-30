package eapli.base.productmanagement.Product.application;

import eapli.base.productmanagement.Product.domain.Brand;

public class BrandController {

    private static final BrandService brandService = new BrandService();

    public String createBrand(String name, String reference) {
        Brand brand = brandService.createBrand(name, reference);
        return brand.toString();
    }
}
