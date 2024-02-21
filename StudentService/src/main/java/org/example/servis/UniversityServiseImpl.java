package org.example.servis;

import org.example.CacheListStudents;
import org.example.data.Student;

public class UniversityServiseImpl implements UniversityServise {

    @Override
    public void study() {
        for (Student student: CacheListStudents.getStudents() ) {
            student.setAge(student.getAge()+1);
            System.out.printf("Студент %s, учится \n", student);
        }
        System.out.println("Запрошедший год обучение закончили " + CacheListStudents.getStudents().size()+" студентов");
    }
}
