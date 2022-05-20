package eapli.base.AGVmanagement.AGV.application;

import eapli.base.AGVmanagement.AGV.domain.AGV;
import eapli.base.AGVmanagement.AGV.domain.Status;
import eapli.base.modelmanagement.Model.domain.Model;
import eapli.base.AGVmanagement.AGV.domain.repository.AGVPersist;

public class AGVService {

    private static final AGVPersist agvPersist = new AGVPersist();

    public AGV createAGV(double maxWeight, String baseLocation, String shortDescription, Model model) {
        AGV agv = new AGV(maxWeight, baseLocation, shortDescription, model, new Status(2, "No task"));
        return agvPersist.createAGVPersist(agv);
    }
}
