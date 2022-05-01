package eapli.base.productmanagement.Product.application.listproducts;

import eapli.base.brandmanagement.domain.Brand;
import eapli.base.brandmanagement.domain.repository.BrandRepository;
import eapli.base.infrastructure.persistence.PersistenceContext;
import eapli.base.productmanagement.Product.domain.Barcode;
import eapli.base.productmanagement.Product.domain.Category;
import eapli.base.productmanagement.Product.domain.Product;
import eapli.base.productmanagement.Product.domain.repositories.CategoryRepository;
import eapli.base.productmanagement.Product.domain.repositories.ProductRepository;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class ListProductService {
    ProductRepository productRepository = PersistenceContext.repositories().products();
    CategoryRepository categoryRepository;
    BrandRepository brandRepository = PersistenceContext.repositories().brands();

    public StringBuilder allProducts(String f1) {
        Brand brand1 = new Brand("Nike","niky");
        Brand brand2 = new Brand("Adidas","adidi");
        Category category1 = new Category("Sapatilhas");
        Product product1 = new Product("Air Max",new byte[3],99,category1,new Barcode("123"),brand1);
        Product product2 = new Product("Sweater",new byte[3],99,category1,new Barcode("1234"),brand2);
        brandRepository.save(brand1);
        brandRepository.save(brand2);
        System.out.println("11111111111111111111111111111");
        categoryRepository.save(category1);
        System.out.println("22222222222222222222222222222222");
        productRepository.save(product1);
        productRepository.save(product2);
        StringBuilder stringBuilder = new StringBuilder();
        if(f1.equals("brand")){
            ArrayList<Brand> brandList = (ArrayList<Brand>) brandRepository.findAll();
            Collections.sort(brandList, new Comparator<Brand>() {
                @Override
                public int compare(final Brand object1, final Brand object2) {
                    return object1.getName().compareTo(object2.getName());
                }
            });
            for(Brand b : brandList) {
                stringBuilder.append("->" + b.getName() + ":\n" );
                stringBuilder.append(productRepository.findByBrand(b));
            }

        }else {
            ArrayList<Category> categoryList = (ArrayList<Category>) categoryRepository.findAll();
            Collections.sort(categoryList, new Comparator<Category>() {
                @Override
                public int compare(final Category o1, final Category o2) {
                    return o1.getDescription().compareTo(o2.getDescription());
                }
            });
            for(Category c : categoryList) {
                stringBuilder.append("->" + c.getDescription() + ":\n" );
                stringBuilder.append(productRepository.findByCategory(c));
            }
        }
        return stringBuilder;

    }
}
