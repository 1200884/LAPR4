package eapli.base.warehousemanagement.application;

import eapli.base.AGVmanagement.AGV.application.AGVService;
import eapli.base.AGVmanagement.AGV.domain.AGV;
import eapli.base.AGVmanagement.AGV.domain.Status;
import eapli.base.modelmanagement.Model.domain.Model;
import eapli.base.ordermanagement.application.OrderServices;
import eapli.base.ordermanagement.domain.Order;
import eapli.base.ordermanagement.domain.OrderLevel;
import eapli.base.warehousemanagement.Domain.AGVDocks;

import java.util.List;
import java.util.Random;


public class OrderAGVAssignmentController {

    public static boolean validateAnswer(String answer) {
        return answer.equals("1") || answer.equals("2");
    }

    public static boolean isValidId(String answer) {

        return Order.isValidId(answer);
    }

    public static boolean existsOrderId(String answer) {
        return Order.existsId(answer);
    }

    public static AGV notasks() {
        List<AGV> agvs = AGVService.getAgvs();
        AGV emptyagv = new AGV(1, new AGVDocks(0L, 0L, 0L, 0L, 0L, 0L, 0L, "Empty"), "Empty", new Model("Empty", "Empty"), new Status(2, "Empty", 0));
        for (AGV a : agvs) {
            if (!(a.hastasks())) {
                return a;
            }
        }
        return emptyagv;
    }

    public static String assigntasktoaagv(String orderid) {
        OrderServices orderServices=new OrderServices();
        //If there isn't any AGV available (0 tasks), the order will be set to the AGV that has less tasks
        if (notasks().getShortDescription().equals("Empty")) {
            AGV agvwithlesstasks = agvwithlesstasks();
            agvwithlesstasks.addTask(orderid, randomizetasktime());
           orderServices.findbyid(orderid).setOrderLevel(new OrderLevel(OrderLevel.Level.ASSIGNED));
            return agvwithlesstasks.toString();
        //Otherwise, the AGV that will be responsible for the order will be one that has 0 tasks.
        } else {
            AGV agvwithnotasks = notasks();
            agvwithnotasks.addTask(orderid, randomizetasktime());
            orderServices.findbyid(orderid).setOrderLevel(new OrderLevel(OrderLevel.Level.ASSIGNED));
            return agvwithnotasks.toString();
        }

    }

    public static String assigntaskimmediatlytoagv(String orderid) {
        OrderServices orderServices=new OrderServices();
        if (notasks().getShortDescription().equals("Empty")) {
            AGV agvwithlesstasks = agvwithlesstasks();
            agvwithlesstasks.addTask(orderid, randomizetasktime());
            orderServices.findbyid(orderid).setOrderLevel(new OrderLevel(OrderLevel.Level.ASSIGNED));
            return agvwithlesstasks.toString();
        }
        else return "Null";
    }

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
