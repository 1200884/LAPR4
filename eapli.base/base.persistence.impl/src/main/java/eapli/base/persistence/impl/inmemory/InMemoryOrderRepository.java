package eapli.base.persistence.impl.inmemory;

import eapli.base.ordermanagement.domain.Orders;
import eapli.base.ordermanagement.repositories.OrderRepository;
import eapli.base.productmanagement.Product.domain.Product;
import eapli.framework.infrastructure.repositories.impl.inmemory.InMemoryDomainRepository;

import java.util.ArrayList;
import java.util.Optional;

public class InMemoryOrderRepository extends InMemoryDomainRepository<Orders, String> implements OrderRepository {
    static {
        InMemoryInitializer.init();
    }

    @Override
    public Iterable<Orders> findAll() {
        return super.findAll();
    }

    @Override
    public Iterable<Orders> findOrdersByShoppingCart(int shopping_cart) {
        ArrayList<Orders> al = new ArrayList<>();
        for(Orders o : findAll()){
            if (o.getShopping_cart().getID().equals(shopping_cart)){
                al.add(o);
            }
        }
        return al;    }


}
