package eapli.base.productmanagement.Product.application;

import eapli.base.customermanagement.domain.model.Customer;
import eapli.base.customermanagement.domain.model.Product_Quantities;
import eapli.base.customermanagement.domain.repositories.CustomerRepository;
import eapli.base.infrastructure.persistence.PersistenceContext;
import eapli.base.productmanagement.Product.domain.Product;
import eapli.base.productmanagement.Product.domain.repositories.ProductRepository;
import eapli.framework.application.UseCaseController;

import java.util.Optional;

@UseCaseController
public class AddProductToCartController {

    private static ProductRepository productRepository = PersistenceContext.repositories().products();
    CustomerRepository customer_repository= PersistenceContext.repositories().customers();
    Customer customer;
    public Product validateNameOfProduct(String name) {
        for(Product product:productRepository.findAll()){
            if(product.getName().equals(name)){
                return product;
            }
        }
        return null;
    }

    public boolean addProduct(String name, int quantity) {
        Product product = validateNameOfProduct(name);
        if(product==null){
            return false;
        }
        boolean flag=false;
        for(Product_Quantities product_quantities : this.customer.getShopping_cart().getProduct_quantities()){
            if(product_quantities.getProduct().equals(product)){
                product_quantities.addQuantity(quantity);
                flag=true;
            }
        }
        if(!flag) {
            this.customer.getShopping_cart().addToCart(new Product_Quantities(product, quantity));
        }
        return true;
    }


    public boolean validateCustomer(int vat) {
        Optional<Customer> customer=customer_repository.ofIdentity(vat);
        if(customer.isPresent()){
            this.customer=customer.get();
            return true;
        }
        return false;
    }

    public boolean saveCart() {
        customer_repository.save(this.customer);
        System.out.println(customer_repository.ofIdentity(this.customer.getVat()).get().getShopping_cart());
        return true;
    }
}
