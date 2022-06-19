package eapli.base.persistence.impl.inmemory;

import eapli.base.clientusermanagement.domain.MecanographicNumber;
import eapli.base.customermanagement.domain.model.Customer;
import eapli.base.customermanagement.domain.repositories.CustomerRepository;
import eapli.base.ordermanagement.repositories.OrderRepository;
import eapli.framework.infrastructure.repositories.impl.inmemory.InMemoryDomainRepository;

import java.util.Optional;

public class InMemoryCustomerRepository extends InMemoryDomainRepository<Customer, Integer> implements CustomerRepository {
    static {
        InMemoryInitializer.init();
    }


    @Override
    public Optional<Customer> findByPhoneNumber(Integer vat) {
        return Optional.of(data().get(vat));
    }

    @Override
    public Optional<Customer> findByShoppingCartId(Integer id) {
        return Optional.of(data().get(id));
    }
}
