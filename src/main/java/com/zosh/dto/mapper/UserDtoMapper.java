package com.zosh.dto.mapper;

import com.zosh.dto.UserDto;
import com.zosh.modal.User;

public class UserDtoMapper {
	
	public UserDto toUserDto(User user) {
		
		UserDto userDto=new UserDto();
		
		userDto.setEmail(user.getEmail());
		userDto.setFullName(user.getFullName());
		userDto.setId(user.getId());
		userDto.setProfileImage(user.getProfileImage());
		
		return userDto;
	}

}
