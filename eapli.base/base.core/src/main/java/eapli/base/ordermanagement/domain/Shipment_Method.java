package eapli.base.ordermanagement.domain;

import eapli.framework.domain.model.Immutable;
import eapli.framework.domain.model.ValueObject;

import javax.persistence.Embeddable;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.util.Objects;

@Immutable
@Embeddable
public class Shipment_Method implements ValueObject {

    public enum ShipmentMethod {
        EXPRESS,
        NORMAL
    }

    private ShipmentMethod shipmentMethod;

    protected Shipment_Method() {
    }

    public Shipment_Method(ShipmentMethod shipmentMethod) {
        this.shipmentMethod = shipmentMethod;
    }

    public ShipmentMethod getShipmentMethod() {
        return shipmentMethod;
    }

    private void setShipmentMethod(ShipmentMethod shipmentMethod) {
        this.shipmentMethod = shipmentMethod;
    }
}
