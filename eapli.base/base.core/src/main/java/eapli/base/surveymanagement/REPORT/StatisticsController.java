package eapli.base.surveymanagement.REPORT;

import eapli.base.customermanagement.domain.repositories.CustomerRepository;
import eapli.base.infrastructure.persistence.PersistenceContext;
import eapli.base.ordermanagement.application.ListOrdersOfCostumerController;
import eapli.base.surveymanagement.domain.Questionnaire;
import eapli.base.surveymanagement.domain.Repository.QuestionnaireRepository;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class StatisticsController {
    QuestionnaireRepository questionnaireRepository = PersistenceContext.repositories().Questionnaire();

    public ArrayList<String> findQuestionnaires(){
        Iterable<Questionnaire> it_q = questionnaireRepository.findAll();
        ArrayList<String> strings= new ArrayList<>();
        for(Questionnaire q: it_q){
            strings.add(String.valueOf(q.getId()));
        }
        return strings;
    }

    public void getQuestionnaire(String f) throws IOException {
        Calc2 calc = new Calc2();
        int j= Integer.parseInt(f);
        Optional<Questionnaire> optionalQuestionnaire= questionnaireRepository.ofIdentity(j);
        if(optionalQuestionnaire.isPresent()){
            calc.readAnswers(optionalQuestionnaire.get().getPath2());
        }

    }
}
