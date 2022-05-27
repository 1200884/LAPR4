package eapli.base.persistence.impl.inmemory;

import eapli.base.ordermanagement.domain.Orders;
import eapli.base.ordermanagement.repositories.OrderRepository;
import eapli.framework.infrastructure.repositories.impl.inmemory.InMemoryDomainRepository;

import java.util.ArrayList;

public class InMemoryOrderRepository extends InMemoryDomainRepository<Orders, String> implements OrderRepository {
    static {
        InMemoryInitializer.init();
    }

    @Override
    public Iterable<Orders> findAll() {
        return super.findAll();
    }



}
