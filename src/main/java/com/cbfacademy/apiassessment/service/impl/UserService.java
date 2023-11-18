package com.cbfacademy.apiassessment.service.impl;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.cbfacademy.apiassessment.dao.PersonDAO;
import com.cbfacademy.apiassessment.model.User;
import com.cbfacademy.apiassessment.service.PersonService;

/**
 * implementing Personservice as a user.
 */
@Service
public class UserService implements PersonService {

    private PersonDAO personDAO;

    public UserService(@Qualifier("userDAO") PersonDAO personDAO) {
        this.personDAO = personDAO;
    }

    @Override
    public List<User> getAllUsers() {
        return personDAO.readFile();
    }

    @Override
    public void createUser(User user) {
        personDAO.save(user);
    }

    @Override
    public Optional<User> getUserById(UUID userId) {
        return personDAO.readFileById(userId);
    }

    @Override
    public void deleteUserById(UUID userId) {
        personDAO.deleteAndSave(userId);
    }

    @Override
    public void updateUserById(User user, UUID userId) {
        personDAO.updateAndSaveById(user, userId);
    }
    
}
