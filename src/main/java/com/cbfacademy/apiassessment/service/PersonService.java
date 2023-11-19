package com.cbfacademy.apiassessment.service;


import java.util.List;
import java.util.Optional;
import java.util.UUID;
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

    /**
     * Get a user by id
     * @param userId
     * @return user
     */
    Optional <User> getUserById(UUID userId);

    /**
     * Delete user by id
     * @param userId
     */
    void deleteUserById(UUID userId);

    /**
     * Update the user with the specify id
     * @param user
     * @param userId
     */
    void updateUserById(User user, UUID userId);
    
    /**
     * Search the list of users and return the user with the specify key element.
     * @param key
     * @return user
     */
    List<User> searchUser(String key);

}
