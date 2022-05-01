package eapli.base.infrastructure.bootstrapers.demo;

import eapli.base.AGVmanagement.AGV.domain.AGV;
import eapli.base.infrastructure.bootstrapers.AGVBootstrapperBase;
import eapli.base.modelmanagement.Model.domain.Model;
import eapli.framework.actions.Action;

public class AGVBootstrapper extends AGVBootstrapperBase implements Action {
    @Override
    public boolean execute() {
        Model model = createModel("BOT-AGV", "The best AGVs in the west");
        createAGV(60, "AGV Dock", "Fast and good AGV", model);
        return true;
    }

    private Model createModel(final String name, final String description) {
        return registerModel(name, description);
    }

    private AGV createAGV(final double maxWeight, final String baseLocation, final String shortDescription, final Model model) {
        return registerAGV(maxWeight, baseLocation, shortDescription, model);
    }
}
