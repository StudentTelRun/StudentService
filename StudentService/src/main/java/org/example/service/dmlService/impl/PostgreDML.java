package org.example.service.dmlService.impl;

import org.example.component.PGConnection;
import org.example.service.dmlService.DMLService;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class PostgreDML implements DMLService {
    private ResultSet getResultSet(Connection connection) throws SQLException {
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery("SELECT * FROM student");

            return resultSet;
    }

    @Override
    public List<Integer> getAllAge() {
        try (Connection con = PGConnection.INSTANCE.getConnection();
             ResultSet resultSet = getResultSet(con)) {
            List<Integer> ages = new ArrayList<>();

            while (resultSet.next()) {
                // Обработка результатов, например:
                String age = resultSet.getString("age");
                Integer ageInt = Integer.parseInt(age);
                ages.add(ageInt);
            }

            return ages;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

        @Override
    public String[] getAllNames() {
        return new String[0];
    }

    @Override
    public String[] getAllSecondNames() {
        return new String[0];
    }
}
