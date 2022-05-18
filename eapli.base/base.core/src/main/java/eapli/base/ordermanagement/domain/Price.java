package eapli.base.ordermanagement.domain;


import eapli.framework.domain.model.Immutable;
import eapli.framework.domain.model.ValueObject;

import javax.persistence.Embeddable;

@Immutable
@Embeddable
public class Price implements ValueObject {
    private int baseprice;
    private int basepricewithtax;

    protected Price() {
    }

    public Price(int baseprice, int basepricewithtax) {
        this.baseprice = baseprice;
        this.basepricewithtax = basepricewithtax;
    }

    public int getBaseprice() {
        return baseprice;
    }

    public int getBasepricewithtax() {
        return basepricewithtax;
    }

    private void setBaseprice(int baseprice) {
        this.baseprice = baseprice;
    }

    private void setBasepricewithtax(int basepricewithtax) {
        this.basepricewithtax = basepricewithtax;
    }
}
