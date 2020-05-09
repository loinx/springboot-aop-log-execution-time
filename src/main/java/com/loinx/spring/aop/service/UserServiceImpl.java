package com.loinx.spring.aop.service;

import java.util.Optional;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.loinx.spring.aop.annotation.TraceTime;
import com.loinx.spring.aop.converter.UserMapper;
import com.loinx.spring.aop.dto.User;
import com.loinx.spring.aop.model.UserModel;
import com.loinx.spring.aop.repository.UserRepository;

import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class UserServiceImpl implements UserService {

	@Autowired
	private UserRepository userRepository;

	@Autowired
	private UserMapper userMapper;

	@TraceTime
	@Override
	public User create(User user) {
		UserModel userModel = userMapper.userToUserModel(user);
		userModel.setId(UUID.randomUUID().toString());
		userRepository.save(userModel);
		user.setId(userModel.getId());
		log.debug("Created user {} successfully", userModel.getName());
		return user;
	}

	@TraceTime
	@Override
	public Optional<User> getUser(String id) {
		Optional<UserModel> userModel = userRepository.findById(id);
		return Optional.ofNullable(userMapper.userModelToUser(userModel.orElseGet(() -> {
			return null;
		})));
	}

}
