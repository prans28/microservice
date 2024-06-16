package com.te.user.services.services;

import java.util.List;

import org.springframework.stereotype.Service;

import com.te.user.services.dto.AppUserDto;

@Service
public interface UserService {

	
	//create user
	AppUserDto saveUser(AppUserDto userAppDto);
	
	//get all user
	List<AppUserDto> getAllUser();
	
	//get single user by id
	AppUserDto getUserById(String userId);
	
	//TODO: Delete update
	
	
}
