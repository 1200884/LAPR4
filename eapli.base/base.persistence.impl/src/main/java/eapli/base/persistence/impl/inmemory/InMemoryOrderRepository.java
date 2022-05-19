package eapli.base.persistence.impl.inmemory;

import eapli.base.ordermanagement.domain.Order;
import eapli.base.ordermanagement.repositories.OrderRepository;
import eapli.framework.infrastructure.repositories.impl.inmemory.InMemoryDomainRepository;

public class InMemoryOrderRepository extends InMemoryDomainRepository<Order, String> implements OrderRepository {
    static {
        InMemoryInitializer.init();
    }

    @Override
    public Iterable<Order> findAll() {
        return super.findAll();
    }



}
