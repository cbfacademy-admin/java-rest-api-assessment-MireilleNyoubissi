package com.cbfacademy.apiassessment;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cbfacademy.apiassessment.service.impl.UserService;

import jakarta.validation.Valid;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

import com.cbfacademy.apiassessment.dto.NewUserDto;
import com.cbfacademy.apiassessment.exceptions.AgeBadRangeException;
import com.cbfacademy.apiassessment.exceptions.BadEmailAddressException;
import com.cbfacademy.apiassessment.exceptions.UserNotFoundException;
import com.cbfacademy.apiassessment.exceptions.UsernameBadLengthException;
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
	public ResponseEntity<User> createUser(@Valid @RequestBody NewUserDto user) {
		if (user.username.length() > 100 || user.username.length() < 2)
            throw new UsernameBadLengthException();
        if (user.age < 18 || user.age > 60)
            throw new AgeBadRangeException();
        if (!user.email.contains("@") || !user.email.contains("."))
            throw new BadEmailAddressException();

		User newUser = new User(null, user.username, user.email, user.age);
        userService.createUser(newUser);
		return new ResponseEntity<>(newUser, HttpStatus.CREATED);
    }

	//Get all users 
	@GetMapping
	public List<User> getAllUser() {
        return userService.getAllUsers();
    }

	//Get a user by its id
	@GetMapping(path = "{id}")
	public ResponseEntity<Optional<User>> getUserById(@PathVariable("id") UUID userId) {
		Optional<User> user = userService.getUserById(userId);
		System.out.println(user.isPresent());
        if (!user.isPresent()) {
            throw new UserNotFoundException(userId.toString());
        }
		return ResponseEntity.ok(user);
	}

	@DeleteMapping(path = "{id}")
    public ResponseEntity<String> deleteUserById(@Valid @PathVariable("id") UUID userId) {
        userService.deleteUserById(userId);
		return new ResponseEntity<>("User was deleted successfully.", HttpStatus.OK);
	}

	//Update the user with the specify id
	@PutMapping(path = "{id}")
    public ResponseEntity<String> updateUserById(@Valid @RequestBody User user, @PathVariable("id") UUID userId) {
        userService.updateUserById(user, userId);
		return new ResponseEntity<>("User has been updated successfully.", HttpStatus.OK);
    }

}
