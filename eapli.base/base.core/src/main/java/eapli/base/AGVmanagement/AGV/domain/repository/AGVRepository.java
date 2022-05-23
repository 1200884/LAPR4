package eapli.base.AGVmanagement.AGV.domain.repository;

import eapli.base.AGVmanagement.AGV.domain.AGV;
import eapli.framework.domain.repositories.DomainRepository;

public interface AGVRepository extends DomainRepository<Integer, AGV> {
    Iterable<AGV> findAll();
}
