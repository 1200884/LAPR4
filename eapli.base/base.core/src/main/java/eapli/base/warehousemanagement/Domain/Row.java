package eapli.base.warehousemanagement.Domain;

import eapli.framework.domain.model.Immutable;
import eapli.framework.domain.model.ValueObject;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Immutable
@Entity
public class Row implements ValueObject {
    @Id
    private Long id;
    private Long bwidth;
    private Long blength;
    private Long ewidth;
    private Long elength;

    private Long shelves;

    protected Row(){

    }

    public Row(Long id,Long bwidth,Long blength,Long ewidth,Long elength,Long shelves){
        this.ewidth= ewidth;
        this.elength=elength;
        this.bwidth= bwidth;
        this.blength=blength;
        this.shelves=shelves;
        this.id=id;
    }

    public Long getEwidth() {
        return ewidth;
    }

    public Long getElength() {
        return elength;
    }

    public Long getBwidth() {
        return bwidth;
    }

    public Long getBlength() {
        return blength;
    }

    public void setEwidth(Long ewidth) {
        this.ewidth = ewidth;
    }

    public void setElength(Long elength) {
        this.elength = elength;
    }

    public void setBwidth(Long bwidth) {
        this.bwidth = bwidth;
    }

    public void setBlength(Long blength) {
        this.blength = blength;
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
}
