package eapli.base.warehousemanagement.application;

import eapli.base.ordermanagement.domain.Order;
import eapli.base.ordermanagement.domain.Shipment_Method;


public class OrderAGVAssignmentController {

    public static boolean validateAnswer(String answer){
        return answer.equals("1") || answer.equals("2");
    }
    public static boolean isValidId(String answer){

        return Order.isValidId(answer);
    }
    public static boolean existsOrderId(String answer){
        //Perguntar ao gus se se poe no order services
        return true;
    }
}
