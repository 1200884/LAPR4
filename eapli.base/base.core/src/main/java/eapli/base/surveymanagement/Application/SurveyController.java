package eapli.base.surveymanagement.Application;

import eapli.base.customermanagement.domain.model.Customer;
import eapli.base.customermanagement.domain.repositories.CustomerRepository;
import eapli.base.infrastructure.persistence.PersistenceContext;
import eapli.base.surveymanagement.domain.Questionnaire;
import eapli.framework.application.UseCaseController;

import java.util.ArrayList;
import java.util.Optional;

@UseCaseController
public class SurveyController {
    private final CustomerRepository  cr = PersistenceContext.repositories().customers();
    private Customer customer;
    public String seeSurveys(){
        StringBuilder stringBuilder = new StringBuilder();
        int i =1;
        for(Questionnaire questionnaire : customer.getQuestionnaires()){
            stringBuilder.append(i).append("-").append(questionnaire.getId()).append("\n");
            i++;
        }
        return stringBuilder.toString();
    }

    public boolean checkVat(int vat){
        Optional<Customer> customer1=cr.ofIdentity(vat);
        if(customer1.isPresent()) {
            customer = customer1.get();
            return true;
        }else {
            return false;
        }
    }

    public String  chosenSurvey(int option) {
        ArrayList<Questionnaire> list = new ArrayList<>(customer.getQuestionnaires());
        return list.get(option-1).getPath();
    }
}
