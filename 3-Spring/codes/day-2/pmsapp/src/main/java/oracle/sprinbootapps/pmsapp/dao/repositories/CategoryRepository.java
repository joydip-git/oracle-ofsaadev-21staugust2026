package oracle.sprinbootapps.pmsapp.dao.repositories;

import oracle.sprinbootapps.pmsapp.dao.entities.Category;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

//@Repository
public interface CategoryRepository extends JpaRepository<Category, Integer> {
    List<Category> searchByCategoryName(String categoryName);
}
