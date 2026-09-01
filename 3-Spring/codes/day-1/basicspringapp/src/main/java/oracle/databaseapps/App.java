package oracle.databaseapps;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Hello world!
 *
 */
public class App {
    public static void main(String[] args) {
        ApplicationContext container = new ClassPathXmlApplicationContext("beans.xml");
        Student anilStudent = container.getBean("firstStudent", Student.class);
        System.out.println(anilStudent.getName());

        Student sunilStudent = container.getBean("secondStudent", Student.class);
        System.out.println(sunilStudent.getName());

        Employee manager = container.getBean("managerBean", Employee.class);
        System.out.println(
                "Name: " + manager.getName()
                        + "\nManager Name: " +
                        (manager.getManager() == null ? "NA" : manager.getManager().getName()));

        Employee employee = container.getBean("employeeBean", Employee.class);
        System.out.println(
                "\nName: " + employee.getName()
                        + "\nManager Name: " +
                        (employee.getManager() == null ? "NA" : employee.getManager().getName()));


    }
}
