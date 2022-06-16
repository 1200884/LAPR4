package eapli.base.persistence.impl.jpa;

import eapli.base.Application;
import eapli.base.ordermanagement.domain.Orders;
import eapli.base.ordermanagement.repositories.OrderRepository;
import eapli.base.productmanagement.Product.domain.Product;
import eapli.framework.domain.repositories.TransactionalContext;
import eapli.framework.infrastructure.repositories.impl.jpa.JpaAutoTxRepository;

import javax.persistence.TypedQuery;

public class JpaOrderRepository extends JpaAutoTxRepository<Orders, String, String> implements OrderRepository {
    public JpaOrderRepository(final TransactionalContext autoTx) {
        super(autoTx, "id");
    }

    public JpaOrderRepository(final String puname) {
        super(puname, Application.settings().getExtendedPersistenceProperties(),
                "id");
    }

    @Override
    public Iterable<Orders> findOrdersByShoppingCart(int shopping_cart) {
        final TypedQuery<Orders> query = entityManager().createQuery("SELECT o1 FROM Orders o1 WHERE o1.shopping_cart.shoppingCart_ID = :sc", Orders.class);
        query.setParameter("sc", shopping_cart);
        return query.getResultList();
    }
}
