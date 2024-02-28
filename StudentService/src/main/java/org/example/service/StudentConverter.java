package org.example.service;

import org.example.data.Student;
import org.example.data.dto.StudentDto;

// TODO Add abstraction
public interface StudentConverter {
    Student convertToStudent(StudentDto studentDto);
}
