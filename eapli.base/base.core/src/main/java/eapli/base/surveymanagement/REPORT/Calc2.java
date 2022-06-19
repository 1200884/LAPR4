package eapli.base.surveymanagement.REPORT;
import java.io.*;

import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.tree.*;
public class Calc2 {

    public void readAnswers(String path) throws IOException {
        FileInputStream fis = new FileInputStream(path);
        eapli.base.surveymanagement.REPORT.LabeledExpr2Lexer lexer = new LabeledExpr2Lexer(new ANTLRInputStream(fis));
        CommonTokenStream tokens = new CommonTokenStream(lexer);
        LabeledExpr2Parser parser = new LabeledExpr2Parser(tokens);
        ParseTree tree = parser.survey();
        EvalVisitor3 eval = new EvalVisitor3();
        eval.visit(tree);
        System.out.println("The answers file was read successfully.");
    }

}