package eapli.base.app.backoffice.console.presentation.salesclerkuser;

import eapli.base.productmanagement.Product.application.ProductController;
import eapli.framework.io.util.Console;
import eapli.framework.presentation.console.AbstractUI;

import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.concurrent.TimeUnit;

public class AddProductUI extends AbstractUI{

    private static final ProductController productController = new ProductController();

    @Override
    protected boolean doShow() {
        print("Please, for now, introduce the name of the product, the photo, the base price");
        String name = Console.readLine("First the name:");
        String path = Console.readLine("Now the photo (write down it's path):");
        byte[] photo = new byte[0];
        try {
            photo = getFileBytes(path);
        } catch (Exception e) {
            e.printStackTrace();
        }
        String shortDescription = Console.readLine("Insert a small description of the product");
        String longDescription = Console.readLine("Now insert a long description for the product");
        double price = Console.readDouble("Now it's base price:");
        print(productController.findCategories());
        int categoryNum = Console.readInteger("Now, from the list select the product's category:");
        while (!productController.verifyCategory(categoryNum)) {
            categoryNum = Console.readInteger("The number inserted did not match any of the categories, please insert a new one:");
        }
        print(productController.findBrand());
        int brandNum = Console.readInteger("Lastly, from the list select the product's brand:");
        while (!productController.verifyBrand(brandNum)) {
            brandNum = Console.readInteger("The number inserted did not match any of the brands, please insert a new one:");
        }
        print("Here is your created product:");
        print(productController.createProduct(name, photo, price, shortDescription, longDescription, categoryNum, brandNum));
        return false;
    }

    private byte[] getFileBytes(String filePath) throws InterruptedException {
        try {
            Path path = Paths.get(filePath);
            return Files.readAllBytes(path);
        }catch (Exception e) {
            print("There was a problem with the path and the photo could not be retrieved");
            TimeUnit.SECONDS.sleep(1);
        }
        return new byte[0];
    }

    private void print(String string) {
        System.out.println(string);
    }

    @Override
    public String headline() {
        return "Add Product";
    }
}
