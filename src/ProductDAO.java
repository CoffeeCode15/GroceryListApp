package GroceryListApp.src;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

/**
 * Riccardo Giacalone.
 * Creazione database per Produclist,
 *con metodi per  inserire, leggere, aggiornare e cancellare dati.
 */
public class ProductDAO {
    public boolean addProduct(Product newProduct) {
        try (Connection conn = DatabaseConnection.getConnection()) {
            String query = "INSERT INTO productList (name, quantity, price, completed) VALUES (?, ?, ?, ?)";
            PreparedStatement statement = conn.prepareStatement(query);
            statement.setString(1, newProduct.getName());
            statement.setInt(2, newProduct.getQuantity());
            statement.setFloat(3, newProduct.getPrice());
            statement.setBoolean(4, newProduct.isCompleted());

            int rowsInserted = statement.executeUpdate();
            return rowsInserted > 0;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    public List<Product> getAllProducts() {
        List<Product> products = new ArrayList<>();
        try (Connection conn = DatabaseConnection.getConnection()) {
            String query = "SELECT * FROM productList";
            PreparedStatement statement = conn.prepareStatement(query);
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {
                int id = resultSet.getInt("id");
                String name = resultSet.getString("name");
                int quantity = resultSet.getInt("quantity");
                float price = resultSet.getFloat("price");
                boolean completed = resultSet.getBoolean("completed");
                Product product = new Product(name, quantity, price);
                products.add(product);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return products;
    }

    public void updateProduct(Product product) {
        try (Connection conn = DatabaseConnection.getConnection()) {
            String query = "UPDATE product SET name=?, quantity=?, price=?, completed=? WHERE id=?";
            PreparedStatement statement = conn.prepareStatement(query);
            statement.setString(1, product.getName());
            statement.setInt(2, product.getQuantity());
            statement.setFloat(3, product.getPrice());
            statement.setBoolean(4, product.isCompleted());
            statement.setInt(5, product.getId());
            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void deleteProduct(int productId) {
        try (Connection conn = DatabaseConnection.getConnection()) {
            String query = "DELETE FROM product WHERE id=?";
            PreparedStatement statement = conn.prepareStatement(query);
            statement.setInt(1, productId);
            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}

