package org.example.service.impl;

import org.example.data.Student;
import org.example.data.dto.StudentDto;
import org.example.service.StudentConverter;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.time.Period;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

public class SpecificStudConvertor implements StudentConverter {

    @Override
    public Student convertDTOToStudent(StudentDto studentDto) {
        Student student = new Student();
        student.setName(studentDto.getName());
        student.setSecondName(studentDto.getSecondName());

        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy");
        LocalDate birthDate = LocalDate.parse(studentDto.getDateOfBirth(), formatter);
        LocalDate currentDate = LocalDate.now();
        Period period = Period.between(birthDate, currentDate);
        student.setAge(period.getYears());

        return student;
    }

    @Override
    public List<Student> convertResultSetToStudents(ResultSet resultSet) {
        try {
            List<Student> students = new ArrayList<>();
            var metaData = resultSet.getMetaData();
            int columnCount = metaData.getColumnCount();

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
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
