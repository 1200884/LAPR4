package eapli.base.productmanagement.Product.domain.repositories;

import eapli.base.productmanagement.Product.domain.Product;
import org.springframework.beans.factory.annotation.Autowired;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class ProductPersist {

    @Autowired
    private static ProductRepository productRepository;

    public void createProductPersist(Product product) {
        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("default");
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        entityManager.getTransaction().begin();
        entityManager.persist(product);
        entityManager.getTransaction().commit();
        entityManager.close();
        entityManagerFactory.close();
        productRepository.save(product);
    }
}
