package eapli.base.warehousemanagement.application;

import eapli.base.AGVmanagement.AGV.application.AGVService;
import eapli.base.AGVmanagement.AGV.domain.AGV;
import eapli.base.ordermanagement.domain.Orders;

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
