package eapli.base.app.backoffice.console.Domain.Warehouse;

import eapli.framework.presentation.console.AbstractUI;

public class CreateAGVUI extends AbstractUI {
    @Override
    protected boolean doShow() {
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
