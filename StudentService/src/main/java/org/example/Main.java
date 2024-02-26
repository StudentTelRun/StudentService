package org.example;

import org.example.data.Student;
import org.example.service.Uni;
import org.example.service.cashService.StudentsMap;

public class Main {
    public static void main(String[] args) {
//        // Дата в строковом формате
//        String dateString = "29-04-1993";
//e
//        // Форматтер для преобразования строки в LocalDate
//        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy");
//
//        // Преобразование строки в LocalDated
//        LocalDate birthDate = LocalDate.parse(dateString, formatter);e
//
//        // Текущая дата
//        LocalDate currentDate = LocalDate.now();
//
//        // Расчет периода между датами
//        Period period = Period.between(birthDate, currentDate);
//
//        // Вывод количества лет
//        System.out.println("Возраст: " + period.getYears() + " лет");

        StudentsMap studentsMap = StudentsMap.GET_INSTANCE();
        studentsMap.addStudent(new Student("Alex", "A", 20));
        studentsMap.addStudent(new Student("Ben", "B", 23));
        studentsMap.addStudent(new Student("Clark", "C", 25));

        Uni uni = new Uni();
        uni.study();
    }
}