package com.zosh.service;

import com.zosh.modal.User;
import com.zosh.request.LoginRequest;
import com.zosh.request.RegisterRequest;

public interface UserService {
	
	public User register(RegisterRequest req);
	
	public User Login(LoginRequest req);
	
	public User getUserProfile(String jwt);
	
	public User updateUser(User user);

}
