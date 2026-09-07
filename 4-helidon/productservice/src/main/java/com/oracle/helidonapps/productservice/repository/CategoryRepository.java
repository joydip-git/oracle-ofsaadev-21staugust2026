package com.oracle.helidonapps.productservice.repository;

import com.oracle.helidonapps.productservice.entities.Category;
import jakarta.enterprise.context.Dependent;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.TypedQuery;
import jakarta.transaction.Transactional;

import java.util.Collection;
import java.util.List;

@Dependent
public class CategoryRepository implements RepositoryContract<Category, Integer> {

    @PersistenceContext(name = "FreePersistenceUnit")
    EntityManager manager;

    @Override
    public Collection<Category> getAll() {
        TypedQuery<Category> query =
                manager.createNamedQuery("getCategories", Category.class);
        return query.getResultList();
    }

    @Override
    public Category get(Integer id) {
        TypedQuery<Category> query =
                manager.createNamedQuery("getCategoryById", Category.class);
        query.setParameter("id", id);
        return query.getSingleResult();
    }

    @Transactional
    @Override
    public Category add(Category data) {
        manager.persist(data);
        return data;
    }

    @Transactional
    @Override
    public Category update(Integer id, Category data) {
        Category found = manager.find(Category.class, id);
        if (found != null) {
            found.setCategoryName(data.getCategoryName());
            return manager.merge(found);
        } else
            return null;
    }

    @Transactional
    @Override
    public Category delete(Integer id) {
        Category found = manager.find(Category.class, id);
        Category copy = new Category(found.getCategoryId(), found.getCategoryName());
        if (found != null) {
            manager.remove(found);
            return copy;
        } else
            return null;
    }
}
