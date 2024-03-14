package org.example.data.dto;

public class StudentDto {
    private String name;
    private String secondName;
    private String dateOfBirth;

    public StudentDto(String name, String secondName, String dateOfBirth) {
        this.name = name;
        this.secondName = secondName;
        this.dateOfBirth = dateOfBirth;
    }

    public StudentDto() {
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setSecondName(String secondName) {
        this.secondName = secondName;
    }

    public void setDateOfBirth(String dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public String getName() {
        return name;
    }

    public String getSecondName() {
        return secondName;
    }

    public String getDateOfBirth() {
        return dateOfBirth;
    }

    @Override
    public String toString() {
        return "StudentDto{" +
                "name='" + name + '\'' +
                ", secondName='" + secondName + '\'' +
                ", dateOfBirth='" + dateOfBirth + '\'' +
                '}';
    }
}
