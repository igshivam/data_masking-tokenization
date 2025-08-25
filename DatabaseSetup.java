import java.sql.*;

public class DatabaseSetup {

    private static final String DB_URL = "jdbc:sqlite:tokens.db";


    public static void main(String[] args) {
        try (Connection conn = DriverManager.getConnection(DB_URL);
             Statement stmt = conn.createStatement()) {

            // Create tokens table if not exists
            String sql = "CREATE TABLE IF NOT EXISTS tokens (token TEXT PRIMARY KEY, original TEXT)";
            stmt.executeUpdate(sql);
            System.out.println("Database setup completed!");
        } catch (SQLException e) {
            System.out.println("Database Error: " + e.getMessage());
        }
    }
}