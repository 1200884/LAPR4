package eapli.base.warehousemanagement.application;

import eapli.base.AGVmanagement.AGV.application.AGVService;
import eapli.base.AGVmanagement.AGV.domain.AGV;
import eapli.base.ordermanagement.application.OrderServices;
import eapli.base.ordermanagement.domain.Orders;
import eapli.base.ordermanagement.domain.OrderLevel;

import java.util.ArrayList;

public class UpdateOrdersController {
    public static boolean updateOrderToDispatched(String orderid) {
        OrderServices orderServices = new OrderServices();
        ArrayList<Orders> orderstodispatch= (ArrayList<Orders>) orderServices.findReadyAssigned();
        AGV agvresponsible=new AGV(2,"base location","AGV responsible for ready tasks",null,null);
        for (AGV agv: AGVService.getAgvs()){
            if(agv.hasOrder(orderid)){
              agvresponsible=agv;
            }
        }
        for(Orders o:orderstodispatch){
            if(o.getId().equals(orderid)) {
                OrderLevel dispatched = new OrderLevel(OrderLevel.Level.DISPATCHED);
                o.setOrderLevel(dispatched);
                if(!(agvresponsible.getShortDescription().equals("AGV responsible for ready tasks"))){
                agvresponsible.removeTask(orderid);}
                orderServices.updateOrders(o);
                return true;
            }
        }
        return false;
    }
}
