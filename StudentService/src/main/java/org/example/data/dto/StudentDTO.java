package org.example.data.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.time.LocalDate;

//@Setter
//@Getter
//@AllArgsConstructor
//@ToString
public class StudentDTO {
    private String name;
    private String lastName;
    private String BirdthDate;

    public String getName() {
        return name;
    }

    public String getLastName() {
        return lastName;
    }

    public String getBirdthDate() {
        return BirdthDate;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public void setBirdthDate(String birdthDate) {
        BirdthDate = birdthDate;
    }

    @Override
    public String toString() {
        return "StudentDTO{" +
                "name='" + name + '\'' +
                ", lastName='" + lastName + '\'' +
                ", BirdthDate='" + BirdthDate + '\'' +
                '}';
    }

    public StudentDTO(String name, String lastName, String birdthDate) {
        this.name = name;
        this.lastName = lastName;
        BirdthDate = birdthDate;
    }
}
