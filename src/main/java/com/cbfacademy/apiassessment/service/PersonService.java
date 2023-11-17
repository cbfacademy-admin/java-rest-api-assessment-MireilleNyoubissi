package com.cbfacademy.apiassessment.service;


import java.util.List;
import com.cbfacademy.apiassessment.model.User;

/**
 * Support all types of CRUD operation for creating a user object (Ex: user, admin).
 */
public interface PersonService {

    /**
     *
     * @return all users
     */
    List<User> getAllUsers();
    
}
