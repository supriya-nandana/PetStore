package com.example.petstore.service;

import com.example.petstore.dtos.LoginDto;
import com.example.petstore.dtos.UserResponseDto;

public interface UserService {

	UserResponseDto authenticateUser(LoginDto loginDto);

}
