package eapli.base.warehousemanagement.Domain;

import eapli.framework.domain.model.Immutable;
import eapli.framework.domain.model.ValueObject;

import javax.persistence.Embeddable;
import javax.persistence.Embedded;

@Immutable
@Embeddable
public class AGVDocks implements ValueObject {
    private Long id;
    private Long bwidth;
    private Long blength;
    private Long ewidth;
    private Long elength;
    private Long dwidth;
    private Long dlength;
    private String accessibility;

    protected AGVDocks(){

    }

    public AGVDocks(Long id, Long bwidth,Long blength,Long ewidth,Long elength,Long swidth,Long slength,String accessibility){
        this.accessibility=accessibility;
        this.ewidth= ewidth;
        this.elength=elength;
        this.bwidth= bwidth;
        this.blength=blength;
        this.dwidth=swidth;
        this.dlength=slength;
    }

    public Long getId() {
        return id;
    }

    public String getAccessibility() {
        return accessibility;
    }

    private void setId(Long id) {
        this.id = id;
    }

    private void setAccessibility(String accessibility) {
        this.accessibility = accessibility;
    }

    private Long getDlength() {
        return dlength;
    }

    private void setBwidth(Long bwidth) {
        this.bwidth = bwidth;
    }

    private Long getDwidth() {
        return dwidth;
    }

    private void setBlength(Long blength) {
        this.blength = blength;
    }

    private Long getEwidth() {
        return ewidth;
    }

    private void setElength(Long elength) {
        this.elength = elength;
    }

    private Long getElength() {
        return elength;
    }

    private void setEwidth(Long ewidth) {
        this.ewidth = ewidth;
    }

    private void setDwidth(Long dwidth) {
        this.dwidth = dwidth;
    }

    private void setDlength(Long dlength) {
        this.dlength = dlength;
    }

    private Long getBwidth() {
        return bwidth;
    }

    private Long getBlength() {
        return blength;
    }

    @Override
    public String toString() {
        return "ID: " + id + "\nAccessibility: " + accessibility;
    }
}
