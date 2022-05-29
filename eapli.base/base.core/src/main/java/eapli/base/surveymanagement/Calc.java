package eapli.base.surveymanagement;
import java.io.*;

import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.tree.*;
public class Calc {
    public void validateGrammar() throws IOException {
        FileInputStream fis = new FileInputStream(new File("Documents/teste.txt"));
        LabeledExprLexer lexer = new LabeledExprLexer(new ANTLRInputStream(fis));
        CommonTokenStream tokens = new CommonTokenStream(lexer);
        LabeledExprParser parser = new LabeledExprParser(tokens);
        ParseTree tree = parser.questionnaire(); // parse
        EvalVisitor eval = new EvalVisitor();
        eval.visit(tree);
        System.out.println("The .txt file was validated with success.");
    }
}