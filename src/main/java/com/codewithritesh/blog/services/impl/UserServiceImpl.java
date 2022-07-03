package com.codewithritesh.blog.services.impl;

import java.util.List;
import java.util.stream.Collector;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.codewithritesh.blog.entities.User;
import com.codewithritesh.blog.payloads.UserDto;
import com.codewithritesh.blog.repository.UserRepo;
import com.codewithritesh.blog.services.UserService;
import com.codewithritesh.blog.exceptions.ResourceNotFoundException;

@Service
public class UserServiceImpl implements UserService {

	
	@Autowired
	private UserRepo userRepo;
	
	
	
	@Override
	public UserDto createUser(UserDto userDto) {
		// TODO Auto-generated method stub
		
		User user = this.dtoToUser(userDto);
		
		User savedUser = this.userRepo.save(user);
		
		
		return this.userToDto(savedUser);
	}

	@Override
	public UserDto updateUser(UserDto userDto, Integer userId) {
		// TODO Auto-generated method stub
		
		User user=this.userRepo.findById(userId).orElseThrow(()-> new ResourceNotFoundException("User"," id",userId));
		
		user.setName(userDto.getName());
		user.setEmail(userDto.getEmail());
		user.setPassword(userDto.getPassword());
		user.setAbout(userDto.getAbout());
		
		User updatedUser = this.userRepo.save(user);
		UserDto userDto1 = this.userToDto((updatedUser));
		
		return userDto1;
	}

	@Override
	public UserDto getUserById(Integer userId) {
		// TODO Auto-generated method stub
		
		User user = this.userRepo.findById(userId).orElseThrow(()-> new ResourceNotFoundException("user", " Id ", userId));
		
		
		
		return this.userToDto(user);
	}

	@Override
	public List<UserDto> getAllUsers() {
		// TODO Auto-generated method stub
		
		
		List<User> users = this.userRepo.findAll();
		
		List<UserDto> usersDtos = users.stream().map(user->this.userToDto(user)).collect(Collectors.toList());
		
		return usersDtos;
	}

	@Override
	public void deleteUser(Integer userId) {
		// TODO Auto-generated method stub
		
		User user = this.userRepo.findById(userId).orElseThrow(()-> new ResourceNotFoundException("user", " Id ", userId));
		this.userRepo.delete(user);
		
	}

	public User dtoToUser(UserDto userDto)
	{
		User user = new User();
		user.setId(userDto.getId());
		user.setName(userDto.getName());
		user.setEmail(userDto.getEmail());
		user.setPassword(userDto.getPassword());
		user.setAbout(userDto.getAbout());
		
		return user;
	}
	
	public UserDto userToDto(User user)
	{
		
		UserDto userDto=new UserDto();
		userDto.setId(user.getId());
		userDto.setName(user.getName());
		userDto.setEmail(user.getEmail());
		userDto.setPassword(user.getPassword());
		userDto.setAbout(user.getAbout());
		
		return userDto;
	}
}
