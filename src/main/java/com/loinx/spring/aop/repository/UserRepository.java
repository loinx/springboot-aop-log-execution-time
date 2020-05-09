package com.loinx.spring.aop.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.loinx.spring.aop.model.UserModel;

@Repository
public interface UserRepository extends CrudRepository<UserModel, String> {
	
}
