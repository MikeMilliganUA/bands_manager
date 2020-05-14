package com.bithappens.utils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DbUtils {
    public static Connection getConnection() throws SQLException {
        String url = "jdbc:postgresql://localhost:5432/bands_db";
        String user = "postgres";
        String password = "sacred";

        Connection connection = DriverManager.getConnection(url, user, password);
        return connection;
    }
}
