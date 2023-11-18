package com.cbfacademy.apiassessment;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.cbfacademy.apiassessment.service.impl.UserService;
import java.util.List;
import java.util.Optional;
import java.util.UUID;
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

	// @GetMapping("/greeting")
	// public String greeting(@RequestParam(value = "name", defaultValue = "World") String name) {
	// 	return String.format("Hello %s", name);
	// }

	//Create a user via a post request
	@PostMapping
	public void createUser(@RequestBody User user) {
        userService.createUser(user);
    }

	//Get all users 
	@GetMapping
	public List<User> getAllUser() {
        return userService.getAllUsers();
    }

	//Get a user by its id
	@GetMapping(path = "{id}")
	public Optional<User> getUserById(@PathVariable("id") UUID userId) {
		return userService.getUserById(userId);
	}

	@DeleteMapping(path = "{id}")
    public void deleteUserById(@PathVariable("id") UUID userId) {
        userService.deleteUserById(userId);
	}



}
