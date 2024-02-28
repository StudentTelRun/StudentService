package org.example.service.dmlService;

import org.example.data.Student;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

public interface DMLService {

    /**
     * This function return all ages from table Student
     *
     * @param connection to our database
     * @return List<Integer>
     */
    public List<Integer> getAllAge(Connection connection) throws SQLException; // TODO remove exceptions and move to impl

    public List<Student> getAllStudents(Connection connection) throws SQLException;// TODO remove exceptions and move to impl

    public String[] getAllNames();

    public String[] getAllSecondNames();

    // .....
}
