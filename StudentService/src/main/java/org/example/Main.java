package org.example;

import org.example.data.Student;
import org.example.data.dto.StudentDTO;
import org.example.servis.Convert;
import org.example.servis.ConverterStudent;
import org.example.servis.UniversityServise;
import org.example.servis.UniversityServiseImpl;

import java.time.LocalDate;
import java.time.Period;
import java.time.format.DateTimeFormatter;

public class Main {
    public static void main(String[] args) {
        // Дата в строковом формате
        String dateString1 = "29-04-1995";
        String dateString2 = "29-05-1993";
        String dateString3 = "29-06-1997";

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
        StudentDTO studentDTO1 = new StudentDTO("Jon","Smit", dateString1);
        StudentDTO studentDTO2 = new StudentDTO("Bill","Smit", dateString2);
        StudentDTO studentDTO3 = new StudentDTO("Georg","Smit", dateString3);
        ConverterStudent convert = new Convert();
        Student student1 = convert.convertToStudent(studentDTO1);
        Student student2 = convert.convertToStudent(studentDTO2);
        Student student3 = convert.convertToStudent(studentDTO3);
        System.out.println(student1);
        CacheListStudents.addStudent(student1);
        CacheListStudents.addStudent(student2);
        CacheListStudents.addStudent(student3);
        UniversityServise university = new UniversityServiseImpl();
        university.study();
    }
}