package eapli.base.app.backoffice.console.presentation.SalesManager;

import eapli.base.surveymanagement.ANTLR.Calc;
import eapli.framework.io.util.Console;
import eapli.framework.presentation.console.AbstractUI;

import java.io.IOException;

public class QuestionerUI extends AbstractUI {

    @Override
    protected boolean doShow() {
        Calc calc = new Calc();
        try {
            String path = Console.readLine("Write the path of the questionnaire you want to validate");
            calc.validateGrammar(path,1,0);
        } catch (IOException e) {
            System.out.println("FALHOU");
            e.printStackTrace();
        }
        return false;
    }

    @Override
    public String headline() {
        return "Validate Grammar";
    }
}
