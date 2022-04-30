package eapli.base.AGVmanagement.AGV.domain.repository;

import eapli.base.AGVmanagement.AGV.domain.AGV;
import org.springframework.beans.factory.annotation.Autowired;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class AGVPersist {

    @Autowired
    private static AGVRepository agvRepository;

    public void createAGVPersist(AGV agv) {
        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("default");
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        entityManager.getTransaction().begin();
        entityManager.persist(agv);
        entityManager.getTransaction().commit();
        entityManager.close();
        entityManagerFactory.close();
        agvRepository.save(agv);
    }
}
