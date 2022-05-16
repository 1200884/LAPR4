package eapli.base.warehousemanagement.Domain;

import eapli.framework.domain.model.Immutable;
import eapli.framework.domain.model.ValueObject;

import javax.persistence.Embeddable;
import javax.persistence.Embedded;

@Immutable
@Embeddable
public class AGVDocks implements ValueObject {
    private Long id;
    @Embedded
    private BeginDimension begin;
    @Embedded
    private EndDimension end;
    @Embedded
    private DepthDimension depth;
    private String accessibility;

    protected AGVDocks(){

    }

    public AGVDocks(Long id, Long bwidth,Long blength,Long ewidth,Long elength,Long swidth,Long slength,String accessibility){
        this.accessibility=accessibility;
        this.begin=new BeginDimension(bwidth,blength);
        this.end=new EndDimension(ewidth,elength);
        this.depth=new DepthDimension(swidth,slength);
    }

    public Long getId() {
        return id;
    }

    public Dimensions getBegin() {
        return begin;
    }

    public Dimensions getEnd() {
        return end;
    }

    public String getAccessibility() {
        return accessibility;
    }

    public Dimensions getDepth() {
        return depth;
    }

    private void setEnd(EndDimension end) {
        this.end = end;
    }

    private void setBegin(BeginDimension begin) {
        this.begin = begin;
    }

    private void setId(Long id) {
        this.id = id;
    }

    private void setAccessibility(String accessibility) {
        this.accessibility = accessibility;
    }

    private void setDepth(DepthDimension depth) {
        this.depth = depth;
    }

    @Override
    public String toString() {
        return "AGVDocks{" +
                "id=" + id +
                ", begin=" + begin +
                ", end=" + end +
                ", depth=" + depth +
                ", accessibility='" + accessibility + '\'' +
                '}';
    }
}
