package com.example.petstore.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.petstore.dtos.LoginDto;
import com.example.petstore.dtos.UserResponseDto;
import com.example.petstore.service.UserService;


@RestController
public class UserController {

	@Autowired
	UserService userService;
	
	
	@PostMapping("/users/login")
	public ResponseEntity<UserResponseDto> authenticateEmployee(@Valid @RequestBody LoginDto loginDto) {
		return new ResponseEntity<>(userService.authenticateUser(loginDto),HttpStatus.OK);
	}
}
