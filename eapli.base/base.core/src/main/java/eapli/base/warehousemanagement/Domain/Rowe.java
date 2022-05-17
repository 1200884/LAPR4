package eapli.base.warehousemanagement.Domain;

import eapli.framework.domain.model.Immutable;
import eapli.framework.domain.model.ValueObject;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Immutable
@Entity
public class Rowe implements ValueObject {
    @Id
    @GeneratedValue
    private int id;
    private Long rowe_id;
    private Long bwidth;
    private Long blength;
    private Long ewidth;
    private Long elength;

    private Long shelves;

    protected Rowe(){

    }

    public Rowe(Long rowe_id, Long bwidth, Long blength, Long ewidth, Long elength, Long shelves){
        this.ewidth= ewidth;
        this.elength=elength;
        this.bwidth= bwidth;
        this.blength=blength;
        this.shelves=shelves;
        this.rowe_id =rowe_id;
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

    public Long getRowe_id() {
        return rowe_id;
    }

    public Long getShelves() {
        return shelves;
    }

    private void setRowe_id(Long rowe_id) {
        this.rowe_id = rowe_id;
    }

    private void setShelves(Long shelves) {
        this.shelves = shelves;
    }
}
