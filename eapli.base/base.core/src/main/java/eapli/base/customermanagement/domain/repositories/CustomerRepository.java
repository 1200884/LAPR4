package eapli.base.customermanagement.domain.repositories;

import eapli.base.customermanagement.domain.model.Customer;
import eapli.framework.domain.repositories.DomainRepository;
import eapli.framework.infrastructure.repositories.Repository;

import java.util.Calendar;

public interface CustomerRepository extends Repository<Customer,Integer> {

}
