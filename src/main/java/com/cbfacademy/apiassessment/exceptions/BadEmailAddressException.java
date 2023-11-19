package com.cbfacademy.apiassessment.exceptions;

public class BadEmailAddressException extends RuntimeException {

    /**
     * represent an exception encountered when email isn't in the right format.
     */
    public BadEmailAddressException() {
        super("Email address should contain 1 '@' and at least 1 '.' ex: username@domain.com");
    }
    
}
