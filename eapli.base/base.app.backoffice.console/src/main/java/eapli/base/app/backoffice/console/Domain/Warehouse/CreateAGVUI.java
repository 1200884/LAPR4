package eapli.base.app.backoffice.console.Domain.Warehouse;

import eapli.base.AGVmanagement.AGV.application.AGVController;
import eapli.framework.io.util.Console;
import eapli.framework.presentation.console.AbstractUI;

public class CreateAGVUI extends AbstractUI {

    private static final AGVController agvController = new AGVController();

    @Override
    protected boolean doShow() {
        print("Please, for now, introduce the name and the description for the AGV:");
        double masWeight = Console.readDouble("First the max weight the AGV can carry:");
        String baseLocation = Console.readLine("Now the base location for the AGV:");
        String description = Console.readLine("Now a short description for the AGV:");
        print(agvController.findModels());
        int modelNum = Console.readInteger("Lastly, from the list above, select the model of the AGV:");
        print("Here is the created AGV:");
        print(agvController.createAVG(masWeight, baseLocation, description, modelNum));
        return false;
    }

    private void print(String string) {
        System.out.println(string);
    }

    @Override
    public String headline() {
        return "Create an AGV";
    }
}
