package eapli.base.ordermanagement.repositories;

import eapli.base.ordermanagement.domain.Order;
import eapli.framework.domain.repositories.DomainRepository;

public interface OrderRepository extends DomainRepository<String, Order> {
    Iterable<Order> findAll();

}
