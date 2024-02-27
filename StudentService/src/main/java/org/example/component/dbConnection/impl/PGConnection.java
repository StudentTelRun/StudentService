package org.example.component.dbConnection.impl;

import org.example.component.dbConnection.DBConnection;
import org.postgresql.PGProperty;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;


//TODO добавить абстрацию
public enum PGConnection implements DBConnection {
    INSTANCE;

    private static Connection getPGInstance() throws SQLException {
        String url = "jdbc:postgresql://localhost:5432/postgres";
        Properties props = new Properties();
        PGProperty.USER.set(props, "postgres");
        PGProperty.PASSWORD.set(props, "admin");
        PGProperty.ASSUME_MIN_SERVER_VERSION.set(props, "10");
        PGProperty.REPLICATION.set(props, "database");
        PGProperty.PREFER_QUERY_MODE.set(props, "simple");
        var con = DriverManager.getConnection(url, props);

        return con;
    }

    //TODO переделать на дженеричный вариант
    @Override
    public Connection getDBConnection() {
        try {
            return getPGInstance();
        } catch (SQLException e) {
            throw  new RuntimeException(e);
        }
    }
}
