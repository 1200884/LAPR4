package eapli.base.ordermanagement.application;

import eapli.base.AGVmanagement.AGV.domain.AGV;
import eapli.base.AGVmanagement.AGV.domain.repository.AGVRepository;
import eapli.base.customermanagement.domain.model.Customer;
import eapli.base.customermanagement.domain.model.Shopping_Cart;
import eapli.base.customermanagement.domain.repositories.CustomerRepository;
import eapli.base.infrastructure.persistence.PersistenceContext;
import eapli.base.ordermanagement.domain.Orders;
import eapli.base.ordermanagement.domain.OrderLevel;
import eapli.base.ordermanagement.domain.Payment_Method;
import eapli.base.ordermanagement.domain.Shipment_Method;
import eapli.base.ordermanagement.repositories.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.ArrayList;
import java.util.Optional;

public class OrderServices {
    @Autowired
    CustomerRepository customer_repository = PersistenceContext.repositories().customers();
    @Autowired
    OrderRepository order_repository= PersistenceContext.repositories().Order();
    @Autowired
    AGVRepository agvRepository=PersistenceContext.repositories().AGVs();

    public Optional<Customer> findByvat(int vat) {
        return customer_repository.ofIdentity(vat);
    }

    public void createOrder(Shopping_Cart shopping_cart, Shipment_Method shipmentMethod, Payment_Method payment_method) {
        Orders order = new Orders("Rua",shopping_cart,shipmentMethod,payment_method);
        order_repository.save(order);
    }

    public boolean existsid(String id){
        return order_repository.ofIdentity(id).get().getId().equals(id);
    }

    public Orders findbyid(String id) {
        ArrayList<Orders> orders = (ArrayList<Orders>) order_repository.findAll();
        for (Orders o : orders) {
            if (o.getId().equals(id)) {
                return o;
            }
        }
        return null;
    }

    public Iterable<Orders> findDispatched() {
        ArrayList<Orders> orders = (ArrayList<Orders>) order_repository.findAll();
        ArrayList<Orders> dispatched = new ArrayList<>();
        for (Orders o : orders) {
            if (o.getOrderLevel().equals(OrderLevel.Level.DISPATCHED)) {
                dispatched.add(o);
            }
        }
        return dispatched;
    }

    public Iterable<Orders> findAssigned() {
        ArrayList<Orders> orders = (ArrayList<Orders>) order_repository.findAll();
        ArrayList<Orders> assigned = new ArrayList<>();
        for (Orders o : orders) {
            if (o.getOrderLevel().equals(OrderLevel.Level.ASSIGNED)) {
                assigned.add(o);
            }
        }
        return assigned;
    }
    //Method that returns the orders that are assigned to an AGV, and have a task time=0, this is, the agv has finished the order so its ready to send to the customer.
    public Iterable<Orders> findReadyAssigned() {
        ArrayList<Orders> orders = (ArrayList<Orders>) order_repository.findAll();
        ArrayList<AGV> agvs = (ArrayList<AGV>) agvRepository.findAll();

        ArrayList<Orders> assigned = new ArrayList<>();
        for (Orders o : orders) {
            for (AGV agv : agvs) {
                if (o.getOrderLevel().equals(OrderLevel.Level.ASSIGNED)&&agv.hasOrder(o.getId())&& agv.getStatus().getTasktime()==0) {
                    assigned.add(o);
                }
            }
        }
        return assigned;
    }

    public Iterable<Orders> findUnassigned() {
        ArrayList<Orders> orders = (ArrayList<Orders>) order_repository.findAll();
        ArrayList<Orders> unassigned = new ArrayList<>();
        for (Orders o : orders) {
            if (o.getOrderLevel().equals(OrderLevel.Level.UNASSIGNED)) {
                unassigned.add(o);
            }
        }
        return unassigned;
    }
}
