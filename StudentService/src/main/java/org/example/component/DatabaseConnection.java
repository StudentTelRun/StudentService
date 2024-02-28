package org.example.component;

import org.postgresql.PGProperty;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;


//TODO добавить абстракцию
public enum DatabaseConnection {
    INSTANCE;

    private static Connection getSQLiteInstance() throws SQLException {
        //url тут просто ссылка на файл, а не адрес в сети, аутентификация не поддерживается этой базой
        String url = "jdbc:sqlite:StudentService/src/main/resources/db/student.db";
        var con = DriverManager.getConnection(url);

        return con;
    }

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
    public Connection getPGConnection() throws SQLException {
        try {
            return this.getPGInstance();
        } catch (SQLException e) {
            throw  new RuntimeException(e);
        }
    }


    //тут тоже самое что и в предыдущем методе только получаем базу лайт
    public Connection getSQLiteConnection() throws SQLException {
        try {
            return this.getSQLiteInstance();
        } catch (SQLException e) {
            throw  new RuntimeException(e);
        }
    }


}
