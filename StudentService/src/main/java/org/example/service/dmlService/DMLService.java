package org.example.service.dmlService;

import org.example.data.Student;

import java.sql.Connection;
import java.util.List;

public interface DMLService {

    /**
     * This function return all ages from table Student
     * @param connection to our database
     * @return List<Integer>
     */
    public List<Integer> getAllAge(Connection connection);

    /**
     * This method returns List of Student from database
     * @param connection Connection to SQL database
     * @return List<Student>
     */
    public List<Student> getAllStudents(Connection connection);
    /**
     * This method returns List of Student names from database
     * @param connection Connection to SQL database
     * @return List<String>
     */
    public List<String> getAllNames(Connection connection);

    public List<String> getAllSecondNames(Connection connection);

    public void createStudentInDB(Student student);

}
