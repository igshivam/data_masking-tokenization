import java.sql.*;
import java.util.Scanner;
import java.util.UUID;

public class DataTokenization {

    private static final String DB_URL = "jdbc:sqlite:tokens.db";

    // Generate Token
    public static String tokenize(String data) {
        String token = UUID.randomUUID().toString(); // Generate unique token
        try (Connection conn = DriverManager.getConnection(DB_URL);
             PreparedStatement pstmt = conn.prepareStatement("INSERT INTO tokens (token, original) VALUES (?, ?)")
        ) {
            pstmt.setString(1, token);
            pstmt.setString(2, data);
            pstmt.executeUpdate();
        } catch (SQLException e) {
            System.out.println("Tokenization Error: " + e.getMessage());
        }
        return token;
    }

    // Retrieve Original Data
    public static String detokenize(String token) {
        try (Connection conn = DriverManager.getConnection(DB_URL);
             PreparedStatement pstmt = conn.prepareStatement("SELECT original FROM tokens WHERE token = ?")
        ) {
            pstmt.setString(1, token);
            ResultSet rs = pstmt.executeQuery();
            if (rs.next()) {
                return rs.getString("original");
            }
        } catch (SQLException e) {
            System.out.println("Detokenization Error: " + e.getMessage());
        }
        return null;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("Choose an option: \n1. Tokenize Data \n2. Detokenize Data \n3. Exit");
            int choice = scanner.nextInt();
            scanner.nextLine();  // Consume newline

            switch (choice) {
                case 1:
                    System.out.print("Enter data to tokenize: ");
                    String data = scanner.nextLine();
                    String token = tokenize(data);
                    System.out.println("Generated Token: " + token);
                    break;
                case 2:
                    System.out.print("Enter token to detokenize: ");
                    String inputToken = scanner.nextLine();
                    String original = detokenize(inputToken);
                    System.out.println("Original Data: " + (original != null ? original : "Not Found"));
                    break;
                case 3:
                    System.out.println("Exiting...");
                    scanner.close();
                    return;
                default:
                    System.out.println("Invalid choice, please try again.");
            }
        }
    }
}