package eapli.base.AGVmanagement.AGV.application;

import eapli.base.AGVmanagement.AGV.domain.AGV;
import eapli.base.AGVmanagement.AGV.domain.Model;

public class AGVController {

    public String createAVG(int maxWeight, String baseLocation, String shortDescription, int modelID) {
        AGV agv = new AGV(maxWeight, baseLocation, shortDescription, getModel(modelID));
        //por a dar persist
        return agv.toString();
    }

    private Model getModel(int modelID) {
        Model model = new Model("prov", "prov");
        return model;
    }
}
