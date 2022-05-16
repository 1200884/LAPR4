package eapli.base.warehousemanagement.Domain;


import eapli.framework.domain.model.Immutable;

import javax.persistence.Embeddable;

@Immutable
@Embeddable
public class BeginDimension extends Dimensions{

    public BeginDimension(Long bwidth, Long blength) {
        super(bwidth, blength);
    }

    protected BeginDimension() {

    }
}
