package util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBConnection {

    // Database URL
    private static final String URL =
            "jdbc:mysql://localhost:3306/smartbank";

    // Database Username
    private static final String USERNAME = "root";

    // Database Password
    private static final String PASSWORD = "Ganesh@123";

    // Method to create connection
    public static Connection getConnection() {

        Connection connection = null;

        try {

            connection = DriverManager.getConnection(
                    URL,
                    USERNAME,
                    PASSWORD);

            System.out.println("Database Connected Successfully.");

        } catch (SQLException e) {

            System.out.println("Database Connection Failed.");

            e.printStackTrace();
        }

        return connection;
    }
}