package com.cbfacademy.apiassessment.dao;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

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

    /**
     * Read JSON file by User id and return the user.
     * @param userId
     * @return user
     */
    Optional<User> readFileById(UUID userId);

    /**
     * Remove the object with specify id from file.
     * @param userId
     */

    void deleteAndSave(UUID userId);


}
