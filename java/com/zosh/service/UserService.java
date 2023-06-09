package com.zosh.service;

import com.zosh.exceptions.UserException;
import com.zosh.modal.User;
import com.zosh.request.LoginRequest;
import com.zosh.request.RegisterRequest;

public interface UserService {
	
	public User getUserProfile(String jwt) throws UserException;
	
	public User updateUser(User user,String jwt);

}
