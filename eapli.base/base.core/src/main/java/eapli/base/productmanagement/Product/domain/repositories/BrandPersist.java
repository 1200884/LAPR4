package eapli.base.productmanagement.Product.domain.repositories;

import eapli.base.productmanagement.Product.domain.Brand;
import org.springframework.beans.factory.annotation.Autowired;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class BrandPersist {

    @Autowired
    private static BrandRepository brandRepository;
    public void createBrandPersist(Brand brand) {
        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("default");
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        entityManager.getTransaction().begin();
        entityManager.persist(brand);
        entityManager.getTransaction().commit();
        entityManager.close();
        entityManagerFactory.close();
        brandRepository.save(brand);
    }
}
