package com.vinayprabhakarx.jdbc;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

public class UsingPreparedStatement {
    public static void main(String[] args) {
        String query = "SELECT * FROM student WHERE student_id = ?";

        try (Connection connection = MySqlConnection.getConnection();
             Scanner scanner = new Scanner(System.in);
             PreparedStatement preparedStatement = connection.prepareStatement(query)
             ) {
            System.out.println("Medium Created for Prepared Statement");
            System.out.println();
            System.out.print("Enter Student ID:");

            if (!scanner.hasNextInt()) {
                System.out.println("Please enter a valid numeric student ID.");
                return;
            }

            int id = scanner.nextInt();
            System.out.println();

            // Select Query with specific id
            preparedStatement.setInt(1, id);
            ResultSet resultSet = preparedStatement.executeQuery();
            System.out.println("Query Executed");
            System.out.println();

            //Displaying the result
            if (resultSet.next()) {
                System.out.println(
                        resultSet.getInt("student_id") + "|"
                        + resultSet.getString("first_name") + "|"
                        + resultSet.getString("last_name") + "|"
                        + resultSet.getString("gender") + "|"
                        + resultSet.getString("date_of_birth") + "|"
                        + resultSet.getString("email") + "|"
                        + resultSet.getString("course") + "|"
                        + resultSet.getString("admission_date")
                );
            } else {
                System.out.println("No student found with ID: " + id);
            }
        } catch (SQLException e) {
            System.out.println("Database operation failed: " + e.getMessage());
        }
    }
}
