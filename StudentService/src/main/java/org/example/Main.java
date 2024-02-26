package org.example;

import org.example.component.DatabaseConnection;
import org.example.data.Student;
import org.example.service.Uni;
import org.example.service.cashService.StudentsMap;
import org.example.service.dmlService.impl.PostgreDML;

import java.sql.SQLException;
import java.util.logging.Logger;

import static java.util.logging.Level.INFO;

public class Main {

    private static Logger logger = Logger.getLogger(Main.class.getName());

    public static void main(String[] args) throws SQLException {
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

    /*    StudentsMap studentsMap = StudentsMap.GET_INSTANCE();
        studentsMap.addStudent(new Student("Alex", "A", 20));
        studentsMap.addStudent(new Student("Ben", "B", 23));
        studentsMap.addStudent(new Student("Clark", "C", 25));

        Uni uni = new Uni();
        uni.study();*/

        //пример того как не правильно генерит AI
        try (var sqlIiteConnection = DatabaseConnection.INSTANCE.getSQLiteConnection();
             var statement = sqlIiteConnection.createStatement()) {
            var result = statement.executeQuery("SELECT * FROM student");
            while (result.next()) {
                logger.info("Name from select %s".formatted(result.getString("name")));
            }
        }
        //все работает задание запустить код.
        //и проверить что работаее


    }
}