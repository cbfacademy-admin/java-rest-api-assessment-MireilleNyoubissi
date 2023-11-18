package com.cbfacademy.apiassessment.dto;



public class NewUserDto {
    public String username;
    public int age;
    public String email;

    public NewUserDto(String username, int age, String email) {
        this.age = age;
        this.username = username;
        this.email = email;
    }
}