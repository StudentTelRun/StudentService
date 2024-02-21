package org.example;

import lombok.Getter;
import org.example.data.Student;

import java.util.ArrayList;
import java.util.List;

public class CacheListStudents {
    private static List<Student> students = new ArrayList<>();

    public static void addStudent(Student student){
        students.add(student);
        System.out.printf("Студент \"%s %s\", возраст: %d лет - Принят в университет\n",
                student.getName(),
                student.getLastName(),
                student.getAge());
    }

    public static List<Student> getStudents() {
        return List.copyOf(students) ;
    }


}
