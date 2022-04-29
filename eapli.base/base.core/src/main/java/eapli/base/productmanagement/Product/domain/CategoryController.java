package eapli.base.productmanagement.Product.domain;
import eapli.base.productmanagement.Product.domain.CategoryPersist;

public class CategoryController {

    public void createnewcategory(int category_id, String description){
        CategoryPersist categoryPersist = new CategoryPersist();
        Category category = new Category(category_id, description);
        category.setDescription(description);
        categoryPersist.createcategorypersist(category);
    }
}
