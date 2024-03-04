package org.example.component.dbConnection.impl;

import org.example.component.dbConnection.DBConnection;

import java.io.FileInputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public enum PGConnection implements DBConnection {
    INSTANCE;

    private static Connection getPGInstance() throws SQLException {
        String url = "jdbc:postgresql://localhost:5432/postgres";
        Properties props = new Properties();
//        PGProperty.USER.set(props, "postgres");
//        PGProperty.PASSWORD.set(props, "admin");
//        PGProperty.ASSUME_MIN_SERVER_VERSION.set(props, "10");
//        PGProperty.REPLICATION.set(props, "database");
//        PGProperty.PREFER_QUERY_MODE.set(props, "simple");
        var con = DriverManager.getConnection(url, props);

        return con;
    }

    // TODO: 04.03.2024 Проверить закрытие потока
    //private static Properties getProperties(String namefile){
    public static Properties getProperties(String namefile) {
        Properties properties = new Properties();
        try (FileInputStream fileInputStream = new FileInputStream(namefile)) {
            properties.load(fileInputStream);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return properties;
    }

    @Override
    public Connection getDBConnection() {
        try {
            return getPGInstance();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

}
