package org.example.service.cashService;

import org.example.data.Student;

import java.util.HashMap;
import java.util.Map;

public class StudentsMap implements StudentsCash {

    private static StudentsMap INSTANCE = null;
    public StudentsCash studentsMap;

    private StudentsMap() {
    }

    public static StudentsMap GET_INSTANCE() {
        if (INSTANCE == null) {
            INSTANCE = new StudentsMap();
        }
        return INSTANCE;
    }
    public static Map<Integer, Student> getStudentsMap() {
        return Map.copyOf(STUDENTS_MAP);
    }

    private static Map<Integer, Student> STUDENTS_MAP = new HashMap<>();
    private static int COUNTER_ID = 1;
    @Override
    public void addStudent(Student student) {
        STUDENTS_MAP.put(COUNTER_ID++, student);
    }

    @Override
    public int countStudents() {
        return STUDENTS_MAP.size();
    }

    @Override
    public void showStudents() {
        for (Integer i : STUDENTS_MAP.keySet()) {
            System.out.println(STUDENTS_MAP.get(i));
        }
    }
}
