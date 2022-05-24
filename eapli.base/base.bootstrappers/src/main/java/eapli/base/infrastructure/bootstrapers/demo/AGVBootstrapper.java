package eapli.base.infrastructure.bootstrapers.demo;

import eapli.base.AGVmanagement.AGV.domain.AGV;
import eapli.base.AGVmanagement.AGV.domain.Status;
import eapli.base.customermanagement.domain.model.Shopping_Cart;
import eapli.base.infrastructure.bootstrapers.AGVBootstrapperBase;
import eapli.base.modelmanagement.Model.domain.Model;
import eapli.base.ordermanagement.domain.Orders;
import eapli.base.ordermanagement.domain.OrderLevel;
import eapli.base.ordermanagement.domain.Shipment_Method;
import eapli.framework.actions.Action;

public class AGVBootstrapper extends AGVBootstrapperBase implements Action {
    @Override
    public boolean execute() {
        Model model = createModel("BOT-AGV", "The best AGVs in the west");
        System.out.println("alfredo");
        Status status=new Status(2,null,0);
        System.out.println("eusebiozao");
        createAGV(60, "AGV Dock", "Fast and good AGV", model,status);
        createAGV(50,"Algarve","AGV do Algarve",model,status);
        createAGV(70,"Vila Real","AGV de Vila Real",model,status);
        createAGV(80,"Espanha","AGV espanhol",model,status);
        createAGV(90,"Setubal","AGV de Setúbal", model,status);
       return true;
    }

    private Model createModel(final String name, final String description) {
        return registerModel(name, description);
    }

    private AGV createAGV(final double maxWeight, final String baseLocation, final String shortDescription, final Model model,final Status status) {
        return registerAGV(maxWeight, baseLocation, shortDescription, model);
    }


}
