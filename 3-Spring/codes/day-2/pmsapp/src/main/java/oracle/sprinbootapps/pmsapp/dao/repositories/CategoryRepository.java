package oracle.sprinbootapps.pmsapp.dao.repositories;

import oracle.sprinbootapps.pmsapp.dao.entities.Category;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

//@Repository
public interface CategoryRepository extends JpaRepository<Category, Integer> {
    @Query("SELECT c FROM Category c WHERE LOWER(c.categoryName) LIKE LOWER(CONCAT('%', :name, '%'))")
    List<Category> findByCategoryNameContainingIgnoreCase(String name);
}
