package eapli.base.app.backoffice.console.Domain.Product;

import eapli.base.productmanagement.Product.application.ProductController;

import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Scanner;

public class ProductUI {

    private static final ProductController productController = new ProductController();

    public void createProduct() {
        print("Please, for now, introduce the name of the product, the photo, the base price");
        Scanner sc = new Scanner(System.in);
        print("First the name:");
        String name = sc.nextLine();
        print("Now the photo (write down it's path):");
        String path = sc.nextLine();
        try {
            byte[] photo = getFileBytes(path);
        } catch (Exception e) {
            e.printStackTrace();
        }
        print("Now it's base price:");
        double price = sc.nextDouble();
        print("Now, from the list select a category:");
        //display the category list
        int categoryNum = sc.nextInt();
        print("Lastly, from the list select a ");
    }

    private byte[] getFileBytes(String filePath) throws Exception{
        Path path = Paths.get(filePath);
        return Files.readAllBytes(path);
    }

    private void print(String string) {
        System.out.println(string);
    }
}
