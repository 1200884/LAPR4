package eapli.base.app.backoffice.console.presentation.warehouseuser;

import eapli.base.warehousemanagement.JSONReader;
import eapli.framework.io.util.Console;
import eapli.framework.presentation.console.AbstractUI;

import java.io.FileNotFoundException;

public class JSONUI extends AbstractUI {
    JSONReader jsonReader = new JSONReader();

    @Override
    protected boolean doShow() {
        String path = Console.readLine("Please enter the path of the JSON file");
        try {
            jsonReader.jsonReader(path);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        return false;
    }

    @Override
    public String headline() {
        return "JSON file Upload";
    }
}
