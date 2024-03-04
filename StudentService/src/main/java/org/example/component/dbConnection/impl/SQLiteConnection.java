package org.example.component.dbConnection.impl;

import org.example.component.dbConnection.DBConnection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public enum SQLiteConnection implements DBConnection {
    INSTANCE;

    private static Connection getSQLiteInstance() throws SQLException {
        String url = "jdbc:sqlite:StudentService/src/main/resources/db/student.db";
        var con = DriverManager.getConnection(url);

        return con;
    }

    //TODO переделать на дженеричный вариант
    @Override
    public Connection getDBConnection() {
        try {
            return getSQLiteInstance();
        } catch (SQLException e) {
            throw  new RuntimeException(e);
        }
    }
}
