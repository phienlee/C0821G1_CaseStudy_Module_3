package furama_resort.repository.impl;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class BaseConnection {
    public static Connection connection;
    private static String jdbcURL = "jdbc:mysql://localhost:3306/furama_resort_dababase";
    private static String jdbcUsername = "root";
    private static String jdbcPassword = "1234567";

    static {
        try {
            Class.forName("com.mysql.jdbc.Driver");
            connection = DriverManager.getConnection(jdbcURL, jdbcUsername, jdbcPassword);
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }
    }

    public static Connection getConnection() {
        return connection;
    }
}
