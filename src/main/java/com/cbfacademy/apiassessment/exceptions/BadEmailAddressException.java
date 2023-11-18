package com.cbfacademy.apiassessment.exceptions;

public class BadEmailAddressException extends RuntimeException {

    public BadEmailAddressException() {
        super("Email address should contain 1 '@' and at least 1 '.' ex: username@domain.com");
    }
    
}
