package oracle.sprinbootapps.pmsapp.controllers;

import oracle.sprinbootapps.pmsapp.dtos.CategoryCommand;
import oracle.sprinbootapps.pmsapp.dtos.CategoryQuery;
import oracle.sprinbootapps.pmsapp.services.abstractions.ServiceManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collection;


@RestController
public class CategoryController {
    private final ServiceManager<CategoryCommand, CategoryQuery, Integer> manager;

    @Autowired
    public CategoryController(ServiceManager<CategoryCommand, CategoryQuery, Integer> manager) {
        this.manager = manager;
    }

    @GetMapping(path = "/all")
    public Collection<CategoryQuery> getCategories() {
        return manager.getAll();
    }
}
