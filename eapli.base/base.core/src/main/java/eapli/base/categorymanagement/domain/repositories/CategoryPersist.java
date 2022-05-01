package eapli.base.categorymanagement.domain.repositories;

import eapli.base.categorymanagement.domain.Category;
import org.springframework.beans.factory.annotation.Autowired;

import eapli.base.infrastructure.persistence.PersistenceContext;

public class CategoryPersist {
    @Autowired
    CategoryRepository categoryRepository = PersistenceContext.repositories().category();
    public void createnewcategory(Category category){
        categoryRepository.save(category);
        System.out.println(categoryRepository.findAll());
    }

}
