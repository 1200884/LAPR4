package eapli.base.persistence.impl.inmemory;

import eapli.base.brandmanagement.domain.Brand;
import eapli.base.categorymanagement.domain.Category;
import eapli.base.productmanagement.Product.domain.Product;
import eapli.base.productmanagement.Product.domain.repositories.ProductRepository;
import eapli.framework.infrastructure.repositories.impl.inmemory.InMemoryDomainRepository;

import java.util.ArrayList;

public class InMemoryProductRepository extends InMemoryDomainRepository<Product, Integer> implements ProductRepository {
    static {
        InMemoryInitializer.init();
    }

    @Override
    public Iterable<Product> findByCategory(Category c) {
        ArrayList<Product> al = new ArrayList<>();
        for(Product p : findAll()){
            if (p.getCategory().equals(c)){
                al.add(p);
            }
        }
        return al;
    }

    @Override
    public Iterable<Product> findByBrand(Brand b) {
        ArrayList<Product> al2 = new ArrayList<>();
        for(Product p : findAll()){
            if (p.getBrand().equals(b)){
                al2.add(p);
            }
        }
        return al2;
    }
}
