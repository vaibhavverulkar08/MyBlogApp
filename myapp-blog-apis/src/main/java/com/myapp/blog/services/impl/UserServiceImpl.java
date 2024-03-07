package com.myapp.blog.services.impl;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.myapp.blog.exceptions.*;
import com.myapp.blog.entities.User;
import com.myapp.blog.payloads.UserDto;
import com.myapp.blog.repositories.UserRepo;
import com.myapp.blog.services.UserService;

@Service
public class UserServiceImpl implements UserService {

	@Autowired
	private UserRepo userRepo;
	
	@Autowired
	private ModelMapper modelMapper;
	
	@Override
	public UserDto createUser(UserDto userDto) {
		User user = this.dtoToUser(userDto);
		User savedUser = this.userRepo.save(user);
		return this.userToDto(savedUser);
	}

	@Override
	public UserDto updateUserDto(UserDto userDto, Integer useerId) {
		User user = this.userRepo.findById(useerId).orElseThrow(()-> new ResourceNotFoundException("User","id",useerId));
		user.setName(userDto.getName());
		user.setEmail(userDto .getEmail());
		user.setPassword(userDto.getPassword());
		user.setAbout(userDto.getAbout());
		
		User updateUser = this.userRepo.save(user);
		UserDto userDto1 = this.userToDto(updateUser);
		return userDto1;
	}

	@Override
	public UserDto getUserByID(Integer userId) {
		
		User user = this.userRepo.findById(userId).
				orElseThrow(()->new ResourceNotFoundException("User", "id", userId));
		return this.userToDto(user);
	}

	@Override
	public List<UserDto> getAllUsers() {

		List<User> users =this.userRepo.findAll();
		
		List<UserDto> userDtos = users.stream().map(user->this.userToDto(user)).collect(Collectors.toList());
		return userDtos;
	}

	@Override
	public void deleteUser(Integer userId) {
		User user = this.userRepo.findById(userId).
				orElseThrow(()-> new ResourceNotFoundException("User","Id", userId));
		this.userRepo.delete(user);
	} 
	
	//New-Mapping using Model Mapper
	private User dtoToUser(UserDto userDto) {
		User user = this.modelMapper.map(userDto, User.class);
		return user;
	}
	
	//manually mapping implementation to convert dtotouser
//	private User dtoToUser(UserDto userDto) {
//		User user = new User();
//		user.setId(userDto.getId());
//		user.setName(userDto.getName());
//		user.setEmail(userDto.getEmail());
//		user.setPassword(userDto.getPassword());
//		user.setAbout(userDto.getAbout());
//		return user;
//	}
	
	//New-Mapping using Model Mapper
		private UserDto userToDto(User user) {
			UserDto userDto = this.modelMapper.map(user, UserDto.class);
			return userDto;
		}
	 
	//manually mapping implementation to convert usertodto

//	private UserDto userToDto(User user) {
//		UserDto userDto = new UserDto();
//		userDto.setId(user.getId());
//		userDto.setName(user.getName());
//		userDto.setEmail(user.getEmail());
//		userDto.setPassword(user.getPassword());
//		userDto.setAbout(user.getAbout());
//		return userDto;
//	}

}
