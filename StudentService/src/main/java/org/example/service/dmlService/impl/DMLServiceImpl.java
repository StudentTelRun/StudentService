package org.example.service.dmlService.impl;

import org.example.data.Student;
import org.example.service.StudentConverter;
import org.example.service.dmlService.DMLService;
import org.example.service.impl.SpecificStudConvertor;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class DMLServiceImpl implements DMLService {
    public ResultSet getResultSet(Connection connection) throws SQLException {
        Statement statement = connection.createStatement();

        return statement.executeQuery("SELECT * FROM student");
    }

    @Override
    public List<Integer> getAllAge(Connection connection) {
        try {
            ResultSet resultSet = getResultSet(connection);
            List<Integer> ages = new ArrayList<>();
            while (resultSet.next()) {
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
    public List<Student> getAllStudents(Connection connection) {
        StudentConverter studentConverter = new SpecificStudConvertor();
        try {
            ResultSet resultSet = getResultSet(connection);

            return studentConverter.convertResultSetToStudents(resultSet);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public List<String> getAllNames(Connection connection) {
        try {
            ResultSet resultSet = getResultSet(connection);
            List<String> names = new ArrayList<>();
            while (resultSet.next()) {
                String name = resultSet.getString("name");
                names.add(name);
            }

            return names;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public List<String> getAllSecondNames(Connection connection) {
        try {
            ResultSet resultSet = getResultSet(connection);
            List<String> secondNames = new ArrayList<>();
            while (resultSet.next()) {
                String secondName = resultSet.getString("second_name");
                secondNames.add(secondName);
            }

            return secondNames;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
