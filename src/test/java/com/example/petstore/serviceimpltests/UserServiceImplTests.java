package com.example.petstore.serviceimpltests;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.Optional;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import com.example.petstore.dao.UserDao;
import com.example.petstore.dtos.LoginDto;
import com.example.petstore.dtos.UserResponseDto;
import com.example.petstore.exceptions.ResourceNotFoundException;
import com.example.petstore.model.User;
import com.example.petstore.service.UserService;
import com.example.petstore.service.impl.UserServiceImpl;

@ExtendWith(MockitoExtension.class)
public class UserServiceImplTests {

	@Mock
	UserDao userDao;

	@InjectMocks
	UserServiceImpl userServiceImpl;

	@Mock
	UserDao accountDao;

	UserResponseDto userResponseDto;

	@Mock
	UserService userService;

	@BeforeEach
	public void setUp() {

	}

	@Test
	public void loginUserTest() {
		LoginDto loginDto = new LoginDto();
		loginDto.setUserName("sai");
		loginDto.setPassword("sai");

		userResponseDto = new UserResponseDto();
		userResponseDto.setMessage("Employee logged in");
		userResponseDto.setStatusCode(200);

		User user = new User();
		user.setPhoneNumber("1233455");
		user.setUserName("sai");
        user.setLocation("tekkali");
        user.setPassword("sai");
        user.setUserId(1);
		assertThat(!(loginDto.getUserName().isEmpty() && loginDto.getPassword().isEmpty())).isTrue();
		 ResourceNotFoundException exception = assertThrows(ResourceNotFoundException.class, () -> {
		        userServiceImpl.authenticateUser(loginDto);
		    });
		 
		    String expectedMessage = "User not found";
		    String actualMessage = exception.getMessage();
		    assertTrue(actualMessage.contains(expectedMessage));
	}
	
	
	@Test
	public void loginUserTest2() {
		LoginDto loginDto = new LoginDto();
		loginDto.setUserName("TEST123");
		loginDto.setPassword("test123");

		userResponseDto = new UserResponseDto();
		userResponseDto.setMessage("Employee logged in");
		userResponseDto.setStatusCode(200);

		User user = new User();
		user.setLocation("tekkali");
		user.setPassword("test123");
		user.setUserName("testUser");
        user.setPhoneNumber("123456");
		assertThat(!(loginDto.getUserName().isEmpty() && loginDto.getPassword().isEmpty())).isTrue();

		when(userDao.findByUserNameAndPassword("TEST123", "test123")).thenReturn(Optional.ofNullable(user));
		userServiceImpl.authenticateUser(loginDto);
		verify(userDao).findByUserNameAndPassword("TEST123", "test123");

	}
}
