package eapli.base.app.user.console.presentation;

import eapli.base.surveymanagement.ANTLR.Calc;
import eapli.base.surveymanagement.Application.SurveyController;
import eapli.framework.io.util.Console;
import eapli.framework.presentation.console.AbstractUI;

import java.io.IOException;

public class AnswerSurveyUI extends AbstractUI {
    private static final SurveyController theController = new SurveyController();

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
        while (!theController.checkVat(vat)){
            vat= Console.readInteger("Answer: ");
        }
        String surveys =theController.seeSurveys();
        System.out.println(surveys);
        if(!surveys.isEmpty()) {
            String[] lines = surveys.split("\r\n|\r|\n");
            String path = theController.chosenSurvey(Console.readOption(1, lines.length, 0));
            try {
                calc.validateGrammar(path, 2, vat);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }else{
            System.out.println("You have no Questionnaires to answer");
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
