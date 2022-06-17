package eapli.base.app.backoffice.console.presentation.SalesManager;

import eapli.base.surveymanagement.ANTLR.Calc;
import eapli.framework.io.util.Console;
import eapli.framework.presentation.console.AbstractUI;

import java.io.IOException;

public class AnswerSurveyUI extends AbstractUI {
    /**
     * rendering of the UI. follows the Template Method pattern
     *
     * @return true if the user wants to leave this UI
     */
    @Override
    protected boolean doShow() {
        Calc calc = new Calc();
        System.out.println("Write your respective VAT");
        int vat= Console.readInteger("Answer: ");
        try {
            calc.validateGrammar("Documents/teste.txt",2,vat);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return true;
    }

    /**
     * The title of the "window"
     *
     * @return the title of the window
     */
    @Override
    public String headline() {
        return "Surveys";
    }
}
