package org.example.service.cashService;

import org.example.data.Student;

import java.util.HashMap;
import java.util.Map;

public class StudentsMap implements StudentsCash {
    public static Map<Integer, Student> STUDENTS_MAP = new HashMap<>();
    private static int COUNTER_ID = 1;
    @Override
    public void addStudent(Student student) {
        STUDENTS_MAP.put(COUNTER_ID++, student);
    }
}
