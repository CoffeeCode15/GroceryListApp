import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/** Riccardo Giacalone
 * Creazione Database.
 */
public class DatabaseConnection {
    private static final String URL = "jdbc:mysql://localhost:3306/Grocery";
    private static final String USERNAME = "root";
    private static final String PASSWORD = "...........";

    public static Connection getConnection() {
        try {
            return DriverManager.getConnection(URL, USERNAME, PASSWORD);
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
    }
}

