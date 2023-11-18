package com.cbfacademy.apiassessment.exceptions;

public class AgeBadRangeException extends RuntimeException {
    
    public AgeBadRangeException() {
        super("Age should be between 18 and 60");
    }
}
