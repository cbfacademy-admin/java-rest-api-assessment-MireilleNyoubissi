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

import java.net.URL;

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
}


