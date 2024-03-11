package org.example.http;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.sun.net.httpserver.HttpExchange;
import com.sun.net.httpserver.HttpHandler;
import com.sun.net.httpserver.HttpServer;
import org.example.component.dbConnection.impl.SQLiteConnection;
import org.example.data.Student;
import org.example.data.dto.StudentDto;
import org.example.service.StudentConverter;
import org.example.service.dmlService.DMLService;
import org.example.service.dmlService.impl.DMLServiceImpl;
import org.example.service.impl.SpecificStudConvertor;

import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.InetSocketAddress;
import java.sql.Connection;
import java.util.List;

public class HttpExample {


    public static void main(String[] args) throws IOException {
        // Создание HTTP сервера на порту 8000
        HttpServer server = HttpServer.create(new InetSocketAddress(8000), 0);
        final Connection connection = SQLiteConnection.INSTANCE.getDBConnection();
        final DMLService dmlService = new DMLServiceImpl();
        final ObjectMapper objectMapper = new ObjectMapper();
        final StudentConverter studentConverter = new SpecificStudConvertor();


        // Установка обработчика для пути /getUser

        server.createContext("/getStudents", new HttpHandler() {
            @Override
            public void handle(HttpExchange exchange) throws IOException {
                if ("GET".equals(exchange.getRequestMethod())) {

                    //Ищем всех студентов
                    List<Student> students = dmlService.getAllStudents(connection);

                    //Преобразуем список студентов в JSON
                    String jsonResponse = objectMapper.writeValueAsString(students);

                    exchange.getResponseHeaders().set("Content-Type", "application/json");
                    exchange.sendResponseHeaders(200, jsonResponse.getBytes().length);
                    try (OutputStream os = exchange.getResponseBody()) {
                        os.write(jsonResponse.getBytes());
                    }
                } else {
                    String response = "Только GET метод разрешен";
                    exchange.sendResponseHeaders(405, response.getBytes().length);
                    try (OutputStream os = exchange.getResponseBody()) {
                        os.write(response.getBytes());
                    }
                }
            }
        });


        // Установка обработчика для пути /createUser
        server.createContext("/createStudent", new HttpHandler() {
            @Override
            public void handle(HttpExchange exchange) throws IOException {
                if ("POST".equals(exchange.getRequestMethod())) {
                    // Десериализация JSON из тела запроса в StudentDto
                    InputStreamReader isr = new InputStreamReader(exchange.getRequestBody(), "utf-8");
                    StudentDto studentDto = objectMapper.readValue(isr, StudentDto.class);
                    Student student = studentConverter.convertDTOToStudent(studentDto);
                    dmlService.createStudentInDB(student);
                    // сериализация объекта Student в JSON строку
                    String responseJsn = objectMapper.writeValueAsString(student);
                    exchange.sendResponseHeaders(200, responseJsn.getBytes().length);
                    try (OutputStream os = exchange.getResponseBody()) {
                        os.write(responseJsn.getBytes());
                    }
                } else {
                    // Возвращение ошибки, если метод не POST
                    String response = "Только POST метод разрешен";
                    exchange.sendResponseHeaders(405, response.getBytes().length);
                    try (OutputStream os = exchange.getResponseBody()) {
                        os.write(response.getBytes());
                    }
                }
            }
        });

        // Запуск сервера
        server.start();
        System.out.println("Сервер запущен на порту 8000. Используйте /getStudents для GET запросов и /createStudent для POST запросов.");
    }
}



