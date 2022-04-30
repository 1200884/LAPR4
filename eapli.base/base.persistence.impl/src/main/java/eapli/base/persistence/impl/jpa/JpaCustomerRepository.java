package eapli.base.persistence.impl.jpa;

import eapli.base.Application;
import eapli.base.customermanagement.domain.model.Customer;
import eapli.base.customermanagement.domain.repositories.CustomerRepository;
import eapli.framework.domain.repositories.TransactionalContext;
import eapli.framework.infrastructure.repositories.impl.jpa.JpaAutoTxRepository;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

public class JpaCustomerRepository extends JpaAutoTxRepository<Customer,Integer,Integer> implements CustomerRepository {

    public JpaCustomerRepository(final TransactionalContext autoTx){
        super(autoTx,"vat");
    }

    public JpaCustomerRepository(final String puname){
        super(puname, Application.settings().getExtendedPersistenceProperties(),
                "vat");
    }

    @Override
    public Optional<Customer> findByPhoneNumber(Integer number) {
        final Map<String, Object> params = new HashMap<>();
        params.put("number", number);
        return matchOne("e.phone_number=:number", params);
    }

}
