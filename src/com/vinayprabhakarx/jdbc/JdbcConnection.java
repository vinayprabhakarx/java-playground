package com.vinayprabhakarx.jdbc;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class JdbcConnection {

    public static void main(String[] args) {

        String query = "SELECT * FROM student";

        try (
                Connection connection = MySqlConnection.getConnection();
                Statement statement = connection.createStatement();
                ResultSet resultSet = statement.executeQuery(query)
        ) {

            while (resultSet.next()) {

                int studentId = resultSet.getInt("student_id");
                String firstName = resultSet.getString("first_name");
                String lastName = resultSet.getString("last_name");
                String gender = resultSet.getString("gender");
                String dob = resultSet.getString("date_of_birth");
                String email = resultSet.getString("email");
                String course = resultSet.getString("course");
                String admissionDate = resultSet.getString("admission_date");

                System.out.println(
                        "ID: " + studentId +
                                ", Name: " + firstName + " " + lastName +
                                ", Gender: " + gender +
                                ", DOB: " + dob +
                                ", Email: " + email +
                                ", Course: " + course +
                                ", Admission Date: " + admissionDate
                );
            }

        } catch (SQLException e) {
            System.out.println("Database operation failed: " + e.getMessage());
        }
    }
}