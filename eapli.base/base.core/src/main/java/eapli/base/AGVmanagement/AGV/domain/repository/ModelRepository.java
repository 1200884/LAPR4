package eapli.base.AGVmanagement.AGV.domain.repository;

import eapli.base.AGVmanagement.AGV.domain.Model;
import eapli.framework.domain.repositories.DomainRepository;

import java.util.Optional;

public interface ModelRepository extends DomainRepository<Integer, Model> {

    Optional<Model> findByVat(int vat);
}
