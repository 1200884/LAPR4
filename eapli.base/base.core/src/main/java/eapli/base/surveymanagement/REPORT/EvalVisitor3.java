package eapli.base.surveymanagement.REPORT;
import java.util.*;

public class EvalVisitor3 extends LabeledExpr2BaseVisitor<String> {

    public EvalVisitor3() {
    }

    @Override
    public String visitHandleClients(LabeledExpr2Parser.HandleClientsContext ctx) {

        int client_size = ctx.list_of_clients().client().size();
        int question_nr = 0;
        String[][] newArray = new String[20][client_size];
        for (int i = 0; i < ctx.list_of_clients().client().size(); i++) {
            question_nr = 0;
            for (int j = 0; j < ctx.list_of_clients().client(i).list_of_sections().section().size(); j++) {
                if (!ctx.list_of_clients().client(i).list_of_sections().section(j).content().getText().equals("No answers.")) {
                    for (int k = 0; k < ctx.list_of_clients().client(i).list_of_sections().section(j).content().question_struct().size(); k++) {
                        question_nr++;
                        analyseQuestion(question_nr, i, ctx.list_of_clients().client(i).list_of_sections().section(j).content().question_struct(k), newArray);
                    }
                }

            }
        }
        createReport(newArray, client_size, question_nr);
        return super.visitHandleClients(ctx);
    }

    private void createReport(String[][] newArray, int c_size, int q) {
        for (int j = 1; j < q; j++) {
            System.out.print("Q"+j+": ");
            Map<String, Integer> map = new TreeMap<>();
            String[] answer = newArray[j][0].split("\\)");
            String type = answer[0];
            switch (type) {
                case "(Single Choice":
                    System.out.print("(Single Choice)   ");
                    for (int i = 0; i < c_size; i++) {
                        String[] answer1 = newArray[j][i].split("\\)");
                        if (map.containsKey(answer1[1])) {
                            map.put(answer1[1], map.get(answer1[1]) + 1);
                        } else {
                            map.put(answer1[1], 1);
                        }
                    }
                    for (String s : map.keySet()) {
                        float ms =map.get(s);
                        float f = (ms/c_size)*100;
                        System.out.print(s +"= " +f+ "%     ");
                    }
                    System.out.print("Others= 0%");
                    break;
                case "(Multiple Choice":
                    System.out.print("(Multiple Choice) ");
                    Map<String,Integer> map2 = new TreeMap<>();
                    for (int i = 0; i < c_size; i++) {
                        String[] answer1 = newArray[j][i].split("\\)");
                        // para conjuntos
                        if (map.containsKey(answer1[1])) {
                            map.put(answer1[1], map.get(answer1[1]) + 1);
                        } else {
                            map.put(answer1[1], 1);
                        }
                        // para indviduais
                        for (char c1 :answer1[1].toCharArray()){
                            String c = Character.toString(c1);
                            if (map2.containsKey(c)) {
                                map2.put(c, map2.get(c) + 1);
                            } else {
                                map2.put(c, 1);
                            }
                        }
                    }
                    for (String s : map.keySet()) {
                        float ms =map.get(s);
                        float f = (ms/c_size)*100;
                        System.out.print(s+"= " +f+ "%     ");
                    }
                    System.out.println("Others= 0%");
                    for (String s : map2.keySet()) {
                        float ms =map2.get(s);
                        float f = (ms/c_size)*100;
                        System.out.print(s+"= " +f+ "%     ");
                    }
                    System.out.print("Others= 0%");
                    break;
                case "(Sorting Options":
                    System.out.print("(Sorting Options)     ");
                    Map<Integer,Map<String,Integer>> super_map = new HashMap<>();
                    for(int i=0; i<c_size;i++){
                        int a=0;
                        String[] answer1 = newArray[j][i].split("\\)");
                        for (char c1: answer1[1].toCharArray()){
                            a++;
                            String c = Character.toString(c1);
                            if(super_map.containsKey(a)){
                                if (super_map.get(a).containsKey(c)){
                                    super_map.get(a).put(c,super_map.get(a).get(c)+1);
                                }else{
                                    super_map.get(a).put(c,1);
                                }
                            }else{
                                super_map.put(a,new TreeMap<>());
                                super_map.get(a).put(c, 1);
                            }
                        }
                    }
                    for (Integer a: super_map.keySet()){
                        System.out.println();
                        System.out.print("     "+ a+"º Place = ");
                        for (String s : super_map.get(a).keySet()){
                            float ms =super_map.get(a).get(s);
                            float f = (ms/c_size)*100;
                            System.out.print(s+"= " +f+ "%     ");
                        }
                    }
                    break;
                case "(Scaling Options":
                    System.out.print("(Scaling Options) by average per option:    \n");
                    for (int i=0; i<c_size; i++){
                        String[] answer1 = newArray[j][i].split("\\)");
                        String[] splited = answer1[1].split(" ");
                        for(String mini: Arrays.copyOfRange(splited,1,splited.length)){
                            String[] c= mini.split("-");

                            if(map.containsKey(c[0])){
                                map.put(c[0], map.get(c[0])+ Integer.parseInt(c[1]));
                            }else{
                                map.put(c[0], Integer.parseInt(c[1]));
                            }
                        }
                    }
                    for(String s: map.keySet()){
                        float ms = map.get(s);
                        float f= ms/c_size;
                        System.out.print(s + "= " + f +"     ");
                    }
                    break;
                case "(Numeric":
                    System.out.print("(Numeric) ");
                    int c=0;
                    for (int i=0;i<c_size;i++){
                        String[] answer1 = newArray[j][i].split("\\)");
                        c= c+Integer.parseInt(answer1[1]);
                    }
                    float f= (float) c/c_size;
                    System.out.print("Average value between all answers:   "+f);
                    break;
                default:
                    System.out.println("There are no statistics to be reported on this question.");
                    break;
            }
            System.out.println();
        }
    }

    private String[][] analyseQuestion(int question_nr, int client, LabeledExpr2Parser.Question_structContext question, String[][] newArray) {
        newArray[question_nr][client] = question.type().getText();
        return newArray;
    }
}
