package Training4;

import java.sql.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class DBConnectionExample {


	public static void main(String[] args) throws SQLException, ClassNotFoundException {
		// TODO Auto-generated method stub
		 try {
		 // 1. Load JDBC Driver
        Class.forName("com.mysql.cj.jdbc.Driver");

        // 2. Establish connection
        
		
        Connection conn = DriverManager.getConnection(
                "jdbc:mysql://localhost:3306/automation_test", "root", "Password@142");

        // 3. Create statement
        Statement stmt = conn.createStatement();

        
        // Step 4: Create 'users' table
        String createTable = "CREATE TABLE IF NOT EXISTS users (" +
                "id INT PRIMARY KEY AUTO_INCREMENT, " +
                "name VARCHAR(100), " +
                "email VARCHAR(100))";
        stmt.executeUpdate(createTable);
        System.out.println("✅ Table created or already exists.");

        // Step 5: Insert sample user
        String insertUser = "INSERT INTO users (name, email) VALUES ('Test10', 'test10@example.com')";
        stmt.executeUpdate(insertUser);
        System.out.println("✅ Sample user inserted.");

        // Step 6: Retrieve and display users
        ResultSet rs = stmt.executeQuery("SELECT * FROM users");
        System.out.println("🧾 Users in the table:");
        while (rs.next()) {
            System.out.println("ID: " + rs.getInt("id") +
                    ", Name: " + rs.getString("name") +
                    ", Email: " + rs.getString("email"));
        }

        // Step 7: Close connections
        
        rs.close();
        stmt.close();
        conn.close();
        System.out.println("🔚 Done!");

    } catch (Exception e) {
        e.printStackTrace();
    }
}
}

        
     