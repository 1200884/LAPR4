package eapli.base.warehousemanagement.application;

import eapli.base.AGVmanagement.AGV.application.AGVService;
import eapli.base.AGVmanagement.AGV.domain.AGV;
import eapli.base.AGVmanagement.AGV.domain.Status;
import eapli.base.modelmanagement.Model.domain.Model;
import eapli.base.ordermanagement.application.OrderServices;
import eapli.base.ordermanagement.domain.Orders;
import eapli.base.ordermanagement.domain.OrderLevel;

import java.util.List;
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

    public static AGV noTasks() {
        List<AGV> agvs = AGVService.getAgvs();
        AGV emptyagv = new AGV(1, "Empty", "Empty", new Model("Empty", "Empty"), new Status(2, "Empty"));
        for (AGV a : agvs) {
            if (a.getagvtasks().size() == 1) {
                return a;
            }
        }
        return emptyagv;
    }

    public static int assignTaskToAGV(String orderid) {
        AGVService agvService=new AGVService();
        OrderServices orderServices = new OrderServices();
        OrderLevel orderLevel = new OrderLevel(OrderLevel.Level.ASSIGNED);
        try {
            orderServices.findbyid(orderid);
        } catch (Exception e) {
            return 0;
        }
        if (orderServices.findbyid(orderid) == null) {
            return 0;
        }
        if (orderServices.findbyid(orderid).getOrderLevel().getLevel().equals(OrderLevel.Level.UNASSIGNED)) {
            //If there isn't any AGV available (0 tasks), the order will be set to the AGV that has less tasks
            if (noTasks().getShortDescription().equals("Empty")) {
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
                orderServices.findbyid(orderid).setOrderLevel(orderLevel);
                orderServices.updateOrders(orderServices.findbyid(orderid));
                System.out.println("agvId " + agvwithlesstasks.getId());
                System.out.println(agvwithlesstasks.getStatus().gettasks());
                agvService.updateAGV(agvwithlesstasks);
                return agvwithlesstasks.getId();
                //Otherwise, the AGV that will be responsible for the order will be one that has 0 tasks.
            } else {
                AGV agvwithnotasks = noTasks();
                if (agvwithnotasks.hasOrder(orderid)) {
                    for (AGV agv : AGVService.getAgvs()) {
                        System.out.println(agv.getStatus().getAvailability() + " availability");
                        if (!agv.equals(agvwithnotasks)) {
                            agvwithnotasks = agv;
                            break;
                        }
                    }
                }
                agvwithnotasks.addTask(orderid);
                orderServices.findbyid(orderid).setOrderLevel(orderLevel);
                orderServices.updateOrders(orderServices.findbyid(orderid));
                System.out.println("agvId2 " + agvwithnotasks.getId());
                System.out.println(agvwithnotasks.getStatus().gettasks());
                agvService.updateAGV(agvwithnotasks);
                return agvwithnotasks.getId();
            }
        } else {
            return 0;
        }
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


    public static String getAGV(String AGV_ID) {
        int intAGV;
        try {
            intAGV = Integer.parseInt(AGV_ID);
        }catch (Exception e) {
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
