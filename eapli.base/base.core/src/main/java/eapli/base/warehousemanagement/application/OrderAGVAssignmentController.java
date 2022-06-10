
package eapli.base.warehousemanagement.application;

import eapli.base.AGVmanagement.AGV.application.AGVService;
import eapli.base.AGVmanagement.AGV.domain.AGV;
import eapli.base.AGVmanagement.AGV.domain.Status;
import eapli.base.modelmanagement.Model.domain.Model;
import eapli.base.ordermanagement.application.OrderServices;
import eapli.base.ordermanagement.domain.Orders;
import eapli.base.ordermanagement.domain.OrderLevel;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.Random;
import java.util.Set;


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

    /* public static AGV noTasks() {
         List<AGV> agvs = AGVService.getAgvs();
         AGV emptyagv = new AGV(1, "Empty", "Empty", new Model("Empty", "Empty"), new Status(2, "Empty"));
         for (AGV a : agvs) {
             if (a.getagvtasks().size() == 1) {
                 return a;
             }
         }
         return emptyagv;
     }
 */
    public static int assignTaskToAGV(String orderid) {
        AGVService agvService = new AGVService();
        OrderServices orderServices = new OrderServices();
        OrderLevel orderLevel = new OrderLevel(OrderLevel.Level.ASSIGNED);
        System.out.println("albert");
        try {
            orderServices.findbyid(orderid);
        } catch (NoSuchElementException e) {
            System.out.println("No Such Element exceção");
            return 0;
        }
        if (orderServices.findbyid(orderid) == null) {
            return 0;
        }
        System.out.println("1");
        AGV agvwithnotasks = agvwithlesstasks();
        agvService.updateAGV(agvwithnotasks);
        if (agvwithnotasks.hasOrder(orderid)) {
            return agvwithnotasks.getId();
        }
        orderServices.findbyid(orderid).setOrderLevel(orderLevel);
        orderServices.updateOrders(orderServices.findbyid(orderid));
        agvwithnotasks.addTask(orderid);
        agvService.updateAGV(agvwithnotasks);
        return agvwithnotasks.getId();
    }

    public static AGV agvwithlesstasks() {
        int numbertasks = Integer.MAX_VALUE;
        AGV lesstasks = new AGV(50, "isep", "ze", new Model("abilio", "alfred"), new Status(2, "NULL"));
        Iterable<AGV> agvs = AGVService.getAgvs();
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


    public static String getAGV(String AGV_ID) {
        int intAGV;
        try {
            intAGV = Integer.parseInt(AGV_ID);
        } catch (Exception e) {
            return "There was a problem retrieving the AGV";
        }
        for (AGV agv : AGVService.getAgvs()) {
            System.out.println(agv);
            if (agv.getId() == intAGV) {
                return agv.toString();
            }
        }
        return "There was a problem retrieving the AGV";
    }
}