package com.zosh.service;

import org.springframework.stereotype.Service;

import com.zosh.config.JwtTokenProvider;
import com.zosh.exceptions.UserException;
import com.zosh.modal.User;
import com.zosh.repository.UserRepository;
import com.zosh.request.LoginRequest;
import com.zosh.request.RegisterRequest;

@Service
public class UserServiceImplementation implements UserService {
	
	private JwtTokenProvider jwtTokenProvider;
	private UserRepository userRepository;

	public UserServiceImplementation(JwtTokenProvider jwtTokenProvider,UserRepository userRepository) {
		this.jwtTokenProvider=jwtTokenProvider;
		this.userRepository=userRepository;
	}

	@Override
	public User getUserProfile(String jwt) throws UserException {
		String email = jwtTokenProvider.getEmailFromToken(jwt);
		
		System.out.println("user profile email "+email);
		
		User user = userRepository.findByEmail(email);
		
		if(user==null) {
			throw new UserException("user not exist with email ------ "+email);
		}
		return user;
	}

	@Override
	public User updateUser(User user, String jwt) {
		String email = jwtTokenProvider.getEmailFromToken(jwt);
		
		User existingUser = userRepository.findByEmail(email);
		
		if(user.getFullName()!=null) {
			existingUser.setFullName(user.getFullName());
		}
		if(user.getProfileImage()!=null) {
			existingUser.setProfileImage(user.getProfileImage());
		}
		return userRepository.save(existingUser);
	}

}
