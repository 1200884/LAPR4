package eapli.base.warehousemanagement.Domain;

import eapli.framework.domain.model.Immutable;
import eapli.framework.domain.model.ValueObject;

import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.Id;

@Immutable
@Entity
public class Row implements ValueObject {
    @Id
    private Long id;
    @Embedded
    private BeginDimension begin;
    @Embedded
    private EndDimension end;

    private Long shelves;

    protected Row(){

    }

    public Row(Long id,Long bwidth,Long blength,Long ewidth,Long elength,Long shelves){
        this.begin= new BeginDimension(bwidth,blength);
        this.end= new EndDimension(ewidth,elength);
        this.shelves=shelves;
        this.id=id;
    }

    public EndDimension getEnd() {
        return end;
    }

    public BeginDimension getBegin() {
        return begin;
    }

    public Long getId() {
        return id;
    }

    public Long getShelves() {
        return shelves;
    }

    private void setId(Long id) {
        this.id = id;
    }

    private void setShelves(Long shelves) {
        this.shelves = shelves;
    }

    /*private void setAisle(Aisle aisle) {
        this.aisle = aisle;
    }*/

    private void setBegin(BeginDimension begin) {
        this.begin = begin;
    }

    private void setEnd(EndDimension end) {
        this.end = end;
    }
}
