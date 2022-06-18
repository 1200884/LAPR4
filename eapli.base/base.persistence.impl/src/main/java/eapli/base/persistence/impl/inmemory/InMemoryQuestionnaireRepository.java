package eapli.base.persistence.impl.inmemory;

import eapli.base.surveymanagement.domain.Questionnaire;
import eapli.base.surveymanagement.domain.Repository.QuestionnaireRepository;
import eapli.framework.infrastructure.repositories.impl.inmemory.InMemoryDomainRepository;

public class InMemoryQuestionnaireRepository extends InMemoryDomainRepository<Questionnaire,Integer> implements QuestionnaireRepository {
    static {
        InMemoryInitializer.init();
    }

    @Override
        public Iterable<Questionnaire> findAll(){
        return super.findAll();
    }
}
