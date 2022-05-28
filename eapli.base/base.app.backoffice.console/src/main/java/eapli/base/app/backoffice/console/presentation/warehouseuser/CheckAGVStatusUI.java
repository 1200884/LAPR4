package eapli.base.app.backoffice.console.presentation.warehouseuser;

import eapli.framework.presentation.console.AbstractUI;

public class CheckAGVStatusUI extends AbstractUI {

    @Override
    protected boolean doShow() {
        System.out.println();
        return true;
    }

    @Override
    public String headline() {
        return "Check the status of each agv ";
    }
}
