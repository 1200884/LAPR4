package eapli.base.app.backoffice.console.presentation.warehouseuser;

import eapli.base.warehousemanagement.AGVInfoToJSON;
import eapli.framework.presentation.console.AbstractUI;

public class CheckAGVStatusUI extends AbstractUI {

    @Override
    protected boolean doShow() {
        AGVInfoToJSON.agvinfotojson();
        return true;
    }

    @Override
    public String headline() {
        return "Check the status of each agv ";
    }
}
