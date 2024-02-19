package org.example;

import org.example.data.Student;

import java.util.ArrayList;
import java.util.List;

public class CacheListStudents {
    private static List<Student> students = new ArrayList<>();

    public static void addStudent(Student student){
        students.add(student);
        System.out.println("Студент "+ student + " добавлен");
    }



}
