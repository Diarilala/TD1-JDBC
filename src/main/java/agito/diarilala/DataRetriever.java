package agito.diarilala;

import lombok.*;

import java.sql.*;
import java.time.Instant;
import java.util.ArrayList;
import java.util.List;

@ToString
@Getter
@Setter
@AllArgsConstructor
@EqualsAndHashCode

public class DataRetriever {
    private final DBConnection dbConnection;

    public List<Category> getAllCategories() throws SQLException {
        List<Category> categories = new ArrayList<>();
        String query = "SELECT id, name FROM Product_category ORDER BY id";
        try(Connection connection = dbConnection.getDBConnection();
            Statement statement = connection.createStatement();
            ResultSet rs = statement.executeQuery(query)) {
            while (rs.next()) {
                Category category = new Category();
                category.setId(rs.getInt("id"));
                category.setName(rs.getString("name"));
                categories.add(category);
            }
        }   catch (SQLException e) {
            throw new RuntimeException("Error while fetching categories", e);
        }
        return categories;
    };

    public List<Product> getProductList(int page, int size) throws SQLException {
        List<Product> products = new ArrayList<>();

        int offset = (page - 1) * size;

        String query = "SELECT p.id, p.name FROM Products p LEFT JOIN product_category pc ON p.id = pc.category_id ORDER BY p.id LIMIT ?  OFFSET ?";
        try(Connection connection = dbConnection.getDBConnection();
            PreparedStatement statement = connection.prepareStatement(query)) {
            statement.setInt(1, offset);
            statement.setInt(2, size);

            try (ResultSet rs = statement.executeQuery()) {
                while (rs.next()) {
                    Product product = new Product();
                    product.setId(rs.getInt("id"));
                    product.setName(rs.getString("name"));
                    products.add(product);
                }
            }

        return products;
    }
    };

    public List<Product> getProductsByCriteria(String productName, String categoryName, Instant creationMin, instant creationMax){
        List<Product> products = new ArrayList<>();
    };

    public List<Product> getProductsByCriteria(String productName, String categoryName, Instant creationMin, Instant creationMax, int page, int size){
        List<Product> products = new ArrayList<>();
    };
}
