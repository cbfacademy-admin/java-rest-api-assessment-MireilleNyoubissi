package com.cbfacademy.apiassessment.model;

import java.io.Serializable;
import java.util.UUID;

public class User implements Serializable{
    
    //adding fields
    private UUID userId;
    private String username;
    private String email;
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
