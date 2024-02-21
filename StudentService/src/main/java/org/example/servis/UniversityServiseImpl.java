package org.example.servis;

import org.example.CacheListStudents;
import org.example.data.Student;

public class UniversityServiseImpl implements UniversityServise {

    @Override
    public void study() {
        for (Student student: CacheListStudents.getStudents() ) {
            student.setAge(student.getAge()+1);
            System.out.printf("Студент \"%s %s\", закончил учиться, теперь ему %d лет\n",
                    student.getName(),student.getLastName(),student.getAge());
        }
        System.out.println("За прошедший год обучение закончили " + CacheListStudents.getStudents().size()+" студентов");
    }
}
