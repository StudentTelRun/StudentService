package org.example.servis;

import org.example.data.Student;
import org.example.data.dto.StudentDTO;

import java.time.LocalDate;
import java.time.Period;
import java.time.format.DateTimeFormatter;

public class Convert implements ConverterStudent{
    @Override
    public Student convertToStudent(StudentDTO studentDTO) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy");

        // Преобразование строки в LocalDate
        LocalDate birthDate = LocalDate.parse(studentDTO.getBirdthDate(), formatter);

        // Текущая дата
        LocalDate currentDate = LocalDate.now();

        // Расчет периода между датами
        Period period = Period.between(birthDate, currentDate);

        return new Student(studentDTO.getName(),studentDTO.getLastName(),period.getYears());
    }
}
