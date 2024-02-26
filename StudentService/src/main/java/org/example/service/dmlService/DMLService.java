package org.example.service.dmlService;

import java.util.List;

public interface DMLService {

    /**
     * This function return all ages from table Student
     * @return List<Integer>
     */
    public List<Integer> getAllAge();
    public String[] getAllNames();
    public String[] getAllSecondNames();

    // .....
}
