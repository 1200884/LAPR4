package eapli.base.customermanagement.application;

import eapli.base.customermanagement.domain.model.Customer;
import eapli.base.customermanagement.domain.repositories.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Optional;

public class CustomerPersist {
    @Autowired
    CustomerRepository customerRepository= new CustomerRepository() {
        @Override
        public Optional<Customer> findByVat(int vat) {
            return Optional.empty();
        }

        @Override
        public <S extends Customer> S save(S entity) {
            return null;
        }

        @Override
        public Iterable<Customer> findAll() {
            return null;
        }

        @Override
        public Optional<Customer> ofIdentity(Integer id) {
            return Optional.empty();
        }

        @Override
        public void delete(Customer entity) {

        }

        @Override
        public void deleteOfIdentity(Integer entityId) {

        }

        @Override
        public long count() {
            return 0;
        }
    };
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
        System.out.println(customer);
        System.out.println(customerRepository.findByVat(123456789));
    }
}