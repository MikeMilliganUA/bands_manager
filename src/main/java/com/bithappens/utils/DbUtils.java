package com.bithappens.utils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DbUtils {
    public static Connection getConnection() throws SQLException {
        try {
            Class.forName("org.postgresql.Driver");
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
        String url = "jdbc:postgresql://localhost:5432/bands_db";
        String user = "postgres";
        String password = "sacred";

        return DriverManager.getConnection(url, user, password);
    }
}
