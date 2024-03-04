package org.example.data;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import lombok.experimental.FieldNameConstants;

@Setter
@Getter
@ToString
@FieldNameConstants
public class Student {

    private String name;
    private String secondName;
    private int age;

    public Student(String name, String secondName, int age) {
        this.name = name;
        this.secondName = secondName;
        this.age = age;
    }

    public Student() {
    }
}
