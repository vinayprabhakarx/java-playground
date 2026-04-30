package com.vinayprabhakarx.jdbc;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

public class ReadStudent {
    public static void main(String[] args) {
        String query = "SELECT student_id, first_name, last_name, gender, date_of_birth, email, course, admission_date " +
                "FROM student WHERE student_id = ?";

        try (Connection connection = MySqlConnection.getConnection();
             Scanner scanner = new Scanner(System.in);
             PreparedStatement preparedStatement = connection.prepareStatement(query)) {

            System.out.print("Enter Student ID: ");
            int studentId = Integer.parseInt(scanner.nextLine());

            preparedStatement.setInt(1, studentId);

            try (ResultSet resultSet = preparedStatement.executeQuery()) {
                if (resultSet.next()) {
                    System.out.println(
                            "ID: " + resultSet.getInt(1) +
                                    ", Name: " + resultSet.getString(2) + " " + resultSet.getString(3) +
                                    ", Gender: " + resultSet.getString(4) +
                                    ", DOB: " + resultSet.getString(5) +
                                    ", Email: " + resultSet.getString(6) +
                                    ", Course: " + resultSet.getString(7) +
                                    ", Admission Date: " + resultSet.getString(8)
                    );
                } else {
                    System.out.println("No student found with ID: " + studentId);
                }
            }
        } catch (NumberFormatException e) {
            System.out.println("Please enter a valid numeric student ID.");
        } catch (SQLException e) {
            System.out.println("Database operation failed: " + e.getMessage());
        }
    }
}
