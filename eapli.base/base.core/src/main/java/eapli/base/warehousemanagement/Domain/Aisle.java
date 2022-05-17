package eapli.base.warehousemanagement.Domain;

import eapli.framework.domain.model.Immutable;
import eapli.framework.domain.model.ValueObject;


import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;


@Immutable
@Entity
public class Aisle implements ValueObject {
    @Id
    private Long id;
    private Long bwidth;
    private Long blength;
    private Long ewidth;
    private Long elength;
    private Long dwidth;
    private Long dlength;
    @OneToMany (cascade = CascadeType.ALL)
    @JoinColumn (name="AisleId")
    private Set<Row> rows = new HashSet<>();
    private String accessibility;

    protected Aisle(){

    }

    public Aisle(Long id, Long blength,Long bwidth,Long elength,Long ewidth,Long slength,Long swidth,String accessibility){
        this.id=id;
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

    private void setAccessibility(String accessibility) {
        this.accessibility = accessibility;
    }

    private void setId(Long id) {
        this.id = id;
    }

    public Long getBlength() {
        return blength;
    }

    public Long getBwidth() {
        return bwidth;
    }

    public Long getDlength() {
        return dlength;
    }

    public Long getDwidth() {
        return dwidth;
    }

    public Long getElength() {
        return elength;
    }

    public Long getEwidth() {
        return ewidth;
    }

    public void setBlength(Long blength) {
        this.blength = blength;
    }

    public void setBwidth(Long bwidth) {
        this.bwidth = bwidth;
    }

    public void setDlength(Long dlength) {
        this.dlength = dlength;
    }

    public void setDwidth(Long dwidth) {
        this.dwidth = dwidth;
    }

    public void setElength(Long elength) {
        this.elength = elength;
    }

    public void setEwidth(Long ewidth) {
        this.ewidth = ewidth;
    }

    public Set<Row> getRows() {
        return rows;
    }

    public void setRows(Set<Row> rows) {
        this.rows = rows;
    }

    public void addRow(Row row){
        this.rows.add(row);
    }

    @Override
    public String toString() {
        return "Aisle" +"id=" + id +", accessibility='" + accessibility;
    }
}
