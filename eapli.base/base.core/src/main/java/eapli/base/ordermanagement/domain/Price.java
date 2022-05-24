package eapli.base.ordermanagement.domain;


import eapli.framework.domain.model.Immutable;
import eapli.framework.domain.model.ValueObject;

import javax.persistence.Embeddable;

@Immutable
@Embeddable
public class Price implements ValueObject {
    private int baseprice;
    private double basepricewithtax;

    protected Price() {
    }

    public Price(int baseprice, double basepricewithtax) {
        this.baseprice = baseprice;
        this.basepricewithtax = basepricewithtax;
    }

    public int getBaseprice() {
        return baseprice;
    }

    public double getBasepricewithtax() {
        return basepricewithtax;
    }

    private void setBaseprice(int baseprice) {
        this.baseprice = baseprice;
    }

    private void setBasepricewithtax(double basepricewithtax) {
        this.basepricewithtax = basepricewithtax;
    }
}
