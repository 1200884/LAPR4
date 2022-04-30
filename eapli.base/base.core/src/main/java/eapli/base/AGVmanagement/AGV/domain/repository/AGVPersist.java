package eapli.base.AGVmanagement.AGV.domain.repository;

import eapli.base.AGVmanagement.AGV.domain.AGV;
import eapli.base.infrastructure.persistence.PersistenceContext;
import org.springframework.beans.factory.annotation.Autowired;

public class AGVPersist {

    @Autowired
    private static AGVRepository agvRepository = PersistenceContext.repositories().AGVs();

    public void createAGVPersist(AGV agv) {
        agvRepository.save(agv);
    }
}
