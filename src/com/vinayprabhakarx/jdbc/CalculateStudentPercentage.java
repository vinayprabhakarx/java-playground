package com.vinayprabhakarx.jdbc;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

public class CalculateStudentPercentage {
    public static void main(String[] args) {
        String query = "SELECT s.student_id, s.first_name, s.last_name, s.gender, s.date_of_birth, " +
                "s.email, s.course, s.admission_date, sr.semester, sr.total_marks, " +
                "sr.obtained_marks, sr.grade, sr.result_status " +
                "FROM student s " +
                "JOIN student_result sr ON s.student_id = sr.student_id " +
                "WHERE s.student_id = ?";

        try (Connection connection = MySqlConnection.getConnection();
             Scanner scanner = new Scanner(System.in);
             PreparedStatement preparedStatement = connection.prepareStatement(query)) {

            System.out.print("Enter Student ID: ");
            int studentId = Integer.parseInt(scanner.nextLine());

            preparedStatement.setInt(1, studentId);

            try (ResultSet resultSet = preparedStatement.executeQuery()) {
                if (resultSet.next()) {
                    int totalMarks = resultSet.getInt("total_marks");
                    int obtainedMarks = resultSet.getInt("obtained_marks");
                    double percentage = (obtainedMarks * 100.0) / totalMarks;

                    System.out.println("Student Details");
                    System.out.println("ID: " + resultSet.getInt("student_id"));
                    System.out.println("Name: " + resultSet.getString("first_name") + " " +
                            resultSet.getString("last_name"));
                    System.out.println("Gender: " + resultSet.getString("gender"));
                    System.out.println("Date of Birth: " + resultSet.getString("date_of_birth"));
                    System.out.println("Email: " + resultSet.getString("email"));
                    System.out.println("Course: " + resultSet.getString("course"));
                    System.out.println("Admission Date: " + resultSet.getString("admission_date"));
                    System.out.println();
                    System.out.println("Result Details");
                    System.out.println("Semester: " + resultSet.getInt("semester"));
                    System.out.println("Total Marks: " + totalMarks);
                    System.out.println("Obtained Marks: " + obtainedMarks);
                    System.out.printf("Percentage: %.2f%%%n", percentage);
                    System.out.println("Grade: " + resultSet.getString("grade"));
                    System.out.println("Result Status: " + resultSet.getString("result_status"));
                } else {
                    System.out.println("No result found with Student ID: " + studentId);
                }
            }
        } catch (NumberFormatException e) {
            System.out.println("Please enter a valid numeric student ID.");
        } catch (SQLException e) {
            System.out.println("Database operation failed: " + e.getMessage());
        }
    }
}
