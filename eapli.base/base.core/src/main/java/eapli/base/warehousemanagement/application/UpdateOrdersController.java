package eapli.base.warehousemanagement.application;

import eapli.base.AGVmanagement.AGV.application.AGVService;
import eapli.base.AGVmanagement.AGV.domain.AGV;
import eapli.base.AGVmanagement.AGV.domain.repository.AGVPersist;
import eapli.base.AGVmanagement.AGV.domain.repository.AGVRepository;
import eapli.base.ordermanagement.application.OrderServices;
import eapli.base.ordermanagement.domain.Order;
import eapli.base.ordermanagement.domain.OrderLevel;
import eapli.base.warehousemanagement.Domain.AGVDocks;

import java.util.ArrayList;

public class UpdateOrdersController {
    public static boolean updateOrderToDispatched(String orderid) {
        OrderServices orderServices = new OrderServices();

        ArrayList<Order> orderstodispatch= (ArrayList<Order>) orderServices.findReadyAssigned();
        AGV agvresponsible=new AGV(2,new AGVDocks(0L, 0L, 0L, 0L, 0L, 0L, 0L, "Empty"),"AGV responsible for ready tasks",null,null);
        for (AGV agv: AGVService.getAgvs()){
            if(agv.hasOrder(orderid)){
              agvresponsible=agv;
            }
        }
        for(Order o:orderstodispatch){
            if(o.getId().equals(orderid)) {
                OrderLevel dispatched = new OrderLevel(OrderLevel.Level.DISPATCHED);
                o.setOrderLevel(dispatched);
                if(!(agvresponsible.getShortDescription().equals("AGV responsible for ready tasks"))){
                agvresponsible.removeTask(orderid);}
                return true;
            }
        }
        return false;
    }
}
