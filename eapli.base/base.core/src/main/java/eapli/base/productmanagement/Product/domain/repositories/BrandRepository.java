package eapli.base.productmanagement.Product.domain.repositories;

import eapli.base.productmanagement.Product.domain.Brand;
import eapli.framework.domain.repositories.DomainRepository;

import java.util.Optional;

public interface BrandRepository extends DomainRepository<Integer, Brand> {

    Optional<Brand> findByVat(int vat);
}
