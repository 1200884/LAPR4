package eapli.base.app.backoffice.console.Persistence;

import eapli.base.app.backoffice.console.Domain.Customer.Customer;
import eapli.base.app.backoffice.console.Domain.Customer.Customer;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class CustomerPersist {
    public void createcustomerpersist(Customer customer){
        EntityManagerFactory entityManagerFactory= Persistence.createEntityManagerFactory("default");
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        entityManager.getTransaction().begin();
        entityManager.persist(customer);
        entityManager.getTransaction().commit();
        entityManager.close();
        entityManagerFactory.close();
    }
}