package oracle.sprinbootapps.pmsapp.controllers;

import oracle.sprinbootapps.pmsapp.dtos.CategoryCommand;
import oracle.sprinbootapps.pmsapp.dtos.CategoryQuery;
import oracle.sprinbootapps.pmsapp.services.abstractions.ServiceManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ProblemDetail;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.util.Collection;
import java.util.Optional;

@RestController
@RequestMapping(path = "/api/categories")
public class CategoryController {
    private final ServiceManager<CategoryCommand, CategoryQuery, Integer> manager;

    @Autowired
    public CategoryController(ServiceManager<CategoryCommand, CategoryQuery, Integer> manager) {
        this.manager = manager;
    }

//    private ResponseEntity<ProblemDetail> createProblemResponse(Exception e) {
//        ProblemDetail details =
//                ProblemDetail.forStatusAndDetail(
//                        HttpStatusCode.valueOf(500), e.getMessage());
//        return ResponseEntity.of(details).build();
//    }

    @GetMapping
    public ResponseEntity<Collection<CategoryQuery>> getCategories() {
        try {
            Collection<CategoryQuery> records = manager.getAll();
            return ResponseEntity.ok(records);
        } catch (Exception e) {
            //return ResponseEntity.internalServerError().build();
            ProblemDetail details =
                    ProblemDetail.forStatusAndDetail(
                            HttpStatusCode.valueOf(500), e.getMessage());
            return ResponseEntity.of(details).build();
        }
    }

    @GetMapping(path = "/{id}")
    public ResponseEntity<CategoryQuery> getCategoryById(
            @PathVariable int id) {
        try {
            CategoryQuery record = manager.get(id);
            return ResponseEntity.ok(record);
        } catch (Exception e) {
            //return ResponseEntity.internalServerError().build();
            ProblemDetail details =
                    ProblemDetail.forStatusAndDetail(
                            HttpStatus.INTERNAL_SERVER_ERROR,
                            e.getMessage());
            return ResponseEntity.of(details).build();
        }
    }

    @GetMapping(path = "/filter/{categoryName}")
    public ResponseEntity<Collection<CategoryQuery>> filterCategories(
            @PathVariable String categoryName) {
        try {
            Collection<CategoryQuery> records = manager.filter(categoryName);
            if (records == null || records.isEmpty()) {
                return ResponseEntity.of(ProblemDetail.forStatusAndDetail(
                        HttpStatus.INTERNAL_SERVER_ERROR,
                        "No record found containing " + categoryName
                )).build();
            }
            return ResponseEntity.ok(records);
        } catch (Exception e) {
            //return ResponseEntity.internalServerError().build();
            ProblemDetail details =
                    ProblemDetail.forStatusAndDetail(
                            HttpStatusCode.valueOf(500), e.getMessage());
            return ResponseEntity.of(details).build();
        }
    }

    @PostMapping
    public ResponseEntity<CategoryQuery> saveCategory(@RequestBody CategoryCommand categoryCommand) {
        try {
            CategoryQuery category = manager.add(categoryCommand);
            return ResponseEntity.created(new URI("/add")).body(category);
        } catch (Exception e) {
            return ResponseEntity.of(
                    ProblemDetail.forStatusAndDetail(HttpStatus.BAD_REQUEST, e.getMessage())
            ).build();
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<CategoryQuery> modifyCategory(
            @PathVariable int id,
            @RequestBody CategoryCommand categoryCommand) {
        try {
            CategoryQuery category = manager.update(id, categoryCommand);
            return ResponseEntity.ok(category);
        } catch (Exception e) {
            return ResponseEntity.of(ProblemDetail.forStatusAndDetail(
                    HttpStatus.INTERNAL_SERVER_ERROR,
                    e.getMessage())).build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<CategoryQuery> removeCategory(@PathVariable int id) {
        try {
            CategoryQuery category = manager.delete(id);
            return ResponseEntity.ok(category);
        } catch (Exception e) {
            return ResponseEntity.of(ProblemDetail.forStatusAndDetail(
                    HttpStatus.INTERNAL_SERVER_ERROR,
                    e.getMessage())).build();
        }
    }
}
