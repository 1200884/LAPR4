package eapli.base.productmanagement.Product.application;
import eapli.base.productmanagement.Product.domain.repositories.CategoryPersist;
import eapli.base.productmanagement.Product.domain.Category;

public class CategoryController {

    public void createnewcategory(String description){
        CategoryPersist categoryPersist = new CategoryPersist();
        Category category = new Category(description);
        category.setDescription(description);
        categoryPersist.createcategorypersist(category);
    }
}
