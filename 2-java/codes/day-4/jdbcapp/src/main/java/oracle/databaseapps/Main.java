package oracle.databaseapps;

import oracle.databaseapps.dao.abstractions.Repository;
import oracle.databaseapps.dao.implmentations.ProductRepository;
import oracle.databaseapps.dto.ProductDTO;

import java.sql.*;
import java.util.Collection;

public class Main {
    public static void main(String[] args) {
        Repository<ProductDTO, Integer> repository = null;
        try {
            repository = new ProductRepository();
            Collection<ProductDTO> products = repository.getAll();
            if (!products.isEmpty()) {
                products.forEach(System.out::println);
            } else {
                System.out.println("no products found");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
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