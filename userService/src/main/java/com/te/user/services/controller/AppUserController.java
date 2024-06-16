package com.te.user.services.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.te.user.services.dto.AppUserDto;
import com.te.user.services.response.Response;
import com.te.user.services.services.UserService;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@RestController
@RequestMapping("/user")
public class AppUserController {

	private final UserService userService;

//save user	
	@PostMapping("/save")
	public ResponseEntity<Response> saveUser(@RequestBody AppUserDto userDto) {
		AppUserDto saveUser = userService.saveUser(userDto);
		return new ResponseEntity<Response>(new Response(false, "saved successfully", saveUser), HttpStatus.CREATED);
	}

//get users	
	@GetMapping("/getUsers")
	public ResponseEntity<Response> getAllUsers() {
		List<AppUserDto> users = userService.getAllUser();
		return new ResponseEntity<Response>(new Response(false, "fetched successfully", users), HttpStatus.OK);
	}
	
//get UserByID
	@GetMapping("/getUserById/{userId}")
	public ResponseEntity<Response> getAllUsers(@PathVariable String userId) {
		 AppUserDto userById = userService.getUserById(userId);
		return new ResponseEntity<Response>(new Response(false, "fetched successfully", userById), HttpStatus.OK);
	}

	
}
