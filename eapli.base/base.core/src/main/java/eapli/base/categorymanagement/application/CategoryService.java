package eapli.base.categorymanagement.application;
import eapli.base.categorymanagement.domain.Category;
import eapli.base.categorymanagement.domain.repositories.CategoryPersist;
import org.springframework.stereotype.Component;

@Component
public class CategoryService {
    CategoryPersist categoryPersist = new CategoryPersist();

    public Category createnewcategory(String description){
            Category category = new Category(description);
            categoryPersist.createnewcategory(category);
            return category;
    }


}
