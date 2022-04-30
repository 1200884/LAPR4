package eapli.base.customermanagement.application;

import eapli.base.customermanagement.domain.model.Customer;
import eapli.base.customermanagement.domain.repositories.CustomerRepository;
import eapli.base.infrastructure.persistence.PersistenceContext;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.ArrayList;
import java.util.Optional;

public class CustomerPersist {
    @Autowired
    CustomerRepository customerRepository= PersistenceContext.repositories().customers();
    public void createcustomerpersist(Customer customer){
        System.out.println("15");
        /*EntityManagerFactory entityManagerFactory= Persistence.createEntityManagerFactory("default");
        System.out.println("17");
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        System.out.println("19");
        entityManager.getTransaction().begin();
        System.out.println("21");
        entityManager.persist(customer);
        System.out.println("23");
        entityManager.getTransaction().commit();
        System.out.println("25");
        entityManager.close();
        System.out.println("27");
        entityManagerFactory.close();*/
        customerRepository.save(customer);
    }
}