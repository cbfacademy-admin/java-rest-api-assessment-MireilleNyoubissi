package com.cbfacademy.apiassessment.exceptions;

public class UsernameBadLengthException extends RuntimeException{

        /**
         * Represent an exception encountered when username isn't the correct length.
         */
        public UsernameBadLengthException() {
                super("Name length is between 2 and 100");
        }
}
