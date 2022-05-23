package eapli.base.ordermanagement.application;

import eapli.base.AGVmanagement.AGV.domain.AGV;
import eapli.base.AGVmanagement.AGV.domain.repository.AGVRepository;
import eapli.base.customermanagement.domain.model.Customer;
import eapli.base.customermanagement.domain.model.Shopping_Cart;
import eapli.base.customermanagement.domain.repositories.CustomerRepository;
import eapli.base.infrastructure.persistence.PersistenceContext;
import eapli.base.ordermanagement.domain.Order;
import eapli.base.ordermanagement.domain.OrderLevel;
import eapli.base.ordermanagement.repositories.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.ArrayList;
import java.util.Optional;

public class OrderServices {
    @Autowired
    CustomerRepository customer_repository = PersistenceContext.repositories().customers();
    @Autowired
    OrderRepository order_repository;
    @Autowired
    AGVRepository agvRepository;

    public Optional<Customer> findByvat(int vat) {
        return customer_repository.ofIdentity(vat);
    }

    public void createOrder(Shopping_Cart shopping_cart) {

    }

    public boolean existsid(String id) {
        return order_repository.ofIdentity(id).equals(id);
    }

    public Order findbyid(String id) {
        ArrayList<Order> orders = (ArrayList<Order>) order_repository.findAll();
        for (Order o : orders) {
            if (o.getId().equals(id)) {
                return o;
            }
        }
        return null;
    }

    public Iterable<Order> findDispatched() {
        ArrayList<Order> orders = (ArrayList<Order>) order_repository.findAll();
        ArrayList<Order> dispatched = new ArrayList<>();
        for (Order o : orders) {
            if (o.getOrderLevel().equals(OrderLevel.Level.DISPATCHED)) {
                dispatched.add(o);
            }
        }
        return dispatched;
    }

    public Iterable<Order> findAssigned() {
        ArrayList<Order> orders = (ArrayList<Order>) order_repository.findAll();
        ArrayList<Order> assigned = new ArrayList<>();
        for (Order o : orders) {
            if (o.getOrderLevel().equals(OrderLevel.Level.ASSIGNED)) {
                assigned.add(o);
            }
        }
        return assigned;
    }

    public Iterable<Order> findReadyAssigned() {
        ArrayList<Order> orders = (ArrayList<Order>) order_repository.findAll();
        ArrayList<AGV> agvs = (ArrayList<AGV>) agvRepository.findAll();

        ArrayList<Order> assigned = new ArrayList<>();
        for (Order o : orders) {
            for (AGV agv : agvs) {
                if (o.getOrderLevel().equals(OrderLevel.Level.ASSIGNED)&&agv.hasOrder(o.getId())&& agv.getStatus().getTasktime()==0) {
                    assigned.add(o);
                }
            }
        }
        return assigned;
    }

    public Iterable<Order> findUnassigned() {
        ArrayList<Order> orders = (ArrayList<Order>) order_repository.findAll();
        ArrayList<Order> unassigned = new ArrayList<>();
        for (Order o : orders) {
            if (o.getOrderLevel().equals(OrderLevel.Level.UNASSIGNED)) {
                unassigned.add(o);
            }
        }
        return unassigned;
    }
}
