package Domain;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        bootstrap();
        System.out.println("Welcome!\nPlease login with your credentials!\n Email -");
        String name = scanner.next();
        System.out.println("Password -");
        String password = scanner.next();
        while (!salesclerk(name, password) && !projectmanager(name, password) && !softwareproductclient(name, password) && !warehouseemployee(name, password)) {
            System.out.println("Invalid Credentials, please try again");
            name=scanner.next();
            password=scanner.next();
        }
            if (salesclerk(name, password)) {
                System.out.println("Welcome Sales Clerk! What do you pretend do to?\n1-Specify a new product for sale\n2-View the products catalog\n3-Register a new customer\n4-Create a new product in behalf of a new customer");
            }
            if (projectmanager(name, password)) {
                System.out.println("Welcome Project Manager! What do you pretend to do?\n1-Check the team progress");
            }
            if (warehouseemployee(name, password)) {
                System.out.println("Welcome Warehouse Employee! What do you pretend to do?\n1-Upload a JSON file\n2-Configure a AGV");
            }
            if (softwareproductclient(name, password)) {
                System.out.println("Welcome Software Domain.Product Client! What do you pretend to do=\n1-Check the presentation");
            }
    }

    //Os metodos estão static por causa da main, quando se criar mais classes mete-se estes métodos lá e tira se o static
    public static String tolowercase(String string) {
        return string.toLowerCase();
    }

    public static boolean salesclerk(String nome, String password) {
        return tolowercase(nome).equals("salesclerk@email.com") && password.equals("sc");
    }

    public static boolean projectmanager(String nome, String password) {
        return tolowercase(nome).equals("projectmanager@email.com") && password.equals("pm");
    }

    public static boolean warehouseemployee(String nome, String password) {
        return tolowercase(nome).equals("warehouseemployee@email.com") && password.equals("we");
    }

    public static boolean softwareproductclient(String nome, String password) {
        return tolowercase(nome).equals("softwareproductclient@email.com") && password.equals("spc");
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
        employee4.setId("Software.Product Client");
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