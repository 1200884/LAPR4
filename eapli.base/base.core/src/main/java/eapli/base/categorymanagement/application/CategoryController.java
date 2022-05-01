package eapli.base.categorymanagement.application;
import eapli.base.categorymanagement.domain.Category;
import org.hibernate.engine.jdbc.spi.SqlExceptionHelper;

import java.util.List;

public class CategoryController {

    private static CategoryService categoryService = new CategoryService();

    public boolean createnewcategory(String description){
        try{
            Category category = categoryService.createnewcategory(description);
            return true;
        }catch (Exception a){
            System.out.println("This category is already in use");
        }
        return false;
    }

}
