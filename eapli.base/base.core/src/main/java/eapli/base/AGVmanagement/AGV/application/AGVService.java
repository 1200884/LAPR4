package eapli.base.AGVmanagement.AGV.application;

import eapli.base.AGVmanagement.AGV.domain.AGV;
import eapli.base.AGVmanagement.AGV.domain.Status;
import eapli.base.AGVmanagement.AGV.domain.repository.AGVRepository;
import eapli.base.infrastructure.persistence.PersistenceContext;
import eapli.base.modelmanagement.Model.domain.Model;
import eapli.base.AGVmanagement.AGV.domain.repository.AGVPersist;

import java.util.ArrayList;

public class AGVService {

    private static final AGVPersist agvPersist = new AGVPersist();
    private static AGVRepository agvRepository;

    public AGV createAGV(double maxWeight, String baseLocation, String shortDescription, Model model) {
        AGV agv = new AGV(maxWeight, baseLocation, shortDescription, model, new Status(2, "null"));
        return agvPersist.createAGVPersist(agv);
    }

    public synchronized static ArrayList<AGV> getAgvs() {
        agvRepository = PersistenceContext.repositories().AGVs();
        return (ArrayList<AGV>) agvRepository.findAll();
    }

    public synchronized void updateAGV(AGV agv) {
        agvRepository = PersistenceContext.repositories().AGVs();
        agvRepository.save(agv);
    }
}
