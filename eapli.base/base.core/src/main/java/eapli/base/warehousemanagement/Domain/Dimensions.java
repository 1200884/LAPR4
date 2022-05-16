package eapli.base.warehousemanagement.Domain;

import eapli.framework.domain.model.Immutable;
import eapli.framework.domain.model.ValueObject;

import javax.persistence.Embeddable;

@Immutable
@Embeddable
public class Dimensions implements ValueObject {
    private Long width;
    private Long length;

    protected Dimensions(){

    }

    public Dimensions(Long width,Long length){
        this.length=length;
        this.width=width;
    }

    public Long getLength() {
        return length;
    }

    public Long getWidth() {
        return width;
    }

    private void setLength(Long length) {
        this.length = length;
    }

    private void setWidth(Long width) {
        this.width = width;
    }

    @Override
    public String toString() {
        return "Dimensions : width= " + width + "length= " + length;
    }
}
