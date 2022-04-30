package eapli.base.AGVmanagement.AGV.domain.repository;

import eapli.base.AGVmanagement.AGV.domain.Model;
import org.springframework.beans.factory.annotation.Autowired;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class ModelPersist {

    @Autowired
    private static ModelRepository modelRepository;

    public void createModelPersist(Model model) {
        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("default");
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        entityManager.getTransaction().begin();
        entityManager.persist(model);
        entityManager.getTransaction().commit();
        entityManager.close();
        entityManagerFactory.close();
        modelRepository.save(model);
    }
}
