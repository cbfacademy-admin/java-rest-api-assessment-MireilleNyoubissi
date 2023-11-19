package com.cbfacademy.apiassessment.model;

import java.time.LocalDateTime;

public class ErrorDetails {
    
    private LocalDateTime timeStamp;
    private String message;
    private String details;

    /**
     * Represent the error message format that the consumer will get when dealing with the REST API.
     * @param timeStamp
     * @param message
     * @param details
     */
    public ErrorDetails(LocalDateTime timeStamp, String message, String details) {
        this.timeStamp = timeStamp;
        this.message = message;
        this.details = details;
    }

    public LocalDateTime getTimeStamp() {
        return timeStamp;
    }

    public String getMessage() {
        return message;
    }

    public String getDetails() {
        return details;
    }
}
