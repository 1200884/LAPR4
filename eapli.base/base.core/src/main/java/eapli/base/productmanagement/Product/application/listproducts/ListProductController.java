package eapli.base.productmanagement.Product.application.listproducts;

public class ListProductController {
    ListProductService lpds = new ListProductService();
    public StringBuilder allProducts(String f1) {
        return lpds.allProducts(f1);

    }

}
