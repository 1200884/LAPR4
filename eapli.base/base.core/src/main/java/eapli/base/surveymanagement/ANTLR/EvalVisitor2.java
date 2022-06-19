package eapli.base.surveymanagement.ANTLR;

import eapli.framework.io.util.Console;
import org.antlr.v4.runtime.BufferedTokenStream;
import org.springframework.expression.ExpressionParser;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Objects;

public class EvalVisitor2 extends LabeledExprBaseVisitor<String> {
    int i;
    String file;
    File myObj;
    ArrayList<String> conditionals = new ArrayList<>();
    private final int vat;

    public EvalVisitor2(int vat) {
        this.vat=vat;
        i=0;
    }

    @Override
    public String visitPrintExpr(LabeledExprParser.PrintExprContext ctx) {
        System.out.println(ctx.getText());
        return super.visitPrintExpr(ctx);
    }

    @Override
    public String visitPrintTitle(LabeledExprParser.PrintTitleContext ctx) {
        if(i==0){
            String title=ctx.getText().replaceAll(" ","");
            myObj = new File("Documents\\" + title + ".txt");
            file=title;
            i++;
        }
        return super.visitPrintTitle(ctx);
    }

    public String getFile(){
        return this.file;
    }

    @Override
    public String visitHandleSection(LabeledExprParser.HandleSectionContext ctx) {
        BufferedWriter myWriter = null;
        try {
            myWriter = new BufferedWriter(new FileWriter("Documents\\" + file + ".txt", true));
            if(ctx.id().getText().equals("1:")) {
                myWriter.write("*" + vat + "*\n");
            }
            myWriter.write("[ Section " + ctx.id().getText()+"\n");
            System.out.println(ctx.title().getText() + " " + ctx.id().getText() + " " + ctx.section_description().getText());
            if (ctx.obligatoriness().getText().equals("-----Mandatory")) {
                for (LabeledExprParser.Question_structContext question : ctx.content().question_struct()) {
                    myWriter.write("> Question " + question.id().getText());
                    answerQuestion(question, myWriter,ctx.id().getText());
                }
            } else if (ctx.obligatoriness().getText().equals("-----Optional")) {
                if(Console.readBoolean("This section is optional. Do you wish to answer it?(Y/N)")){
                    for (LabeledExprParser.Question_structContext question : ctx.content().question_struct()) {
                        myWriter.write("> Question " + question.id().getText());
                        answerQuestion(question, myWriter,ctx.id().getText());
                    }
                }else{
                    myWriter.write("No answers.");
                }
            } else{
                if(conditionals.contains(ctx.obligatoriness().cd().id(0).getText()+ctx.obligatoriness().cd().id(1).getText()+ctx.obligatoriness().cd().id(2).getText())) {
                    for (LabeledExprParser.Question_structContext question : ctx.content().question_struct()) {
                        myWriter.write("> Question " + question.id().getText());
                        answerQuestion(question, myWriter, ctx.id().getText());
                    }
                }else {
                    myWriter.write("No answers.");
                }
            }
            myWriter.write("]\n");
            myWriter.close();
        }catch (IOException e) {
            e.printStackTrace();
        }
        return super.visitHandleSection(ctx);
    }

    private void answerQuestion(LabeledExprParser.Question_structContext question, BufferedWriter myWriter, String section) throws IOException {
        System.out.println(question.getText());
        String a = question.type().repeatability().getText().split("\\)")[0];
        switch (a){
            case "(Single Choice":
                int size=question.type().repeatability().repeatable().single_choice().option().size()-1;
                String answer= readOptionLetters(question.type().repeatability().repeatable().single_choice().option(0).getText().charAt(0)-64,question.type().repeatability().repeatable().single_choice().option(size).getText().charAt(0)-64,"0");
                myWriter.write("(Single Choice)" +answer + "\n");
                checkConditional(section,question,answer);
                break;
            case "(Multiple Choice":
                int size2=question.type().repeatability().repeatable().multiple_choice().option().size()-1;
                ArrayList<String> answers = new ArrayList<>();
                String answer2="";
                myWriter.write("(Multiple Choice)");
                while (!Objects.equals(answer2, "0")) {
                    answer2 = readOptionLetters(question.type().repeatability().repeatable().multiple_choice().option(0).getText().charAt(0) - 64, question.type().repeatability().repeatable().multiple_choice().option(size2).getText().charAt(0) - 64,"0");
                    if(!answers.contains(answer2) && !Objects.equals(answer2, "0")){
                        answers.add(answer2);
                        myWriter.write(answer2);
                    }
                }
                myWriter.write("\n");
                break;
            case "(Numeric":
                myWriter.write("(Numeric)" + Console.readInteger("Answer")+"\n");
                break;
            case "(Sorting Options":
                int size3=question.type().repeatability().non_repeatable().sorting_options().option().size()-1;
                String answer3;
                ArrayList<String> answers2 = new ArrayList<>();
                myWriter.write("(Sorting Options)");
                for(int i=0;i<=size3;i++){
                    answer3 = readOptionLetters(question.type().repeatability().non_repeatable().sorting_options().option(0).getText().charAt(0) - 64, question.type().repeatability().non_repeatable().sorting_options().option(size3).getText().charAt(0) - 64,"0");
                    while(answers2.contains(answer3)) {
                        System.out.println("Option already inserted");
                        answer3 = readOptionLetters(question.type().repeatability().non_repeatable().sorting_options().option(0).getText().charAt(0) - 64, question.type().repeatability().non_repeatable().sorting_options().option(size3).getText().charAt(0) - 64,"0");
                    }
                    answers2.add(answer3);
                    myWriter.write(answer3);
                }
                myWriter.write("\n");
                break;
            case "(Scaling Options":
                int size4=question.type().repeatability().non_repeatable().scaling_options().option().size()-1;
                int size5=question.type().repeatability().non_repeatable().scaling_options().id().size()-1;
                myWriter.write("(Scaling Options) ");
                for(int i=0;i<=size4;i++){
                    System.out.println(question.type().repeatability().non_repeatable().scaling_options().option(i).getText().charAt(0)+": ");
                    myWriter.write(question.type().repeatability().non_repeatable().scaling_options().option(i).getText().charAt(0) + "-" + readOption(question.type().repeatability().non_repeatable().scaling_options().id(0).getText().charAt(0)-48,question.type().repeatability().non_repeatable().scaling_options().id(size5).getText().charAt(0)-48,0)+" ");
                }
                myWriter.write("\n");
                break;
            case "(Free Text":
                myWriter.write("(Free Text)" + Console.readLine("Answer")+"\n");
                break;
            default:
                break;

        }

    }

    private void checkConditional(String section, LabeledExprParser.Question_structContext question, String answer) {
        try {
            if (question.DEPENDENT().getText().equals("<")) {
                conditionals.add("S" + section + question.id().getText() + "Op" + answer + ",");
            }
        }catch (java.lang.NullPointerException e){
            return;
        }
    }

    public static String readOptionLetters(final int low, final int high,final String exit) {
        int option;
        String option2;
        do {
            option2 = Console.readLine("Select an option: ");
            option = (int)option2.charAt(0)-64;
            if (option2.equals(exit)) {
                break;
            }
        } while (option < low || option > high);
        return option2;
    }

    public static int readOption(final int low, final int high, final int exit) {
        int option;
        do {
            option = Console.readInteger("Select an option: ");
            if (option == exit) {
                break;
            }
        } while (option < low || option > high);
        return option;
    }
}
