package org.example.service;


import org.example.data.Student;
import org.example.service.UniService;
import org.example.service.cashService.StudentsMap;

public class Uni implements UniService {
    StudentsMap studentsMap = StudentsMap.GET_INSTANCE();
    @Override
    public void study() {
        for (Integer i : StudentsMap.getStudentsMap().keySet()) {
            Student student = StudentsMap.getStudentsMap().get(i);
            System.out.println(student.getName() + " is studying. It is " + student.getAge());
            student.setAge(student.getAge() + 1);
        }
        System.out.println("The end of the year of study");
        studentsMap.showStudents();
        System.out.println(studentsMap.countStudents() + " students has ended a year");
    }
}
