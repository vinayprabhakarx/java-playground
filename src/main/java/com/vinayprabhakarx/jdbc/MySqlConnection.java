package com.vinayprabhakarx.jdbc;

import io.github.cdimascio.dotenv.Dotenv;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class MySqlConnection {
    public static Connection getConnection() throws SQLException {
        // Load .env file.
        Dotenv dotenv = Dotenv.load();

        String url = dotenv.get("DB_URL");
        String username = dotenv.get("DB_USERNAME");
        String password = dotenv.get("DB_PASSWORD");

        if (url == null || username == null || password == null) {
            throw new SQLException("Database configuration is missing in .env file");
        }

        return DriverManager.getConnection(url, username, password);
    }
}
