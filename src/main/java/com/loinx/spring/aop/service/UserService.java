package com.loinx.spring.aop.service;

import java.util.Optional;

import com.loinx.spring.aop.dto.User;

public interface UserService {

	User create(User user);

	Optional<User> getUser(String id);
}
