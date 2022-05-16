package eapli.base.warehousemanagement.Domain;


import eapli.framework.domain.model.Immutable;

import javax.persistence.Embeddable;

@Immutable
@Embeddable
public class DepthDimension extends Dimensions{
    public DepthDimension() {
    }

    public DepthDimension(Long dwidth, Long dlength) {
        super(dwidth, dlength);
    }
}
