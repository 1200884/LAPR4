package eapli.base.surveymanagement.ANTLR;
import java.io.*;

import eapli.base.infrastructure.persistence.PersistenceContext;
import eapli.base.surveymanagement.domain.Questionnaire;
import eapli.base.surveymanagement.domain.Repository.QuestionnaireRepository;
import eapli.base.surveymanagement.domain.Survey_Rules;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.tree.*;
public class Calc {

    public void validateGrammar(String path,int i,int vat) throws IOException {
        FileInputStream fis = new FileInputStream(path);
        LabeledExprLexer lexer = new LabeledExprLexer(new ANTLRInputStream(fis));
        CommonTokenStream tokens = new CommonTokenStream(lexer);
        LabeledExprParser parser = new LabeledExprParser(tokens);
        ParseTree tree = parser.questionnaire(); // parse
        if(i==1) {
            EvalVisitor eval = new EvalVisitor();
            eval.visit(tree);
            Questionnaire questionnaire = new Questionnaire(path);
            questionnaire.setRule(new Survey_Rules(Survey_Rules.SurveyRules.CUSTOMERS));
            QuestionnaireRepository repository = PersistenceContext.repositories().Questionnaire();
            repository.save(questionnaire);
            System.out.println("The .txt file was validated with success.");
        }else{
            EvalVisitor2 eval = new EvalVisitor2(vat);
            eval.visit(tree);
        }
    }
}