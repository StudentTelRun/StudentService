package org.example.data;

public class Student {
    private String name;
    private String lastName;
    private int Age;

    public Student(String name, String lastName, int age) {
        this.name = name;
        this.lastName = lastName;
        Age = age;
    }

    @Override
    public String toString() {
        return "Student{" +
                "name='" + name + '\'' +
                ", lastName='" + lastName + '\'' +
                ", Age=" + Age +
                '}';
    }
}
