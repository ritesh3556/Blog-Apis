package com.codewithritesh.blog.repository;


import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.codewithritesh.blog.entities.User;
import com.codewithritesh.blog.payloads.UserDto;

public interface UserRepo extends JpaRepository<User, Integer> {
	
	
}
