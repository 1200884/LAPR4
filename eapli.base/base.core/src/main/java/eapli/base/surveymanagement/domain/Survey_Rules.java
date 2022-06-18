package eapli.base.surveymanagement.domain;

import eapli.framework.domain.model.Immutable;
import eapli.framework.domain.model.ValueObject;

import javax.persistence.Embeddable;

@Immutable
@Embeddable
public class Survey_Rules implements ValueObject {

    public enum SurveyRules {
        CUSTOMERS,
        FEMALE_GENDER,
        ADIDAS_BUYERS
    }

    private SurveyRules rules;

    protected Survey_Rules(){
    }

    public Survey_Rules(SurveyRules survey_rules){
        this.rules=survey_rules;
    }

    public SurveyRules getRules() {
        return rules;
    }

    private void setRules(SurveyRules rules) {
        this.rules = rules;
    }
}
