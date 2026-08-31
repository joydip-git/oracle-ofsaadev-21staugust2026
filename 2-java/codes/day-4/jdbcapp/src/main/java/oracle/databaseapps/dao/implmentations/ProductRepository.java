package oracle.databaseapps.dao.implmentations;

import oracle.databaseapps.dao.abstractions.Repository;
import oracle.databaseapps.dto.ProductDTO;

import java.sql.*;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class ProductRepository implements Repository<ProductDTO, Integer> {

    @Override
    public ProductDTO add(ProductDTO data) {
        return null;
    }

    @Override
    public ProductDTO delete(Integer id) {
        return null;
    }

    @Override
    public Collection<ProductDTO> getAll()
            throws SQLException, ClassNotFoundException {
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
            throws SQLException, ClassNotFoundException {
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
    public ProductDTO update(Integer id, ProductDTO data) {
        return null;
    }

    private Connection createConnection()
            throws ClassNotFoundException, SQLException {

        Class.forName("oracle.jdbc.driver.OracleDriver");

        return DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:free",
                "system", "Oracle@2026");
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
        productDTO.setReleaseDate(results.getDate("release_date"));

        var image = results.getBlob("image");
        if ( image != null) {
            productDTO.setImage(image.getBytes(0, 1000));
        }
        return productDTO;
    }
}
