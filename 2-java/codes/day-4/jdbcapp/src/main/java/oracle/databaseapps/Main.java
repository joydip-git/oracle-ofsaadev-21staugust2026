package oracle.databaseapps;

import oracle.databaseapps.dao.abstractions.DbRepository;
import oracle.databaseapps.dao.implmentations.ProductRepository;
import oracle.databaseapps.dto.ProductDTO;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.io.IOException;
import java.sql.*;
import java.time.LocalDate;
import java.util.Collection;

public class Main {
    static ApplicationContext createContext(){
        return new ClassPathXmlApplicationContext("beans.xml");
    }
    public static void main(String[] args) {
        DbRepository<ProductDTO, Integer> dbRepository = null;
        try {
            dbRepository = createContext().getBean(ProductRepository.class);
            showAllProducts(dbRepository);
            //showProduct(repository);
            //addRecord(repository);
            //updateRecord(repository);
            //deleteRecord(repository.delete(21), "could not delete");
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private static void deleteRecord(ProductDTO repository, String x) throws Exception {
        var deleted = repository;
        System.out.println(deleted != null ? deleted : x);
    }

    private static void updateRecord(DbRepository<ProductDTO, Integer> dbRepository) throws Exception {
        deleteRecord(dbRepository.update(21, new ProductDTO(0, "sample-1",
                100.00, "sample-1234", null,
                LocalDate.now(), null, 1, 100)), "could not update");
    }

    private static void addRecord(DbRepository<ProductDTO, Integer> dbRepository) throws Exception {
        var data = new ProductDTO(0, "iphone 1516", 150000.00,
                "phone-1324", "new mobile from apple"
                , LocalDate.now(), null, 4.5, 101);
        var added = dbRepository.add(data);
        System.out.println(added != null ? data : "not added");
    }

    private static void showProduct(DbRepository<ProductDTO, Integer> dbRepository) throws SQLException, ClassNotFoundException, IOException {
        ProductDTO record = dbRepository.get(1);
        System.out.println(record != null ? record : "product not found");
    }

    private static void showAllProducts(DbRepository<ProductDTO, Integer> dbRepository) throws SQLException, ClassNotFoundException, IOException {
        Collection<ProductDTO> products = dbRepository.getAll();
        if (!products.isEmpty()) {
            products.forEach(System.out::println);
        } else {
            System.out.println("no products found");
        }
    }

    /*
    private static void fetchData() {
        Connection connection = null;
        Statement statement = null;
        ResultSet results = null;
        String query = "select * from products";
        try {
            //1. Loading the OracleDriver which will help your JDBC APIs
            //to interact with Oracle database
            Class.forName("oracle.jdbc.driver.OracleDriver");

            //2. using DriverManager to establish a connection with oracle
            // database through the loaded driver
            connection = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:free", "system", "Oracle@2026");
            statement = connection.createStatement();
            results = statement.executeQuery(query);

            while (results.next()) {
                System.out.println(
                        results.getString("product_name")
                                + "\t"
                                + results.getDouble("product_price")
                );
            }
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                if (results != null && !results.isClosed())
                    results.close();

                if (connection != null && !connection.isClosed())
                    connection.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
     */
}