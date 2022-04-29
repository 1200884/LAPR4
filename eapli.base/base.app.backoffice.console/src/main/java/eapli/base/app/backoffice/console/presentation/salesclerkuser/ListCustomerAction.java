package eapli.base.app.backoffice.console.presentation.salesclerkuser;

import eapli.base.app.backoffice.console.presentation.authz.ListUsersUI;
import eapli.framework.actions.Action;

public class ListCustomerAction implements Action {

    @Override
    public boolean execute() {
        return new ListCustomerUI().show();
    }
}
