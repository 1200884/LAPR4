package eapli.base.warehousemanagement.Domain;


import eapli.framework.domain.model.Immutable;

import javax.persistence.Embeddable;

@Immutable
@Embeddable
public class EndDimension extends Dimensions{
    public EndDimension() {
    }

    public EndDimension(Long ewidth, Long elength) {
        super(ewidth, elength);
    }
}
