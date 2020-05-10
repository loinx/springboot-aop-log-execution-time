package com.loinx.spring.aop.controller;

import java.net.URI;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.loinx.spring.aop.dto.User;
import com.loinx.spring.aop.service.UserService;

@RestController
@RequestMapping(path = "/users")
public class UserController {

	@Autowired
	private UserService userService;

	@PostMapping
	public ResponseEntity<Void> create(@RequestBody User user) {
		User createdUser = userService.create(user);
		return ResponseEntity.created(URI.create("http://localhost:8080/users/" + createdUser.getId())).build();
	}

	@GetMapping(path = "/{id}")
	public ResponseEntity<Object> get(@PathVariable("id") String id) {
		Optional<User> user = userService.getUser(id);
		ResponseEntity<Object> response = user.isPresent() ? ResponseEntity.ok(user.get())
				: ResponseEntity.notFound().build();
		return response;
	}
	
}
