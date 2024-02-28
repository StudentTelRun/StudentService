package org.example.component;

import org.example.service.dmlService.DMLService;

import java.util.logging.Logger;

public class PG {

    private static Logger logger = Logger.getLogger(PG.class.getName());

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

    }

}
