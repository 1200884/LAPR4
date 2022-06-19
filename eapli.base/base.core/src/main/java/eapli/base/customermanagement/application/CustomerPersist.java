package eapli.base.customermanagement.application;

import eapli.base.customermanagement.domain.model.Customer;
import eapli.base.customermanagement.domain.repositories.CustomerRepository;
import eapli.base.infrastructure.persistence.PersistenceContext;
import eapli.base.surveymanagement.domain.Questionnaire;
import eapli.base.surveymanagement.domain.Repository.QuestionnaireRepository;
import eapli.base.surveymanagement.domain.Survey_Rules;
import org.springframework.beans.factory.annotation.Autowired;

public class CustomerPersist {
    @Autowired
    CustomerRepository customerRepository= PersistenceContext.repositories().customers();
    QuestionnaireRepository questionnaireRepository=PersistenceContext.repositories().Questionnaire();
    public void createCustomerPersist(Customer customer){
        for(Questionnaire questionnaire : questionnaireRepository.findAll()){
            if(questionnaire.getRule().getRules().equals(Survey_Rules.SurveyRules.CUSTOMERS)){
                if(customerRepository.ofIdentity(123456789).isPresent()) {
                    Customer customer1 = customerRepository.ofIdentity(123456789).get();
                    if (customer1.getQuestionnaires().isEmpty()) {
                        customer1.addQuestionnaire(questionnaire);
                        customerRepository.save(customer1);
                    }
                }
                customer.addQuestionnaire(questionnaire);
            }
            if(questionnaire.getRule().getRules().equals(Survey_Rules.SurveyRules.FEMALE_GENDER) && customer.getGender().equals("female")){
                customer.addQuestionnaire(questionnaire);
            }
        }
        customerRepository.save(customer);
    }

    public void updateCustomer(Customer customer){
        customerRepository.save(customer);
    }
}