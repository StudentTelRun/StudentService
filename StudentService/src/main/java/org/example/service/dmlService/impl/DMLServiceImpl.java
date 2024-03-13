package org.example.service.dmlService.impl;

import org.example.component.dbConnection.impl.PGConnection;
import org.example.component.dbConnection.impl.SQLiteConnection;
import org.example.data.Student;
import org.example.service.StudentConverter;
import org.example.service.dmlService.DMLService;
import org.example.service.impl.SpecificStudConvertor;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class DMLServiceImpl implements DMLService {
    public ResultSet getResultSet(Connection connection, String sqlQuery) throws SQLException {
        Statement statement = connection.createStatement();

        return statement.executeQuery(sqlQuery);
    }

    @Override
    public List<Integer> getAllAge(Connection connection) {
        try {
            ResultSet resultSet = getResultSet(connection, "SELECT * FROM student");
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
            ResultSet resultSet = getResultSet(connection, "SELECT * FROM student");

            return studentConverter.convertResultSetToStudents(resultSet);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public List<String> getAllNames(Connection connection) {
        try {
            ResultSet resultSet = getResultSet(connection, "SELECT * FROM student");
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
            ResultSet resultSet = getResultSet(connection, "SELECT * FROM student");
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

    @Override
    public void createStudentInDB(Student student) {
        Connection connection = SQLiteConnection.INSTANCE.getDBConnection();
        try {
            String insertQuery = "INSERT INTO student (name, second_name, age) VALUES (?, ?, ?)";
            var prepareStatement = connection.prepareStatement(insertQuery);
            prepareStatement.setString(1, student.getName());
            prepareStatement.setString(2, student.getSecondName());
            prepareStatement.setInt(3, student.getAge());

            prepareStatement.executeUpdate();

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public List<Student> findStudentByAgeName(String name, int age) {
        try (Connection connection = SQLiteConnection.INSTANCE.getDBConnection()) {

            String selectQuery = "SELECT * FROM student WHERE name = ? AND age = ?";
            PreparedStatement preparedStatement = connection.prepareStatement(selectQuery);
            preparedStatement.setString(1, name);
            preparedStatement.setInt(2, age);
            ResultSet resultSet = preparedStatement.executeQuery();

            StudentConverter studentConverter = new SpecificStudConvertor();
            List<Student> students = studentConverter.convertResultSetToStudents(resultSet);

            return students;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
