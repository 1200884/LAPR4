package eapli.base.ordermanagement.application;

import eapli.base.customermanagement.domain.model.Customer;
import eapli.base.ordermanagement.domain.Payment_Method;
import eapli.base.ordermanagement.domain.Shipment_Method;
import eapli.base.usermanagement.domain.BaseRoles;
import eapli.framework.infrastructure.authz.application.AuthorizationService;
import eapli.framework.infrastructure.authz.application.AuthzRegistry;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Optional;

public class CreateOrderController {
    private final AuthorizationService authz = AuthzRegistry.authorizationService();
    @Autowired
    private OrderServices os = new OrderServices();

    public Optional<Customer> optionMenu(int vat) {
        authz.ensureAuthenticatedUserHasAnyOf(BaseRoles.SALES_CLERK);
        return os.findByvat(vat);
    }

    public boolean createOrder(int vat, String shipment_method, String payment_method){
        Optional<Customer> customer=optionMenu(vat);
        if(customer.isEmpty()){
            System.out.println("Customer not found");
            return false;
        }
        Shipment_Method shipmentMethod=new Shipment_Method(Shipment_Method.ShipmentMethod.valueOf(shipment_method));
        Payment_Method paymentMethod= new Payment_Method(Payment_Method.PaymentMethod.valueOf(payment_method));
        os.createOrder("rua das 5 casas porta 6",customer.get().getShopping_cart(),shipmentMethod,paymentMethod);
        customer.get().getShopping_cart().getProduct_quantities().clear();
        return true;
    }

    public String listShipmentMethods() {
        StringBuilder stringBuilder=new StringBuilder();
        for(Shipment_Method.ShipmentMethod shipmentMethod : Shipment_Method.ShipmentMethod.values()){
            stringBuilder.append(shipmentMethod +"\n");
        }
        return stringBuilder.toString();
    }

    public String listPaymentMethods() {
        StringBuilder stringBuilder=new StringBuilder();
        for(Payment_Method.PaymentMethod paymentMethod:Payment_Method.PaymentMethod.values()){
            stringBuilder.append(paymentMethod+ "\n");
        }
        return stringBuilder.toString();
    }
}
