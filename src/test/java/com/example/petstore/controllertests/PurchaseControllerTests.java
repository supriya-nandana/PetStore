package com.example.petstore.controllertests;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.ResponseEntity;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import com.example.petstore.controller.PurchaseController;
import com.example.petstore.dtos.PetsPurchaseDto;
import com.example.petstore.dtos.PurchaseRequestDto;
import com.example.petstore.service.PurchaseService;
import com.fasterxml.jackson.databind.ObjectMapper;

@ExtendWith(MockitoExtension.class)
public class PurchaseControllerTests {

	@Mock
    PurchaseService purchaseService;

	MockMvc mockMvc;
    ObjectMapper objectMapper;

    @InjectMocks
    PurchaseController purchaseController;

    PurchaseRequestDto purchaseRequestDto;
    
    @BeforeEach
    public void setUp() {
        objectMapper = new ObjectMapper();
        mockMvc = MockMvcBuilders.standaloneSetup(purchaseController).build();      
    }
    

    @Test
	public void getPurchaaseDetailsByUserId()  {
		
    	
	}
}
