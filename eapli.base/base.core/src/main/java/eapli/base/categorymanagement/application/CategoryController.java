package eapli.base.categorymanagement.application;
import eapli.base.categorymanagement.domain.Category;

import java.util.List;

public class CategoryController {

    private static CategoryService categoryService = new CategoryService();
    private static List<Category> categoryList;

    public String createnewcategory(String description){
        Category category = categoryService.createnewcategory(description);
        return category.toString();
    }

}
