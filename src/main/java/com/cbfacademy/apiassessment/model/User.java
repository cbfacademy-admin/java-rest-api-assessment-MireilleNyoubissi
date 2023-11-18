package com.cbfacademy.apiassessment.model;

import java.io.Serializable;
import java.util.UUID;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.Size;

public class User implements Serializable{
    
    //adding fields
    private UUID userId;
    @Size(min = 2, message = "Name should have at least two characters")
    private String username;
    @Email(message = "Please provide a valid email address ex: username@domain.com")
    private String email;
    @Min(value = 18, message = "Age should not be less than 18")
    @Max(value = 100, message = "Age should not be greater than 100")
    private int age;

    //adding parameterized constructor
    public User(UUID id, String username, String email, int age) {
        this.userId = id;
        if (id == null) {
            this.userId = UUID.randomUUID();
        }
        this.username = username;
        this.email = email;
        this.age = age;
    }

    //adding getters
   
    public UUID getUserId() {
        return userId;
    }

    public String getUsername() {
        return username;
    }

    public String getEmail() {
        return email;
    }

    public int getAge() {
        return age;
    }

}
