package eapli.base.productmanagement.Product.application.listproducts;

public class ListProductController {
    ListProductService lps = new ListProductService();

    public StringBuilder allProducts(String f1) {
        return lps.allProducts(f1);

    }

}
