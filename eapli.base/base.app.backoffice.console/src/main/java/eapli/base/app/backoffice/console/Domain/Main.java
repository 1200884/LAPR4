package eapli.base.app.backoffice.console.Domain;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
    }


    private static void bootstrap() {
        User employee1 = new User();
        employee1.setId("Sales clerk");
        employee1.setPassword("sc");

        User employee2 = new User();
        employee2.setId("Project Manager");
        employee2.setPassword("pm");

        User employee3 = new User();
        employee3.setId("Warehouse employee");
        employee3.setPassword("we");

        User employee4 = new User();
        employee4.setId("Software Product Client");
        employee4.setPassword("spc");


        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("default");
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        entityManager.getTransaction().begin();
        entityManager.persist(employee1);
        entityManager.persist(employee2);
        entityManager.persist(employee3);
        entityManager.persist(employee4);
        entityManager.getTransaction().commit();
        entityManager.close();
        entityManagerFactory.close();
    }
}