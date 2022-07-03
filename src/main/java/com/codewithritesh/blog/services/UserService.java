package com.codewithritesh.blog.services;

import java.util.List;

import com.codewithritesh.blog.entities.User;
import com.codewithritesh.blog.payloads.UserDto;

public interface UserService {

	
	UserDto createUser(UserDto user);
	UserDto updateUser(UserDto user,Integer userId);
	UserDto getUserById(Integer userId);
	
	List<UserDto> getAllUsers();
	
	void deleteUser(Integer userId);
	
}
