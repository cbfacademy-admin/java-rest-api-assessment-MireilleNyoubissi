package com.cbfacademy.apiassessment.dao;

import java.util.List;
import com.cbfacademy.apiassessment.model.User;


/**
 * Support all types of data access that a person (Ex: user, admin) using our blog app can have with our JSON file. 
 */
public interface PersonDAO {

    /**
     * Read JSON file and return a list of users.
     */
    List<User> readFile();

    /**
     * Add and save user in the JSON file.
     * @param user
     */
    void save(User user);

}
