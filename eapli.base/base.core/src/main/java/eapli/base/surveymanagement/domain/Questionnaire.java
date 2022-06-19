package eapli.base.surveymanagement.domain;



import eapli.base.customermanagement.domain.model.Customer;
import eapli.framework.domain.model.AggregateRoot;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

@Entity
public class Questionnaire implements AggregateRoot<Integer> {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private int id;
    private String path;
    private String path2;
    @Embedded
    private Survey_Rules rule;
    @ManyToMany
    Set<Customer> customers;
    protected Questionnaire(){
    }

    public Questionnaire(String path){
        this.path=path;
        this.customers=new HashSet<>();
    }

    public int getId() {
        return id;
    }

    public String getPath() {
        return path;
    }

    public String getPath2(){return path2;}

    public void setPath2(String path2){this.path2=path2;}

    public void setRule(Survey_Rules rule) {
        this.rule = rule;
    }

    public Survey_Rules getRule() {
        return rule;
    }

    public void addCustomer(Customer customer){
        this.customers.add(customer);
    }
    /**
     * Entities are compared by identity only, so equals() must only compare
     * identities. In some situations however we might want to compare the
     * contents of the object by value.
     *
     * @param other the other object to compare
     * @return {@code true} if this domain entity have the "same content" as the
     * {@code other}
     */
    @Override
    public boolean sameAs(Object other) {
        return false;
    }

    /**
     * Returns the primary <b>business</b> id of the entity.
     *
     * <p>
     * This method is marked as a getter for Jackson serialization
     *
     * @return the primary <b>business</b> id of the entity
     */
    @Override
    public Integer identity() {
        return null;
    }
}
