package eapli.base.warehousemanagement.Domain;

import eapli.framework.domain.model.Immutable;
import eapli.framework.domain.model.ValueObject;


import javax.persistence.Embeddable;
import javax.persistence.Embedded;


@Immutable
@Embeddable
public class Aisle implements ValueObject {
    private Long id;
    @Embedded
    private BeginDimension begin;
    @Embedded
    private EndDimension end;
    @Embedded
    private DepthDimension depth;
    private String accessibility;

    protected Aisle(){

    }

    public Aisle(Long id, Long blength,Long bwidth,Long elength,Long ewidth,Long slength,Long swidth,String accessibility){
        this.id=id;
        this.accessibility=accessibility;
        this.end = new EndDimension(ewidth,elength);
        this.begin = new BeginDimension(bwidth,blength);
        this.depth = new DepthDimension(swidth,slength);
    }

    public Long getId() {
        return id;
    }

    public Dimensions getBegin() {
        return begin;
    }

    public Dimensions getDepth() {
        return depth;
    }

    public Dimensions getEnd() {
        return end;
    }

    public String getAccessibility() {
        return accessibility;
    }

    private void setAccessibility(String accessibility) {
        this.accessibility = accessibility;
    }

    private void setId(Long id) {
        this.id = id;
    }

    private void setDepth(DepthDimension depth) {
        this.depth = depth;
    }

    private void setBegin(BeginDimension begin) {
        this.begin = begin;
    }

    private void setEnd(EndDimension end) {
        this.end = end;
    }

    @Override
    public String toString() {
        return "Aisle" +"id=" + id +", begin=" + begin +", end=" + end +", depth=" + depth +", accessibility='" + accessibility;
    }
}
