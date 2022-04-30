package eapli.base.app.backoffice.console.Domain.Product;

import eapli.base.productmanagement.Product.application.CategoryController;
import eapli.framework.domain.repositories.ConcurrencyException;
import eapli.framework.domain.repositories.IntegrityViolationException;
import eapli.framework.io.util.Console;
import eapli.framework.presentation.console.AbstractUI;

import java.util.Scanner;

public class CategoryUI  extends AbstractUI{
    Scanner ler = new Scanner(System.in);
    private final CategoryController categoryController = new CategoryController();
    @Override
    protected boolean doShow(){
        final String description = Console.readLine("Description");

        try{
            this.categoryController.createnewcategory(description);
        }catch (final IntegrityViolationException | ConcurrencyException e){
            System.out.println("This category is already in use");
        }
        return false;
    }
    private boolean showCategory(){
        return true;
    }
    private void CreateCategory(String category){
        System.out.println("Insira nova category");
        category = ler.nextLine();
        categoryController.createnewcategory(category);

    }


    @Override
    public String headline(){return "Add Category";}
}
