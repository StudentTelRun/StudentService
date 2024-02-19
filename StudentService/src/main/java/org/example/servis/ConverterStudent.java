package org.example.servis;

import org.example.data.Student;
import org.example.data.dto.StudentDTO;

public interface ConverterStudent {
    Student convertToStudent(StudentDTO studentDTO);

}


