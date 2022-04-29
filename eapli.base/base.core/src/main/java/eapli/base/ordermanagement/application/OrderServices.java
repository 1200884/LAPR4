package eapli.base.ordermanagement.application;

import eapli.base.customermanagement.domain.model.Customer;
import eapli.base.customermanagement.domain.model.Shopping_Cart;
import eapli.base.customermanagement.domain.repositories.CustomerRepository;
import eapli.base.ordermanagement.repositories.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Optional;

public class OrderServices {
    @Autowired
    CustomerRepository customer_repository;
    @Autowired
    OrderRepository order_repository;
    public Optional<Customer> findByvat(int customer){
        return customer_repository.findByVat(customer);
    }

    public void createOrder(Shopping_Cart shopping_cart) {

    }
}
