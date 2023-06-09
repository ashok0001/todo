package com.zosh.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.zosh.exceptions.UserException;
import com.zosh.modal.User;
import com.zosh.service.UserService;

@RestController
@RequestMapping("/api/users")
public class UserController {
	
	private UserService userService;
	
	public UserController(UserService userService) {
		this.userService=userService;
	}
	
	@GetMapping("/profile")
	public ResponseEntity<User> getUserProfileHandler(@RequestHeader("Authorization") String jwt) throws UserException{
		
		User user = userService.getUserProfile(jwt);
		return new ResponseEntity<User>(user,HttpStatus.ACCEPTED);
	}
	
	@PutMapping("/update")
	public ResponseEntity<User> updateUserHandler(@RequestBody User user, @RequestHeader("Authorization") String jwt) throws UserException{
		
		userService.updateUser(user, jwt);
		
		return new ResponseEntity<User>(user,HttpStatus.ACCEPTED);
		
	}

}
