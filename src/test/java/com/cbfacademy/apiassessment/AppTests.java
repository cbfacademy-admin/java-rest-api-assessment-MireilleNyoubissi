package com.cbfacademy.apiassessment;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.test.web.server.LocalServerPort;
import org.springframework.context.annotation.Description;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import com.cbfacademy.apiassessment.model.User;

import static org.junit.jupiter.api.Assertions.*;

import java.math.BigDecimal;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

@SpringBootTest(classes = App.class, webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class AppTests {

	@LocalServerPort
	private int port;

	private URL base;

	@Autowired
	private TestRestTemplate restTemplate;

	@BeforeEach
	public void setUp() throws Exception {
		this.base = new URL("http://localhost:" + port + "/api/user");
	}

	// @Test
	// @Description("/greeting endpoint returns expected response for default name")
	// public void greeting_ExpectedResponseWithDefaultName() {
	// 	ResponseEntity<String> response = restTemplate.getForEntity(base.toString(), String.class);

	// 	assertEquals(200, response.getStatusCode().value());
	// 	assertEquals("Hello World", response.getBody());
	// }

	// @Test
	// @Description("/greeting endpoint returns expected response for specified name parameter")
	// public void greeting_ExpectedResponseWithNameParam() {
	// 	ResponseEntity<String> response = restTemplate.getForEntity(base.toString() + "?name=John", String.class);

	// 	assertEquals(200, response.getStatusCode().value());
	// 	assertEquals("Hello John", response.getBody());
	// }

	@Test
	void testCreateUser() {
		User user = new User(null, "John", "john@gmail.com", 35);
		ResponseEntity<User> response = restTemplate.postForEntity("/api/user", user, User.class);

		assertEquals(HttpStatus.CREATED, response.getStatusCode());
		assertNotNull(response.getBody());
		assertNotNull(response.getBody().getUserId());
	}

	@Test
	void testGetAllUsers() {
		List<User> users = new ArrayList<>() {
			{
				add(new User(null, "John", "john@gmail.com", 35));
				add(new User(null, "Charly", "charly@gmail.com", 25));
				add(new User(null, "Mary", "mary@gmail.com", 20));
			}
		};

		for (User user : users) {
			restTemplate.postForEntity("/api/user", user, User.class);
		}

		ResponseEntity<User[]> response = restTemplate.getForEntity("/api/user", User[].class);
		User[] responseUsers = response.getBody();

		assertEquals(HttpStatus.OK, response.getStatusCode());
		assertNotNull(responseUsers);
		assertTrue(users.size() <= responseUsers.length);
	}

	@Test
	void testGetUserById() {
		User user = new User(null, "Cyprian", "cyprian@gmail.com", 56);
		ResponseEntity<User> createResponse = restTemplate.postForEntity("/api/user", user, User.class);

		User createdUser = createResponse.getBody();
		ResponseEntity<User> response = restTemplate.getForEntity("/api/user/" + createdUser.getUserId(), User.class);

		assertEquals(HttpStatus.OK, response.getStatusCode());
		assertNotNull(response.getBody());
		assertEquals(createdUser.getUserId(), response.getBody().getUserId());
	}

	@Test
	void testDeleteUser() {
		User user = new User(null, "Carla", "carla@gmail.com", 46);
		ResponseEntity<User> createResponse = restTemplate.postForEntity("/api/user", user, User.class);

		User createdUser = createResponse.getBody();
		restTemplate.delete("/api/user" + createdUser.getUserId());

		ResponseEntity<User> response = restTemplate.getForEntity("/api/user" + createdUser.getUserId(), User.class);

		assertEquals(HttpStatus.NOT_FOUND, response.getStatusCode());
	}
}


