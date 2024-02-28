package org.example.service.dmlService.impl;

import org.example.component.DatabaseConnection;
import org.example.data.Student;
import org.example.service.dmlService.DMLService;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class DMLServiceImpl implements DMLService {
    public ResultSet getResultSet(Connection connection) throws SQLException {
        Statement statement = connection.createStatement();
        ResultSet resultSet = statement.executeQuery("SELECT * FROM student");

        return resultSet;
    }

    @Override
    public List<Integer> getAllAge(Connection connection) throws SQLException {

        ResultSet resultSet = getResultSet(connection);
        List<Integer> ages = new ArrayList<>();

        while (resultSet.next()) {
            // Обработка результатов, например:
            String age = resultSet.getString("age");
            Integer ageInt = Integer.parseInt(age);
            ages.add(ageInt);
        }

        return ages;

    }

    @Override
    public List<Student> getAllStudents(Connection connection) throws SQLException {
        ResultSet resultSet = getResultSet(connection);
        List<Student> students = new ArrayList<>();
        var metaData = resultSet.getMetaData();
        int columnCount = metaData.getColumnCount();

        // TODO Create convertor to Students (example: specificStudentconvertor
        while (resultSet.next()) {
            Student student = new Student();
            for (int i = 1; i <= columnCount; i++) {
                String columnName = metaData.getColumnName(i);

                if ("name".equals(columnName)) {
                    student.setName((String) resultSet.getObject(i));
                } else if ("secondName".equals(columnName)) {
                    student.setSecondName((String) resultSet.getObject(i));
                } else if ("age".equals(columnName)) {
                    student.setAge((Integer) resultSet.getObject(i));
                } else {
                    System.out.println("Undefined field: " + columnName);
                }
            }
            students.add(student);
        }
        return students;
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
