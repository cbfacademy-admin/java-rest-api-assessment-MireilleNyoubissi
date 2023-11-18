package com.cbfacademy.apiassessment.exceptions;

public class AgeBadRangeException extends RuntimeException {
    
    /**
     * Represent an exception encountered when Age doesn't fulfill all requirements.
     */
    public AgeBadRangeException() {
        super("Age should be between 18 and 60");
    }
}
