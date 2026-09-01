package oracle.databaseapps.dao.implmentations;

import oracle.databaseapps.dao.abstractions.DbRepository;
import oracle.databaseapps.dto.ProductDTO;
import org.springframework.stereotype.Repository;

import java.io.FileReader;
import java.io.IOException;
import java.sql.*;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Properties;

@Repository
public class ProductRepository implements DbRepository<ProductDTO, Integer> {

    @Override
    public ProductDTO add(ProductDTO data)
            throws Exception {

        Connection connection = null;
        CallableStatement statement = null;
        //PreparedStatement statement = null;
//        String query = "insert into products(product_name,product_code,description,"
//                + "release_date,rating,product_price,category_id) " +
//                "values(?,?,?,?,?,?,?)";
        String query = "{call sp_insert_product(?,?,?,?,?,?,?,?)}";
        try {
            connection = createConnection();
            //statement = connection.prepareStatement(query);
            statement = connection.prepareCall(query);
//            statement.setString(1, data.getProductName());
//            statement.setString(2, data.getProductCode());
//            statement.setString(3, data.getDescription());
//            statement.setDate(4, Date.valueOf(data.getReleaseDate()));
//            statement.setDouble(5, data.getRating());
//            statement.setDouble(6, data.getProductPrice());
//            statement.setInt(7, data.getCategoryId());
            //statement.setBlob(8,);
            statement.setString(1, data.getProductName());
            statement.setString(4, data.getProductCode());
            statement.setString(3, data.getDescription());
            statement.setDate(5, Date.valueOf(data.getReleaseDate()));
            statement.setDouble(6, data.getRating());
            statement.setDouble(2, data.getProductPrice());
            statement.setInt(7, data.getCategoryId());
            statement.registerOutParameter(8, JDBCType.INTEGER);
            int rowsAffected = statement.executeUpdate();
            int prod_id = statement.getInt(8);
            data.setProductId(prod_id);
            if (rowsAffected > 0)
                return data;
            else
                throw new Exception("could not add record");
        } finally {
            closeConnection(connection);
        }
    }

    @Override
    public ProductDTO delete(Integer id) throws Exception {
        Connection connection = null;
        PreparedStatement statement = null;
        String deleteQuery = "delete from products where product_id=?";

        try {
            ProductDTO dto = get(id);
            if (dto != null) {
                connection = createConnection();
                statement = connection.prepareStatement(deleteQuery);
                statement.setInt(1, id);
                int rowsAffected = statement.executeUpdate();
                if (rowsAffected > 0)
                    return dto;
                else
                    throw new Exception("could not delete");
            } else
                return null;
        } finally {
            closeConnection(connection);
        }
    }

    @Override
    public Collection<ProductDTO> getAll()
            throws SQLException, ClassNotFoundException, IOException {
        String query = "select * from products";
        Connection connection = null;
        Statement statement = null;
        ResultSet results = null;
        List<ProductDTO> productDTOS = null;

        try {
            connection = createConnection();
            statement = connection.createStatement();
            results = statement.executeQuery(query);

            if (results.getFetchSize() > 0) {
                productDTOS = new ArrayList<>();

                while (results.next()) {
                    ProductDTO productDTO = mapToProductDTO(results);
                    productDTOS.add(productDTO);
                }
            }
        } finally {
            closeConnection(connection);
        }
        return productDTOS;

    }

    @Override
    public ProductDTO get(Integer id)
            throws SQLException, ClassNotFoundException, IOException {
        Connection connection = null;
        String query = "select * from products where product_id=?";
        PreparedStatement statement = null;
        ResultSet resultSet = null;
        ProductDTO productDTO = null;
        try {
            connection = createConnection();
            statement = connection.prepareStatement(query);
            statement.setInt(1, id);

            resultSet = statement.executeQuery();

            if (resultSet.getFetchSize() > 0) {
                while (resultSet.next()) {
                    productDTO = mapToProductDTO(resultSet);
                }
            }

        } finally {
            closeConnection(connection);
        }
        return productDTO;
    }

    @Override
    public ProductDTO update(Integer id, ProductDTO data) throws
            Exception {

        Connection connection = null;
        PreparedStatement statement = null;
        String query = "update products set product_name=?,product_code=?,"
                + "description=?,release_date=?,rating=?,product_price=?,"
                + "category_id=? where product_id=?";
        try {
            connection = createConnection();
            statement = connection.prepareStatement(query);
            statement.setString(1, data.getProductName());
            statement.setString(2, data.getProductCode());
            statement.setString(3, data.getDescription());
            statement.setDate(4, Date.valueOf(data.getReleaseDate()));
            statement.setDouble(5, data.getRating());
            statement.setDouble(6, data.getProductPrice());
            statement.setInt(7, data.getCategoryId());
            statement.setInt(8, id);
            //statement.setBlob(8,);
            int rowsAffected = statement.executeUpdate();
            if (rowsAffected > 0)
                return data;
            else
                throw new Exception("could not update record");
        } finally {
            closeConnection(connection);
        }
    }

    private Connection createConnection()
            throws ClassNotFoundException, SQLException, IOException {

        Properties properties = new Properties();
        FileReader reader = new FileReader("src/main/resources/application.properties");
        properties.load(reader);
        reader.close();

        Class.forName(properties.getProperty("driver"));

        return DriverManager.getConnection(
                properties.getProperty("url"),
                properties.getProperty("username"),
                properties.getProperty("password")
        );
    }

    private void closeConnection(Connection connection)
            throws SQLException {
        if (connection != null && !connection.isClosed()) {
            connection.close();
        }
    }

    private ProductDTO mapToProductDTO(ResultSet results)
            throws SQLException {

        ProductDTO productDTO = new ProductDTO();
        productDTO.setProductId(results.getInt("product_id"));
        productDTO.setProductName(results.getString("product_name"));
        productDTO.setDescription(results.getString("description"));
        productDTO.setProductCode(results.getString("product_code"));
        productDTO.setProductPrice(results.getDouble("product_price"));
        productDTO.setRating(results.getDouble("rating"));
        productDTO.setReleaseDate(results.getDate("release_date").toLocalDate());

        var image = results.getBlob("image");
        if (image != null) {
            productDTO.setImage(image.getBytes(0, 1000));
        }
        return productDTO;
    }
}
