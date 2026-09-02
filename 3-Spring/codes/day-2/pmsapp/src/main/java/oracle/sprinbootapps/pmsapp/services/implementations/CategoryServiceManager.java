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
        Category category = new Category();
        category.setCategoryName(data.getCategoryName());

        Category added = repository.save(category);

        CategoryQuery query = new CategoryQuery();
        query.setCategoryId(added.getCategoryId());
        query.setCategoryName(added.getCategoryName());

        return query;
    }

    @Override
    public CategoryQuery delete(Integer integer) {
        return null;
    }

    @Override
    public Collection<CategoryQuery> getAll() {
        Collection<CategoryQuery> categories;

        List<Category> all = repository.findAll();
        if (!all.isEmpty()) {
            categories = new ArrayList<>();
            all.forEach(c -> {
                CategoryQuery cq = new CategoryQuery();
                cq.setCategoryId(c.getCategoryId());
                cq.setCategoryName(c.getCategoryName());
                categories.add(cq);
            });
        } else {
            categories = null;
        }
        return  categories;
    }

    @Override
    public CategoryQuery get(Integer integer) {
        return null;
    }

    @Override
    public CategoryQuery update(Integer integer, CategoryCommand data) {
        return null;
    }
}
