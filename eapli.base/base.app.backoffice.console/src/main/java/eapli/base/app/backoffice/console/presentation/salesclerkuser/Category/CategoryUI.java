package eapli.base.app.backoffice.console.presentation.salesclerkuser.Category;

import eapli.base.categorymanagement.application.CategoryController;
import eapli.base.categorymanagement.domain.Category;
import eapli.base.categorymanagement.domain.repositories.CategoryPersist;
import eapli.framework.domain.repositories.ConcurrencyException;
import eapli.framework.domain.repositories.IntegrityViolationException;
import eapli.framework.io.util.Console;
import eapli.framework.presentation.console.AbstractUI;
import org.hibernate.engine.jdbc.spi.SqlExceptionHelper;

import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;

public class CategoryUI  extends AbstractUI{
    private final CategoryController categoryController = new CategoryController();
    @Override
    protected boolean doShow(){
         String description = Console.readLine("Description");
        while(!this.categoryController.createnewcategory(description)){

            description = Console.readLine("\nDescription: ");
        }
        System.out.println("Here is the created category");
        System.out.println(description);
        return true;

    }
    @Override
    public String headline(){return "Add Category";}
}

