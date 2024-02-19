package org.example;

import org.example.data.Student;
import org.example.data.dto.StudentDTO;
import org.example.servis.Convert;
import org.example.servis.ConverterStudent;

import java.time.LocalDate;
import java.time.Period;
import java.time.format.DateTimeFormatter;

public class Main {
    public static void main(String[] args) {
        // Дата в строковом формате
        String dateString = "29-04-1993";

//        // Форматтер для преобразования строки в LocalDate
//        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy");
//
//        // Преобразование строки в LocalDate
//        LocalDate birthDate = LocalDate.parse(dateString, formatter);
//
//        // Текущая дата
//        LocalDate currentDate = LocalDate.now();
//
//        // Расчет периода между датами
//        Period period = Period.between(birthDate, currentDate);
//
//        // Вывод количества лет
//        System.out.println("Возраст: " + period.getYears() + " лет");
        StudentDTO studentDTO = new StudentDTO("Jon","Smit", dateString);
        ConverterStudent convert = new Convert();
        Student student = convert.convertToStudent(studentDTO);
        System.out.println(student);
    }
}