package eapli.base.customermanagement.domain.repositories;

import eapli.base.customermanagement.domain.model.Customer;
import eapli.framework.domain.repositories.DomainRepository;

import javax.persistence.criteria.CriteriaBuilder;
import java.util.Optional;

public interface CustomerRepository extends DomainRepository<Integer,Customer> {

    Optional<Customer> findByPhoneNumber(Integer id);

    Optional<Customer> findByShoppingCartId(Integer id);

}
