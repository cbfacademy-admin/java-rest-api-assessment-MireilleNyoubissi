package com.cbfacademy.apiassessment;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.cbfacademy.apiassessment.service.impl.UserService;
import java.util.List;
import com.cbfacademy.apiassessment.model.User;

@RequestMapping("api/user")
@SpringBootApplication
@RestController
public class App {

	public static void main(String[] args) {
		SpringApplication.run(App.class, args);
	}
	private final UserService userService;

    public App(UserService userService) {
        this.userService = userService;
    }

	@GetMapping("/greeting")
	public String greeting(@RequestParam(value = "name", defaultValue = "World") String name) {
		return String.format("Hello %s", name);
	}

	//Get all users 
	@GetMapping
	public List<User> getAllUser() {
        return userService.getAllUsers();
    }

}
