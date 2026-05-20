package com.vinayprabhakarx.jdbc;

import io.github.cdimascio.dotenv.Dotenv;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class JDBCConnectionStepByStep {

    public static void main(String[] args) throws SQLException {

        // Load .env file.
        Dotenv dotenv = Dotenv.load();

        String url = "jdbc:mysql://localhost:3306/java_playground";
        String username = dotenv.get("DB_USERNAME");
        String password = dotenv.get("DB_PASSWORD");

        if (username == null || password == null) {
            throw new SQLException("Database configuration is missing in .env file");
        }

        try {
            // Step 1: Loading the Driver
            Class.forName("com.mysql.cj.jdbc.Driver");
            System.out.println("Driver Loaded Successfully...");

            // Step 2: Establish Connection
            Connection connection = DriverManager.getConnection(url, username, password);
            System.out.println("Connection Established Successfully");

            // Step 3: Create Statement
            Statement statement = connection.createStatement();
            System.out.println("Statement Created");

            // Step 4: Execute Query
            String sql = "SELECT * FROM student";
            ResultSet resultSet = statement.executeQuery(sql);

            // Step 5: Process ResultSet
            while (resultSet.next()) {
                System.out.println(
                        resultSet.getInt("student_id") + " "
                                + resultSet.getString("first_name") + " "
                                + resultSet.getString("last_name") + " "
                                + resultSet.getString("date_of_birth") + " "
                                + resultSet.getString("email")
                );
            }

            // Step 6: Close Resources
            resultSet.close();
            statement.close();
            connection.close();

            System.out.println("Resources Closed Successfully");

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}