package connection;

import java.math.BigDecimal;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ProductDao implements Dao<Product> {

    @Override
    public void save(Product entity) {

    }

    @Override
    public void update(Product entity)  {

    }

    @Override
    public void delete(Product entity)  {

    }

    @Override
    public Product get(Integer primarykey)  {
        return null;
    }

    @Override
    public List<Product> getAll() {
        String sql = "SELECT *FROM products";
        List<Product> products = new ArrayList<>();
        ConnectionPool connectionPool = ConnectionPool.getInstance();
        Connection connection = connectionPool.getConneciton();
        try (PreparedStatement preparedStatement = connection.prepareStatement(sql);
             ResultSet resultSet = preparedStatement.executeQuery()) {
            while (resultSet.next()){
                Integer productId = resultSet.getInt("product_id");
                String name = resultSet.getString("name");
                Integer quantityInStock = resultSet.getInt("quantity_in_stock");
                BigDecimal unitPrice = resultSet.getBigDecimal("unit_price");
                Product product = new Product();
                product.setProductId(productId);
                product.setName(name);
                product.setQuantityInStock(quantityInStock);
                product.setUnitPrice(unitPrice);
                products.add(product);
            }
        } catch (SQLException exception) {
            throw new RuntimeException(exception.getMessage());
        }finally {
            connectionPool.releaseConnection(connection);
        }
        return products;
    }
}
