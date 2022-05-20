package eapli.base.productmanagement.Product.domain.repositories;

import eapli.base.brandmanagement.domain.Brand;
import eapli.base.brandmanagement.domain.repository.BrandRepository;
import eapli.base.categorymanagement.domain.Category;
import eapli.base.categorymanagement.domain.repositories.CategoryRepository;
import eapli.base.infrastructure.persistence.PersistenceContext;
import eapli.base.productmanagement.Product.domain.Product;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.ArrayList;

public class ProductPersist {

    @Autowired
    private static ProductRepository productRepository = PersistenceContext.repositories().products();

    @Autowired
    private static BrandRepository brandRepository = PersistenceContext.repositories().brands();

    @Autowired
    private static CategoryRepository categoryRepository = PersistenceContext.repositories().category();

    public Product createProductPersist(Product product) {
        Brand brand=null;
        for(Brand b : brandRepository.findAll()){
            if(b.getName().equals(product.getBrand().getName())){
                brand = b;
            }
        }
        Category category = null;
        for(Category c : categoryRepository.findAll()){
            if(c.getDescription().equals(product.getCategory().getDescription())){
                category = c;
            }
        }
        product.setCategory(category);
        product.setBrand(brand);

        category.addProduct(product);
        brand.addProduct(product);

        productRepository.save(product);

        return ((ArrayList<Product>)productRepository.findAll()).get(((ArrayList<Product>)productRepository.findAll()).size()-1);
    }
}
