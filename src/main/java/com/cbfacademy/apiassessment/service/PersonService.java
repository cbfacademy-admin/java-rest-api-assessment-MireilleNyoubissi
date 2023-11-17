package com.cbfacademy.apiassessment.service;


import java.util.List;
import com.cbfacademy.apiassessment.model.User;

/**
 * Support all types of CRUD operation for creating a user object (Ex: user, admin).
 */
public interface PersonService {

    /**
     * Get all users
     * @return all users
     */
    List<User> getAllUsers();
    
    /**
     * Create a user
     * @param user
     */

    void createUser(User user);
    
}
