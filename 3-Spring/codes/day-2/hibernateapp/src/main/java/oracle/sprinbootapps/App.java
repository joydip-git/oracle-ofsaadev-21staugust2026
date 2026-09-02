package oracle.sprinbootapps;

import org.apache.commons.dbcp2.BasicDataSource;
import org.hibernate.SessionFactory;
import org.springframework.orm.jpa.hibernate.LocalSessionFactoryBean;

import java.util.Properties;

public class App {
    public static void main(String[] args) {
        try (CoreRepository<Category> repository = new CategoryRepository()) {
            Category newData = new Category(0, "test");
            Category added = repository.add(newData);
            System.out.println(added != null ? added : "not added");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
