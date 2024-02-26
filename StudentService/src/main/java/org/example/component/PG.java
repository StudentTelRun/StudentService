package org.example.component;

import org.postgresql.PGProperty;

import java.sql.*;
import java.util.Properties;

public class PG {

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


    private static void exmaple() {
        try (Connection connection = getInstance();
             Statement statement = connection.createStatement()){


            ResultSet resultSet = statement.executeQuery("SELECT * FROM student");
            while (resultSet.next()) {
                // Обработка результатов, например:
                System.out.println(resultSet.getString("name"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }


 /*   INSERT - Вставка данных в таблицу:

    java
    Copy code
try {
        PGConnection connection = getInstance();
        Statement statement = connection.createStatement();
        String sql = "INSERT INTO user (column1, column2) VALUES ('value1', 'value2')";
        statement.executeUpdate(sql);
    } catch (SQLException e) {
        e.printStackTrace();
    }
    UPDATE - Обновление данных в таблице:

    java
    Copy code
try {
        PGConnection connection = getInstance();
        Statement statement = connection.createStatement();
        String sql = "UPDATE user SET column1 = 'new_value' WHERE condition";
        statement.executeUpdate(sql);
    } catch (SQLException e) {
        e.printStackTrace();
    }
    DELETE - Удаление данных из таблицы:

    java
    Copy code
try {
        PGConnection connection = getInstance();
        Statement statement = connection.createStatement();
        String sql = "DELETE FROM user WHERE condition";
        statement.executeUpdate(sql);
    } catch (SQLException e) {
        e.printStackTrace();
    }*/


    /*
    * по всем колонкам пройти
    * try (Connection connection = getInstance();
     Statement statement = connection.createStatement();
     ResultSet resultSet = statement.executeQuery("SELECT * FROM user")) {

    ResultSetMetaData metaData = resultSet.getMetaData();
    int columnCount = metaData.getColumnCount();

    while (resultSet.next()) {
        for (int i = 1; i <= columnCount; i++) {
            String columnName = metaData.getColumnName(i);
            Object value = resultSet.getObject(i);
            System.out.println(columnName + ": " + value);
        }
        System.out.println("---------------------");
    }
} catch (SQLException e) {
    e.printStackTrace();
}
    *
    * */


    public static void main(String[] args) {
        exmaple();
    }

}
