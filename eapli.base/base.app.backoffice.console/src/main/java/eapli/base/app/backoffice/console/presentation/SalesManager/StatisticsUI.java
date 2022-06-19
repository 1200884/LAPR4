package eapli.base.app.backoffice.console.presentation.SalesManager;

import eapli.base.ordermanagement.application.ListOrdersOfCostumerController;
import eapli.base.surveymanagement.ANTLR.Calc;
import eapli.base.surveymanagement.REPORT.Calc2;
import eapli.base.surveymanagement.REPORT.StatisticsController;
import eapli.base.surveymanagement.domain.Questionnaire;
import eapli.framework.io.util.Console;
import eapli.framework.presentation.console.AbstractUI;

import java.io.IOException;

public class StatisticsUI extends AbstractUI {
    /**
     * rendering of the UI. follows the Template Method pattern
     *
     * @return true if the user wants to leave this UI
     */
    @Override
    protected boolean doShow() {

        StatisticsController theController = new StatisticsController();

        try {
            for (String s : theController.findQuestionnaires()){
                System.out.println(s);
            }
            int f= Console.readInteger("Write the ID of one questionnaire.");
            theController.getQuestionnaire(f);
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
        return "Statistics";
    }
}
