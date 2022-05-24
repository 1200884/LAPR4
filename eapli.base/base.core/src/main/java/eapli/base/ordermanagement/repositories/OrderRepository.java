package eapli.base.ordermanagement.repositories;

import eapli.base.ordermanagement.domain.Orders;
import eapli.framework.domain.repositories.DomainRepository;

public interface OrderRepository extends DomainRepository<String, Orders> {
    Iterable<Orders> findAll();


}
