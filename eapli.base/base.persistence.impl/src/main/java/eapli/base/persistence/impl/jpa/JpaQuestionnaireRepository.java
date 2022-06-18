package eapli.base.persistence.impl.jpa;

import eapli.base.Application;
import eapli.base.surveymanagement.domain.Questionnaire;
import eapli.base.surveymanagement.domain.Repository.QuestionnaireRepository;
import eapli.framework.domain.repositories.TransactionalContext;
import eapli.framework.infrastructure.repositories.impl.jpa.JpaAutoTxRepository;

public class JpaQuestionnaireRepository extends JpaAutoTxRepository<Questionnaire,Integer,Integer> implements QuestionnaireRepository {

    public JpaQuestionnaireRepository(final TransactionalContext autoTx) {
        super(autoTx,"id");
    }

    public JpaQuestionnaireRepository(final String puname){
        super(puname, Application.settings().getExtendedPersistenceProperties(),"id");
    }
}
