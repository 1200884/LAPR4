package eapli.base.app.backoffice.console.presentation.SalesManager;

import eapli.base.surveymanagement.Calc;
import eapli.framework.presentation.console.AbstractUI;

import java.io.IOException;

public class QuestionerUI extends AbstractUI {

    @Override
    protected boolean doShow() {
        Calc calc = new Calc();
        try {
            calc.validateGrammar();
        } catch (IOException e) {
            System.out.println("FALHOU");
            e.printStackTrace();
        }
        return false;
    }

    @Override
    public String headline() {
        return "The grammar is being used to validate the .txt file";
    }
}
