package eapli.base.warehousemanagement.application;

import eapli.base.AGVmanagement.AGV.application.AGVService;
import eapli.base.AGVmanagement.AGV.domain.AGV;
import eapli.base.ordermanagement.application.OrderServices;
import eapli.base.ordermanagement.domain.Orders;
import eapli.base.ordermanagement.domain.OrderLevel;

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
    public static void assignTaskToAGV(AGV agv, String orderid) {
        AGVService agvService = new AGVService();
        OrderServices orderServices = new OrderServices();
        OrderLevel orderLevel = new OrderLevel(OrderLevel.Level.ASSIGNED);
        try {
            orderServices.findbyid(orderid);
        } catch (Exception e) {
            return;
        }
        if (orderServices.findbyid(orderid) == null) {
            return;
        }
        orderServices.findbyid(orderid).setOrderLevel(orderLevel);
        orderServices.updateOrders(orderServices.findbyid(orderid));
        agv.addTask(orderid);
        agvService.updateAGV(agv);
        System.out.println("--------------------------------------------------------------------------------------");
        System.out.println(agv.toString());
        System.out.println("--------------------------------------------------------------------------------------");
        System.out.println(AGVService.getAgvs());
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
            if (agv.getId() == intAGV) {
                return agv.toString();
            }
        }
        return "There was a problem retrieving the AGV";
    }
}
