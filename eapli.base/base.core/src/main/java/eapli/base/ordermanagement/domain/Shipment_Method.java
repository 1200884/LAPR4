package eapli.base.ordermanagement.domain;

import eapli.framework.domain.model.Immutable;
import eapli.framework.domain.model.ValueObject;

import javax.persistence.Embeddable;
import javax.persistence.Id;
import java.util.Objects;

@Immutable
@Embeddable
public class Shipment_Method implements ValueObject {
    private int method_id;
    enum ShipmentMethod {
        EXPRESS,
        NORMAL
    }

    private ShipmentMethod shipmentMethod;

    protected Shipment_Method() {
    }

    public Shipment_Method(int method_id, ShipmentMethod shipmentMethod) {
        this.method_id = method_id;
        this.shipmentMethod = shipmentMethod;
    }

    public int getMethod_id() {
        return method_id;
    }

    public ShipmentMethod getShipmentMethod() {
        return shipmentMethod;
    }

    private void setMethod_id(int method_id) {
        this.method_id = method_id;
    }

    private void setShipmentMethod(ShipmentMethod shipmentMethod) {
        this.shipmentMethod = shipmentMethod;
    }
}
