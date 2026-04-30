package com.vinayprabhakarx.jdbc;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Scanner;

public class DeleteStudent {
    public static void main(String[] args) {
        String query = "DELETE FROM student WHERE student_id = ?";

        try (Connection connection = MySqlConnection.getConnection();
             Scanner scanner = new Scanner(System.in);
             PreparedStatement preparedStatement = connection.prepareStatement(query)) {

            System.out.print("Enter Student ID to Delete: ");
            int studentId = Integer.parseInt(scanner.nextLine());

            preparedStatement.setInt(1, studentId);

            int rowsDeleted = preparedStatement.executeUpdate();

            if (rowsDeleted > 0) {
                System.out.println("Student deleted successfully.");
            } else {
                System.out.println("No student found with ID: " + studentId);
            }
        } catch (NumberFormatException e) {
            System.out.println("Please enter a valid numeric student ID.");
        } catch (SQLException e) {
            System.out.println("Database operation failed: " + e.getMessage());
        }
    }
}
