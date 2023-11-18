package com.cbfacademy.apiassessment.exceptions;

public class UsernameBadLengthException extends RuntimeException{
        public UsernameBadLengthException() {
                super("Name length is between 2 and 100");
        }
}
