package com.myapp.blog.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.myapp.blog.payloads.ApiResponse;
import com.myapp.blog.payloads.UserDto;
import com.myapp.blog.services.UserService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("api/users")
public class UserController {

	@Autowired
	private UserService userService;

	// Post - Create User
	@PostMapping("/")
	public ResponseEntity<UserDto> createUser(@Valid @RequestBody UserDto userdto) {
		UserDto createUser = this.userService.createUser(userdto);
		return new ResponseEntity<>(createUser, HttpStatus.CREATED);
	}

	// Put - To update user data
	@PutMapping("/{userId}")
	public ResponseEntity<UserDto> updateUser(@Valid @RequestBody UserDto userDto, @PathVariable("userId") Integer uId) {
		UserDto updatedUser = this.userService.updateUserDto(userDto, uId);
		return ResponseEntity.ok(updatedUser);
	}

	/*
	 * @DeleteMapping("/{userId}") public ResponseEntity<?>
	 * deleteUser(@PathVariable("userId") Integer uid){ this.deleteUser(uid); return
	 * ResponseEntity.ok(Map.of("message","User deleted Successufully")); }
	 */

	// Delete - User
	@DeleteMapping("/{userId}")
	public ResponseEntity<ApiResponse> deleteUser(@PathVariable("userId") Integer uid) {
		this.userService.deleteUser(uid);
		return new ResponseEntity<ApiResponse>(new ApiResponse("User Deleted Successfully", true), HttpStatus.OK);
	}

	// Get - All Users
	@GetMapping("/")
	public ResponseEntity<List<UserDto>> getAllUsers() {
		return ResponseEntity.ok(this.userService.getAllUsers());
	}

	// Get - Single User
	@GetMapping("/{userId}")
	public ResponseEntity<UserDto> getSingleUser(@PathVariable Integer userId) {
		return ResponseEntity.ok(this.userService.getUserByID(userId));
	}
	
	// Get - Already deleted User - Getting Exception- ResourceNotFoundException: User not found with id 
		@GetMapping("/delete/{userId}")
		public ResponseEntity<ApiResponse> getSingleUserwithException(@PathVariable Integer userId) {
			this.userService.getUserByID(userId);
			return new ResponseEntity<ApiResponse>(new ApiResponse("User is Deleted already with this Id", false), HttpStatus.NOT_FOUND);
		}
	
}
