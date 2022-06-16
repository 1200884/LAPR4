package eapli.base.ordermanagement.application;

import eapli.base.customermanagement.domain.model.Customer;
import eapli.base.customermanagement.domain.repositories.CustomerRepository;
import eapli.base.infrastructure.persistence.PersistenceContext;
import eapli.base.ordermanagement.domain.Orders;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.ArrayList;
import java.util.Optional;

public class ListOrdersOfCostumerController {
    OrderServices os = new OrderServices();
    @Autowired
    CustomerRepository customer_repository = PersistenceContext.repositories().customers();
    public String findOrdersByVAT(int vat) {
        Optional<Customer> c = customer_repository.ofIdentity(vat);
        Customer customer = null;
        if (c.isPresent()) {
            customer = c.get();
        }else{
            return "no";
        }
        ArrayList<Orders> io = (ArrayList<Orders>) os.findOrdersByVAT(customer);
        if (io.isEmpty()){
            return "no orders";
        }
        String sf = "";
        for(Orders o : io){
            sf+= o.getId() + "- " + o.getOrderLevel().getLevel() + "/";
        }
        return sf;
    }
}