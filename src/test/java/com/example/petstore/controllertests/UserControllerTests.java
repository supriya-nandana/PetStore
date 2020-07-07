package com.example.petstore.controllertests;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;

import java.util.LinkedHashMap;

import org.hamcrest.Matchers;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import com.example.petstore.controller.UserController;
import com.example.petstore.dtos.LoginDto;
import com.example.petstore.dtos.UserResponseDto;
import com.example.petstore.service.UserService;
import com.fasterxml.jackson.databind.ObjectMapper;

@ExtendWith(MockitoExtension.class)
public class UserControllerTests {

	@Mock
    UserService userService;

	MockMvc mockMvc;
    ObjectMapper objectMapper;

    @InjectMocks
    UserController userController;

    LoginDto loginDto;
    UserResponseDto userResponseDto;

    @BeforeEach
    public void setUp() {
        objectMapper = new ObjectMapper();
        mockMvc = MockMvcBuilders.standaloneSetup(userController).build();      
    }
    
    @Test
    public void userLoginTest() throws Exception
    {
		LoginDto loginDto = new LoginDto();
		
		loginDto.setUserName("sai");
		loginDto.setPassword("test");
		
		UserResponseDto loginResponseDto = new UserResponseDto();
       
       loginResponseDto.setMessage("user logged in successfully!!");
       loginResponseDto.setStatusCode(200);
       
        when(userService.authenticateUser(any(LoginDto.class))).thenReturn(loginResponseDto);
        mockMvc.perform(post("/users/login").contentType(MediaType.APPLICATION_JSON_VALUE)
                .content(objectMapper.writeValueAsString(loginDto)))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$", Matchers.any(LinkedHashMap.class)));

        verify(userService).authenticateUser(any(LoginDto.class));
       
    }
    
    @Test
    public void userLoginTest2() throws Exception
    {
		LoginDto loginDto = new LoginDto();
		
		loginDto.setUserName("supriya");
		loginDto.setPassword("supriya");
		
		UserResponseDto loginResponseDto = new UserResponseDto();
       
       loginResponseDto.setMessage("user logged in successfully!!");
       loginResponseDto.setStatusCode(200);
       
        when(userService.authenticateUser(any(LoginDto.class))).thenReturn(loginResponseDto);
        mockMvc.perform(post("/users/login").contentType(MediaType.APPLICATION_JSON_VALUE)
                .content(objectMapper.writeValueAsString(loginDto)))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$", Matchers.any(LinkedHashMap.class)));

        verify(userService).authenticateUser(any(LoginDto.class));
       
    }

}
