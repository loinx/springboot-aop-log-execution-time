package com.loinx.spring.aop.converter;

import org.mapstruct.Mapper;

import com.loinx.spring.aop.dto.User;
import com.loinx.spring.aop.model.UserModel;

@Mapper(componentModel = "spring")
public interface UserMapper {
	public UserModel userToUserModel(User user);

	public User userModelToUser(UserModel userModel);
}
