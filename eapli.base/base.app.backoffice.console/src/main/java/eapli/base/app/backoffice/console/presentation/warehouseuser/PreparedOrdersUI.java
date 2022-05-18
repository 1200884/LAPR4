package eapli.base.app.backoffice.console.presentation.warehouseuser;

import eapli.base.ordermanagement.domain.Order;
import eapli.framework.presentation.console.AbstractListUI;
import eapli.framework.presentation.console.AbstractUI;
import eapli.framework.visitor.Visitor;

public class PreparedOrdersUI extends AbstractListUI<Order> {
    @Override
    protected Iterable<Order> elements() {
        return null;
    }

    @Override
    protected Visitor<Order> elementPrinter() {
        return null;
    }

    @Override
    protected String elementName() {
        return null;
    }

    @Override
    protected String listHeader() {
        return null;
    }

    @Override
    protected String emptyMessage() {
        return null;

    }

    @Override
    public String headline() {
        return null;
    }
}
