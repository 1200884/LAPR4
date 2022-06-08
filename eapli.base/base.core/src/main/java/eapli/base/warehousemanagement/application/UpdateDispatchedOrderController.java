package eapli.base.warehousemanagement.application;

import eapli.base.ordermanagement.application.OrderServices;
import eapli.base.ordermanagement.domain.OrderLevel;

public class UpdateDispatchedOrderController {
    OrderServices orderServices = new OrderServices();

    public boolean existsOrder(String orderid) {
        return orderServices.findbyid(orderid).getOrderLevel().getLevel().equals(OrderLevel.Level.DISPATCHED);
    }

    public boolean updateOrderToDelivered(String orderid) {
        OrderLevel delivered = new OrderLevel(OrderLevel.Level.DELIVERED);
        orderServices.findbyid(orderid).setOrderLevel(delivered);
        orderServices.updateOrders(orderServices.findbyid(orderid));
        return true;
    }
}
