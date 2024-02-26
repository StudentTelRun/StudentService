package org.example.component;

import org.postgresql.PGProperty;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public enum PGConnection {
    INSTANCE;

    private static Connection getInstance() throws SQLException {
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

    public Connection getConnection() throws SQLException {
        try {
            return this.getInstance();
        } catch (SQLException e) {
            throw  new RuntimeException(e);
        }
    }
}
