package oracle.sprinbootapps;

import org.apache.commons.dbcp2.BasicDataSource;
import org.hibernate.SessionFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.orm.jpa.hibernate.LocalSessionFactoryBean;

import java.util.Properties;

public class App {
    public static void main(String[] args) {
        ApplicationContext context =
                new ClassPathXmlApplicationContext("beans.xml");
        try (CoreRepository<Category> repository =
                     context.getBean(CategoryRepository.class)) {
            Category newData = new Category(0, "test1");
            Category added = repository.add(newData);
            System.out.println(added != null ? added : "not added");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
