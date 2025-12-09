package agito.diarilala;

import lombok.*;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
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
        String query = "SELECT * FROM Product_category ORDER BY id";
        try(Connection connection = dbConnection.getDBConnection();
            Statement statement = connection.createStatement();
            ResultSet rs = statement.executeQuery(query)) {
            while (rs.next()) {
                Category category = new Category();
                category.setId(rs.getInt("id"));
                category.setName(rs.getString("name"));
                categories.add(category);
            }
        }
        return categories;
    };

    public List<Product> getProductList(int page, int size){
        List<Product> products = new ArrayList<>();
    };

    public List<Product> getProductsByCriteria(String productName, String categoryName, Instant creationMin, instant creationMax){
        List<Product> products = new ArrayList<>();
    };

    public List<Product> getProductsByCriteria(String productName, String categoryName, Instant creationMin, Instant creationMax, int page, int size){
        List<Product> products = new ArrayList<>();
    };
}
