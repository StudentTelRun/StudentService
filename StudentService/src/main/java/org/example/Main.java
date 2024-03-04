package org.example;

import org.example.component.dbConnection.impl.SQLiteConnection;
import org.example.data.Student;
import org.example.service.dmlService.DMLService;
import org.example.service.dmlService.impl.DMLServiceImpl;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;
import java.util.logging.Logger;

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
//        try (var sqlIiteConnection = DatabaseConnection.INSTANCE.getSQLiteConnection();
//             var statement = sqlIiteConnection.createStatement()) {
//            var result = statement.executeQuery("SELECT * FROM student");
//            while (result.next()) {
//                logger.info("Name from select %s".formatted(result.getString("name")));
//            }
//        }
        //все работает задание запустить код.
        //и проверить что работаее
//        PGConnection.getProperties("C:\\Users\\Cibermag\\IdeaProjects\\StudentService\\StudentService\\src\\main\\resources\\db.properties");
        DMLService dmlService = new DMLServiceImpl();
        try (Connection connection = SQLiteConnection.INSTANCE.getDBConnection()){
            List<Student> allStudents = dmlService.getAllStudents(connection);
            allStudents.forEach(System.out::println);
            List<String> allnames = dmlService.getAllNames(connection);
            allnames.forEach(System.out::println);
            List<String> allsecondNames = dmlService.getAllSecondNames(connection);
            allsecondNames.forEach(System.out::println);
//            List<Integer> result = dmlService.getAllAge(connection);
//            result.forEach(a -> logger.info(String.valueOf(a)));
//            result.forEach(System.out::println);
        }

    }
}