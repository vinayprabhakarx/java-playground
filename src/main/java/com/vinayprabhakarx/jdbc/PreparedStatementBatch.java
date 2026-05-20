package com.vinayprabhakarx.jdbc;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Scanner;

public class PreparedStatementBatch {
    public static void main(String[] args) {
        String query = "INSERT INTO student " +
                "(student_id, first_name, last_name, gender, date_of_birth, email, course, admission_date) " +
                "VALUES (?, ?, ?, ?, ?, ?, ?, ?)";

        try (Connection connection = MySqlConnection.getConnection();
             Scanner scanner = new Scanner(System.in);
             PreparedStatement preparedStatement = connection.prepareStatement(query)) {

            connection.setAutoCommit(false);

            System.out.print("Enter number of students to insert: ");
            int totalStudents = Integer.parseInt(scanner.nextLine());

            for (int i = 1; i <= totalStudents; i++) {
                System.out.println();
                System.out.println("Enter details for student " + i);

                System.out.print("Enter Student ID: ");
                int studentId = Integer.parseInt(scanner.nextLine());

                System.out.print("Enter First Name: ");
                String firstName = scanner.nextLine();

                System.out.print("Enter Last Name: ");
                String lastName = scanner.nextLine();

                System.out.print("Enter Gender: ");
                String gender = scanner.nextLine();

                System.out.print("Enter Date of Birth (YYYY-MM-DD): ");
                String dateOfBirth = scanner.nextLine();

                System.out.print("Enter Email: ");
                String email = scanner.nextLine();

                System.out.print("Enter Course: ");
                String course = scanner.nextLine();

                System.out.print("Enter Admission Date (YYYY-MM-DD): ");
                String admissionDate = scanner.nextLine();

                preparedStatement.setInt(1, studentId);
                preparedStatement.setString(2, firstName);
                preparedStatement.setString(3, lastName);
                preparedStatement.setString(4, gender);
                preparedStatement.setString(5, dateOfBirth);
                preparedStatement.setString(6, email);
                preparedStatement.setString(7, course);
                preparedStatement.setString(8, admissionDate);
                preparedStatement.addBatch();
            }

            int[] insertedRows = preparedStatement.executeBatch();
            connection.commit();

            System.out.println();
            System.out.println(insertedRows.length + " students inserted successfully.");
        } catch (NumberFormatException e) {
            System.out.println("Please enter a valid numeric value.");
        } catch (SQLException e) {
            System.out.println("Database operation failed: " + e.getMessage());
        }
    }
}
