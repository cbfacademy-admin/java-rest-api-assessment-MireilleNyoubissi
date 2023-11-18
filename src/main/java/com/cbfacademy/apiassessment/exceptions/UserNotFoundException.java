package com.cbfacademy.apiassessment.exceptions;

public class UserNotFoundException extends RuntimeException {

    /**
     * Represent an exception encountered when the  user with the specified id doesn't exist.
     * @param id
     */
    public UserNotFoundException(String id) {
        super(String.format("User with id: '%s' was not found", id ));
    }
    
}
