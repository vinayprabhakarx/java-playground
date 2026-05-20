package com.vinayprabhakarx.jdbc;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Scanner;

public class UpdateStudent {
    public static void main(String[] args) {
        try (Connection connection = MySqlConnection.getConnection();
             Scanner scanner = new Scanner(System.in)) {

            System.out.print("Enter Student ID to Update: ");
            int studentId = Integer.parseInt(scanner.nextLine());

            while (true) {
                System.out.println();
                System.out.println("Choose field to update:");
                System.out.println("1. First Name");
                System.out.println("2. Last Name");
                System.out.println("3. Gender");
                System.out.println("4. Date of Birth");
                System.out.println("5. Email");
                System.out.println("6. Course");
                System.out.println("7. Admission Date");
                System.out.println("8. Exit");
                System.out.print("Enter your choice: ");
                int choice = Integer.parseInt(scanner.nextLine());

                if (choice == 8) {
                    System.out.println("Exiting update program.");
                    return;
                }

                String columnName;
                String fieldName;

                switch (choice) {
                    case 1:
                        columnName = "first_name";
                        fieldName = "First Name";
                        break;
                    case 2:
                        columnName = "last_name";
                        fieldName = "Last Name";
                        break;
                    case 3:
                        columnName = "gender";
                        fieldName = "Gender";
                        break;
                    case 4:
                        columnName = "date_of_birth";
                        fieldName = "Date of Birth (YYYY-MM-DD)";
                        break;
                    case 5:
                        columnName = "email";
                        fieldName = "Email";
                        break;
                    case 6:
                        columnName = "course";
                        fieldName = "Course";
                        break;
                    case 7:
                        columnName = "admission_date";
                        fieldName = "Admission Date (YYYY-MM-DD)";
                        break;
                    default:
                        System.out.println("Invalid choice. Please choose between 1 and 8.");
                        continue;
                }

                System.out.print("Enter New " + fieldName + ": ");
                String newValue = scanner.nextLine();

                String query = "UPDATE student SET " + columnName + " = ? WHERE student_id = ?";

                int rowsUpdated;
                try (PreparedStatement preparedStatement = connection.prepareStatement(query)) {
                    preparedStatement.setString(1, newValue);
                    preparedStatement.setInt(2, studentId);
                    rowsUpdated = preparedStatement.executeUpdate();
                }

                if (rowsUpdated > 0) {
                    System.out.println("Student updated successfully.");
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
