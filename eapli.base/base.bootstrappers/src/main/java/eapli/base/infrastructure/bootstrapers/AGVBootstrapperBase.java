package eapli.base.infrastructure.bootstrapers;

import eapli.base.AGVmanagement.AGV.application.AGVService;
import eapli.base.AGVmanagement.AGV.domain.AGV;
import eapli.base.modelmanagement.Model.application.ModelService;
import eapli.base.modelmanagement.Model.domain.Model;
import eapli.framework.domain.repositories.ConcurrencyException;
import eapli.framework.domain.repositories.IntegrityViolationException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class AGVBootstrapperBase {
    private static final Logger LOGGER = LoggerFactory.getLogger(AGVBootstrapperBase.class);

    final ModelService modelService = new ModelService();
    final AGVService agvService = new AGVService();

    public AGVBootstrapperBase() {
        super();
    }

    protected Model registerModel(final String name, final String description) {
        Model model = null;
        try {
            model = modelService.createModel(name, description);
            LOGGER.debug("»»» %s", name);
        }catch (final IntegrityViolationException | ConcurrencyException e) {
            model = null;
        }
        return model;
    }

    protected AGV registerAGV(final double maximum_weight, final String baseLocation, final String shortDescription, final Model model) {
        AGV agv = null;
        try {
            agv = agvService.createAGV(maximum_weight, baseLocation, shortDescription, model);
        }catch (final IntegrityViolationException | ConcurrencyException e) {
            agv = null;
        }
        return agv;
    }
}
