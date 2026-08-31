import javax.swing.plaf.nimbus.State;
import java.sql.*;

public class Main {
    public static void main(String[] args) throws SQLException {
        Connection connection = null;
        Statement statement = null;
        ResultSet resultSet = null;
        try {
            Class.forName("oracle.jdbc.driver.OracleDriver");
            connection = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:free", "system", "Oracle@2026");
            statement = connection.createStatement();
            resultSet = statement.executeQuery("select * from products");
            while (resultSet.next()) {
                System.out.println(resultSet.getString("product_name"));
            }
            resultSet.close();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            if (connection != null)
                if (!connection.isClosed())
                    connection.close();
        }

    }
}