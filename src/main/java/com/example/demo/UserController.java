package com.example.demo;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.PostConstruct;

@RequestMapping("/api")
@RestController
public class UserController {
	
	private List<User> users;
	private static final Logger log = LoggerFactory.getLogger(UserController.class);
	
	@PostConstruct
	private void init() {
		users = new ArrayList<>();
		User user = new User("Chaim", 9876);
		users.add(user);
		
	}
	
	@RequestMapping(value = { "/createUser" }, method = RequestMethod.POST, consumes = "application/json", produces = "application/json")
	@ResponseBody
	public User createUser(@RequestBody() User user) {
		users.add(user);
		log.info(String.format("User %s was created successfully", user.getName()));
		return user;
	}
	
	@RequestMapping(value = { "/getAllUsers" }, method = RequestMethod.GET, produces = { MediaType.APPLICATION_JSON_VALUE })
	public List<User> getUser() {
		return users;
	}
}
