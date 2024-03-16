package org.example.service;

import org.example.data.Student;
import org.example.data.dto.StudentDto;

import java.sql.ResultSet;
import java.util.List;

public interface StudentConverter {

    /**
     * Converts student DTO to Student
     * @param studentDto StudentDto object
     * @return Student
     */
    Student convertDTOToStudent(StudentDto studentDto);

    /**
     * Composes Student object from the database selection
     * @param resultSet receives ResultSet from database
     * @return Student
     */
    List<Student> convertResultSetToStudents(ResultSet resultSet);
}

