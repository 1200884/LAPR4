package eapli.base.AGVmanagement.AGV.domain.repository;

import eapli.base.AGVmanagement.AGV.domain.AGV;
import eapli.framework.domain.repositories.DomainRepository;

import java.util.Optional;

public interface AGVRepository extends DomainRepository<Integer, AGV> {

    Optional<AGV> findByVat(int vat);
}
