package eapli.base.infrastructure.bootstrapers;

import eapli.base.customermanagement.application.CustomerPersist;
import eapli.base.customermanagement.domain.model.Customer;
import eapli.base.customermanagement.domain.model.Shopping_Cart;
import eapli.base.ordermanagement.application.OrderServices;
import eapli.base.ordermanagement.domain.Orders;
import eapli.base.ordermanagement.domain.OrderLevel;
import eapli.base.ordermanagement.domain.Orders;
import eapli.base.ordermanagement.domain.Payment_Method;
import eapli.base.ordermanagement.domain.Shipment_Method;
import eapli.base.surveymanagement.domain.Questionnaire;
import eapli.framework.domain.repositories.ConcurrencyException;
import eapli.framework.domain.repositories.IntegrityViolationException;

public class OrderBootstrapperBase {
    OrderServices orderServices=new OrderServices();
    CustomerPersist customerPersist=new CustomerPersist();
    protected Orders registerOrder(String address, Shopping_Cart shopping_cart, Shipment_Method shipmentMethod, Payment_Method payment_method) {
        Orders order=null;
        try {
            order= orderServices.createOrder(address,shopping_cart,shipmentMethod,payment_method);
        } catch (final IntegrityViolationException | ConcurrencyException e) {
            order = null;
        }
        return order;
    }
    protected void registerCustomer(String name,int vat,int number,String email){
        Customer customer=null;
        try {
            customer=new Customer(name,vat,number,email);
            customerPersist.createCustomerPersist(customer);
        } catch (final IntegrityViolationException | ConcurrencyException e) {
            customer = null;
        }
    }
}