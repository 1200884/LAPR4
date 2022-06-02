package eapli.base.AGVmanagement.AGV.application;

import eapli.base.AGVmanagement.AGV.domain.AGV;
import eapli.base.AGVmanagement.AGV.domain.Status;
import eapli.base.AGVmanagement.AGV.domain.repository.AGVRepository;
import eapli.base.infrastructure.persistence.PersistenceContext;
import eapli.base.modelmanagement.Model.domain.Model;
import eapli.base.AGVmanagement.AGV.domain.repository.AGVPersist;
import eapli.base.ordermanagement.domain.Orders;

import java.util.ArrayList;
import java.util.Set;

public class AGVService {

    private static final AGVPersist agvPersist = new AGVPersist();
    private static final AGVRepository agvrepository = PersistenceContext.repositories().AGVs();

    public AGV createAGV(double maxWeight, String baseLocation, String shortDescription, Model model) {
        AGV agv = new AGV(maxWeight, baseLocation, shortDescription, model, new Status(2, "null"));
        return agvPersist.createAGVPersist(agv);
    }

    public static Iterable<AGV> getAgvs() {
        return agvrepository.findAll();
    }

    public void updateAGV(AGV agv) {
        agvrepository.save(agv);
    }
}
