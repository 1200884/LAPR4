package eapli.base.ordermanagement.application;

import eapli.base.customermanagement.domain.model.Customer;
import eapli.base.usermanagement.domain.BaseRoles;
import eapli.framework.infrastructure.authz.application.AuthorizationService;
import eapli.framework.infrastructure.authz.application.AuthzRegistry;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Optional;

public class CreateOrderController {
    private final AuthorizationService authz = AuthzRegistry.authorizationService();
    @Autowired
    private OrderServices os;

    public Optional<Customer> optionMenu(int customer) {
        authz.ensureAuthenticatedUserHasAnyOf(BaseRoles.SALES_CLERK);
        return os.findByvat(customer);
    }

    public boolean createOrder(int vat){
        Optional<Customer> customer=optionMenu(vat);
        if(customer.isEmpty()){
            System.out.println("Customer not found");
            return false;
        }
        os.createOrder(optionMenu(vat).get().getShopping_cart());
        optionMenu(vat).get().getShopping_cart().getProduct_quantities().clear();
        return true;
    }
}
