package com.example.petstore.service.impl;

import java.util.Optional;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import com.example.petstore.dao.UserDao;
import com.example.petstore.dtos.LoginDto;
import com.example.petstore.dtos.UserResponseDto;
import com.example.petstore.exceptions.ResourceNotFoundException;
import com.example.petstore.model.User;
import com.example.petstore.service.UserService;

@Service
public class UserServiceImpl implements UserService{

	private static Log logger = LogFactory.getLog(UserServiceImpl.class);
	@Autowired
	UserDao userDao;
	
	@Override
	public UserResponseDto authenticateUser(LoginDto loginDto) {
		logger.info("Inside user login ");
		UserResponseDto userResponseDto = new UserResponseDto();
        Optional<User> user = userDao.findByUserNameAndPassword(loginDto.getUserName(),
                loginDto.getPassword());
        if(!user.isPresent())
		{
			throw new ResourceNotFoundException("User not found ");
		}
        userResponseDto.setMessage("User logged in successfully");
        userResponseDto.setStatusCode(HttpStatus.OK.value());
			return userResponseDto;
	}
        
       /* logger.info("Invalid credentials!!!");
        userResponseDto.setMessage("Invalid credentials!!!");
        userResponseDto.setStatusCode(HttpStatus.UNAUTHORIZED.value());
        return userResponseDto;
*/
	}


