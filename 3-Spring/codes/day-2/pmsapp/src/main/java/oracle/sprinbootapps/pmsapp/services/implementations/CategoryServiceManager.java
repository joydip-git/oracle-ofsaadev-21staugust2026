package oracle.sprinbootapps.pmsapp.services.implementations;

import oracle.sprinbootapps.pmsapp.dao.entities.Category;
import oracle.sprinbootapps.pmsapp.dao.repositories.CategoryRepository;
import oracle.sprinbootapps.pmsapp.dtos.CategoryCommand;
import oracle.sprinbootapps.pmsapp.dtos.CategoryQuery;
import oracle.sprinbootapps.pmsapp.services.abstractions.ServiceManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Optional;

@Service
public class CategoryServiceManager
        implements ServiceManager<CategoryCommand, CategoryQuery, Integer> {

    private final CategoryRepository repository;

    @Autowired
    public CategoryServiceManager(CategoryRepository repository) {
        this.repository = repository;
    }

    @Override
    public CategoryQuery add(CategoryCommand data) {
        Category category = mapToCategory(data);
        Category added = repository.save(category);
        return mapToCategoryQuery(added);
    }

    @Override
    public CategoryQuery delete(Integer integer) {
        Optional<Category> exists = repository.findById(integer);
        CategoryQuery categoryQuery = null;
        if (exists.isPresent()) {
            Category found = exists.get();
            categoryQuery = mapToCategoryQuery(found);
            repository.delete(found);
        }
        return categoryQuery;
    }

    @Override
    public Collection<CategoryQuery> getAll() {
        return fetch(null);
    }

    @Override
    public CategoryQuery get(Integer integer) {
        Optional<Category> exists = repository.findById(integer);
        CategoryQuery categoryQuery = null;
        if (exists.isPresent()) {
            Category found = exists.get();
            categoryQuery = mapToCategoryQuery(found);
        }
        return categoryQuery;
    }

    @Override
    public CategoryQuery update(Integer integer, CategoryCommand data) {
        var exists = repository.findById(integer);
        CategoryQuery categoryQuery = null;
        if (exists.isPresent()) {
            Category found = exists.get();
            found.setCategoryName(data.getCategoryName());

            categoryQuery = mapToCategoryQuery(found);
        }
        return categoryQuery;
    }

    @Override
    public Collection<CategoryQuery> filter(String name) {
        return fetch(name);
    }

    private CategoryQuery mapToCategoryQuery(Category category) {
        CategoryQuery categoryQuery = new CategoryQuery();
        categoryQuery.setCategoryId(category.getCategoryId());
        categoryQuery.setCategoryName(category.getCategoryName());
        return categoryQuery;
    }

    private Category mapToCategory(CategoryCommand categoryCommand) {
        Category category = new Category();
        category.setCategoryName(categoryCommand.getCategoryName());
        return category;
    }

    private Collection<CategoryQuery> fetch(String name) {
        Collection<CategoryQuery> categories;

        List<Category> filtered = name != null ?
                repository.findByCategoryNameContainingIgnoreCase(name) :
                repository.findAll();
        if (!filtered.isEmpty()) {
            categories = new ArrayList<>();
            filtered.forEach(c -> {
                CategoryQuery cq = mapToCategoryQuery(c);
                categories.add(cq);
            });
        } else {
            categories = null;
        }
        return categories;
    }
}
