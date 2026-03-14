import java.sql.*; // Import JDBC classes

public class Question1 {
    // -----------------------------
    // Database connection info
    // -----------------------------
    private static final String DB_URL = "jdbc:mysql://127.0.0.1:3306/mydb"; // MySQL database URL
    private static final String USER = "bdusername";      // MySQL username
    private static final String PASS = "dbpassword"; // MySQL password

    // -----------------------------
    // Layer 7 Security: Input Validation
    // -----------------------------
    // Only allow letters (A-Z, a-z) and spaces
    public static boolean isValidInput(String input) {
        return input != null && input.matches("[A-Za-z ]+");
    }

    public static void main(String[] args) {
        String userInput = "test user"; // Example user input

        // Validate input before using it
        if (!isValidInput(userInput)) {
            System.out.println("Invalid input detected! Only letters and spaces are allowed.");
            return; // Stop processing if input is invalid
        }

        // Connect to the database using JDBC
        try (Connection conn = DriverManager.getConnection(DB_URL, USER, PASS)) {
            // Use PreparedStatement to prevent SQL injection
            String sql = "SELECT * FROM users WHERE name = ?";
            PreparedStatement pstmt = conn.prepareStatement(sql);
            pstmt.setString(1, userInput); // Set input parameter safely

            // Execute query
            ResultSet rs = pstmt.executeQuery();

            // Process results
            boolean found = false;
            while (rs.next()) {
                System.out.println("User found: " + rs.getString("name"));
                found = true;
            }

            if (!found) {
                System.out.println("User not found.");
            }

        } catch (SQLException e) {
            e.printStackTrace(); // Handle SQL exceptions
        }
    }
}