package eapli.base.surveymanagement.domain;


import javax.persistence.*;
import java.util.ArrayList;
import java.util.Collection;

@Entity
public class Questionnaire {
    @Id
    @GeneratedValue
    private int id;
    private String path;


    protected Questionnaire(){
    }

    public Questionnaire(String path){
        this.path=path;
    }

    public int getId() {
        return id;
    }

    public String getPath() {
        return path;
    }
}
