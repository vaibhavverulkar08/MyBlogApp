package com.myapp.blog.services;

import java.util.List;

import com.myapp.blog.payloads.UserDto;

public interface UserService {

	
	UserDto createUser(UserDto user);
	
	UserDto updateUserDto(UserDto user,Integer useerId);
	
	UserDto getUserByID(Integer userID);
	
	List<UserDto> getAllUsers();
	
	void deleteUser(Integer userId);

	
	
	
}
