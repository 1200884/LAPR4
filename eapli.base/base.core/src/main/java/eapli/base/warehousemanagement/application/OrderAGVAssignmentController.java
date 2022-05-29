package eapli.base.warehousemanagement.application;

import eapli.base.AGVmanagement.AGV.application.AGVService;
import eapli.base.AGVmanagement.AGV.domain.AGV;
import eapli.base.AGVmanagement.AGV.domain.Status;
import eapli.base.modelmanagement.Model.domain.Model;
import eapli.base.ordermanagement.application.OrderServices;
import eapli.base.ordermanagement.domain.Orders;
import eapli.base.ordermanagement.domain.OrderLevel;
import groovy.json.JsonToken;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.Random;


public class OrderAGVAssignmentController {

    public static boolean validateAnswer(String answer) {
        return answer.equals("1") || answer.equals("2");
    }

    public static boolean isValidId(String answer) {

        return Orders.isValidId(answer);
    }

    public static boolean existsOrderId(String answer) {
        return Orders.existsId(answer);
    }

    public static AGV notasks() {
        List<AGV> agvs = AGVService.getAgvs();
        AGV emptyagv = new AGV(1, "Empty", "Empty", new Model("Empty", "Empty"), new Status(2, "Empty"));
        for (AGV a : agvs) {
            if (a.getagvtasks().size() == 1) {
                return a;
            }
        }
        return emptyagv;
    }

    public static String assigntasktoaagv(String orderid) {
        OrderServices orderServices = new OrderServices();
        OrderLevel orderLevel = new OrderLevel(OrderLevel.Level.ASSIGNED);
        try{
            orderServices.findbyid(orderid);
        }catch (Exception e){
            return "That order doesn't exist in our database";
        }
        System.out.println("juro joca");
        if(orderServices.findbyid(orderid) == null){
            return "That order doesn't exist in our database";
        }
        System.out.println("xabalo lindo");
            if (orderServices.findbyid(orderid).getOrderLevel().getLevel().equals(OrderLevel.Level.UNASSIGNED)) {
                //If there isn't any AGV available (0 tasks), the order will be set to the AGV that has less tasks
                if (notasks().getShortDescription().equals("Empty")) {
                    AGV agvwithlesstasks = agvwithlesstasks();
                    if (agvwithlesstasks.hasOrder(orderid)) {
                        for (AGV agv : AGVService.getAgvs()) {
                            if (!agv.equals(agvwithlesstasks)) {
                                agvwithlesstasks = agv;
                                break;
                            }
                        }
                    }
                    agvwithlesstasks.addTask(orderid);
                    System.out.println("Order certa" + orderServices.findbyid(orderid).getId());
                    System.out.println("Order level before" + orderServices.findbyid(orderid).getOrderLevel());
                    orderServices.findbyid(orderid).setOrderLevel(orderLevel);
                    orderServices.updateOrders(orderServices.findbyid(orderid));
                    System.out.println("Order level after" + orderServices.findbyid(orderid).getOrderLevel());
                    return agvwithlesstasks.toString();
                    //Otherwise, the AGV that will be responsible for the order will be one that has 0 tasks.
                } else {
                    AGV agvwithnotasks = notasks();
                    if (agvwithnotasks.hasOrder(orderid)) {
                        for (AGV agv : AGVService.getAgvs()) {
                            if (!agv.equals(agvwithnotasks)) {
                                agvwithnotasks = agv;
                                break;
                            }
                        }
                    }
                    agvwithnotasks.addTask(orderid);
                    System.out.println("Order level before" + orderServices.findbyid(orderid).getOrderLevel());
                    orderServices.findbyid(orderid).setOrderLevel(orderLevel);
                    orderServices.updateOrders(orderServices.findbyid(orderid));
                    System.out.println("Order level after" + orderServices.findbyid(orderid).getOrderLevel());
                    return agvwithnotasks.toString();
                }
            } else {
                return "It is impossible to assign your order as it already is in a hihgher stage";
            }
        }

  /*  public static String assigntaskimmediatlytoagv(String orderid) {
        OrderServices orderServices = new OrderServices();
        if (orderServices.findbyid(orderid).getOrderLevel().getLevel().equals(OrderLevel.Level.UNASSIGNED)) {
            if (!(notasks().getShortDescription().equals("Empty"))) {
                AGV agvwithlesstasks = notasks();
                agvwithlesstasks.addTask(orderid);
                orderServices.findbyid(orderid).setOrderLevel(new OrderLevel(OrderLevel.Level.ASSIGNED));
                orderServices.updateOrders(orderServices.findbyid(orderid));
                return agvwithlesstasks.toString();
            } else return "Null";
        }
        else{
        return "The order you are trying to assign is in a more advanced stage.1";}
    }*/
    public static AGV agvwithlesstasks() {
        int numbertasks = Integer.MAX_VALUE;
        AGV lesstasks = null;
        List<AGV> agvs = AGVService.getAgvs();
        for (AGV a : agvs) {
            if (numbertasks > a.numberoftasks()) {
                numbertasks = a.numberoftasks();
                lesstasks = a;
            }
        }
        return lesstasks;
    }

    public static int randomizetasktime() {
        Random rand = new Random(); //instance of random class
        int upperbound = 5;
        //generate random values from 0-5 to simulate the time that the agv will spend doing the task
        return rand.nextInt(upperbound);
    }

}
