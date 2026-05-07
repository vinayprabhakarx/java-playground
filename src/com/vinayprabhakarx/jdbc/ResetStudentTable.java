package com.vinayprabhakarx.jdbc;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;

public class ResetStudentTable {
    public static void main(String[] args) {
        String dropTableQuery = "DROP TABLE IF EXISTS student";

        String createTableQuery = """
                CREATE TABLE student (
                    student_id INT PRIMARY KEY,
                    first_name VARCHAR(50) NOT NULL,
                    last_name VARCHAR(50) NOT NULL,
                    gender VARCHAR(10) NOT NULL,
                    date_of_birth DATE NOT NULL,
                    email VARCHAR(100) NOT NULL UNIQUE,
                    course VARCHAR(50) NOT NULL,
                    admission_date DATE NOT NULL
                )
                """;

        String insertQuery = "INSERT INTO student " +
                "(student_id, first_name, last_name, gender, date_of_birth, email, course, admission_date) " +
                "VALUES (?, ?, ?, ?, ?, ?, ?, ?)";

        Object[][] students = {
                {101, "Vinay", "Prabhakar", "Male", "2001-05-12", "vinay@gmail.com", "Java", "2024-07-01"},
                {102, "Amit", "Kumar", "Male", "2000-09-21", "amit@gmail.com", "Python", "2024-07-02"},
                {103, "Priya", "Sharma", "Female", "2002-01-15", "priya@gmail.com", "MySQL", "2024-07-03"},
                {104, "Neha", "Singh", "Female", "2001-11-30", "neha@gmail.com", "Spring Boot", "2024-07-04"},
                {105, "Rahul", "Verma", "Male", "1999-03-18", "rahul@gmail.com", "React", "2024-07-05"},
                {106, "Kunal", "Kumar", "Male", "2002-12-12", "kunal@mail.com", "Java", "2024-07-06"},
        };

        try (Connection connection = MySqlConnection.getConnection();
             Statement statement = connection.createStatement();
             PreparedStatement preparedStatement = connection.prepareStatement(insertQuery)) {

            statement.executeUpdate(dropTableQuery);
            System.out.println("Old student table dropped.");

            statement.executeUpdate(createTableQuery);
            System.out.println("New student table created.");

            for (Object[] student : students) {
                preparedStatement.setInt(1, (int) student[0]);
                preparedStatement.setString(2, (String) student[1]);
                preparedStatement.setString(3, (String) student[2]);
                preparedStatement.setString(4, (String) student[3]);
                preparedStatement.setString(5, (String) student[4]);
                preparedStatement.setString(6, (String) student[5]);
                preparedStatement.setString(7, (String) student[6]);
                preparedStatement.setString(8, (String) student[7]);
                preparedStatement.addBatch();
            }

            int[] insertedRows = preparedStatement.executeBatch();
            System.out.println(insertedRows.length + " fresh student records inserted.");
        } catch (SQLException e) {
            System.out.println("Database operation failed: " + e.getMessage());
        }
    }
}
