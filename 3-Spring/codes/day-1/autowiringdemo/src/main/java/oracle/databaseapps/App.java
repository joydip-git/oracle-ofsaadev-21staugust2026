package oracle.databaseapps;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Hello world!
 *
 */
public class App {
    public static void main(String[] args) {
        ApplicationContext container = createContext();

//      Manager<String> manager = container.getBean("managerBean", DataManager.class);
        Manager<String> fileManager = container.getBean(FileManager.class);
        System.out.println(fileManager.fetchData());

        Manager<Object> dbManager = container.getBean(DbManager.class);
        System.out.println(dbManager.fetchData());
    }

    static ApplicationContext createContext() {
        return new ClassPathXmlApplicationContext("beans.xml");
    }
}
