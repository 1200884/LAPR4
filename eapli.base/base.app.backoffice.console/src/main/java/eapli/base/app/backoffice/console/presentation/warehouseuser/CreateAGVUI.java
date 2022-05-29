package eapli.base.app.backoffice.console.presentation.warehouseuser;

import eapli.base.AGVmanagement.AGV.application.AGVController;
import eapli.framework.io.util.Console;
import eapli.framework.presentation.console.AbstractUI;

public class CreateAGVUI extends AbstractUI {

    private static final AGVController agvController = new AGVController();

    @Override
    protected boolean doShow() {
        print("Please, for now, introduce the name and the description for the AGV:");
        double masWeight = Console.readDouble("First the max weight the AGV can carry:");
        print(agvController.findWarehouses());
        int warehouseNum = Console.readInteger("From this list of warehouses, chose the warehouse where the AGV will work:");
        //print(agvController.findDocks(warehouseNum));
        int dockNum = Console.readInteger("And from this list of docks in the warehouse, chose the one where the AGV will be stationed:");
        String description = Console.readLine("Now a short description for the AGV:");
        print(agvController.findModels());
        int modelNum = Console.readInteger("Lastly, from the list above, select the ID of the model for the AGV:");
        while (!agvController.verifyModel(modelNum)) {
            modelNum = Console.readInteger("The number inserted did not match any of the models, please insert a new one:");
        }
        print("Here is the created AGV:");
        //print(agvController.createAVG(masWeight, dockNum, description, modelNum));
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
