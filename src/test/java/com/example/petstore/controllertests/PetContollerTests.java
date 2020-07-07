package com.example.petstore.controllertests;


import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;


import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;

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

import com.example.petstore.controller.PetController;
import com.example.petstore.dtos.PetsResponseDto;
import com.example.petstore.dtos.ResponseDto;
import com.example.petstore.service.PetService;
import com.fasterxml.jackson.databind.ObjectMapper;

@ExtendWith(MockitoExtension.class)
public class PetContollerTests {

	@Mock
    PetService petService;

	MockMvc mockMvc;
    ObjectMapper objectMapper;

    @InjectMocks
    PetController petController;

    ResponseDto responsedto;
    
    @BeforeEach
    public void setUp() {
        objectMapper = new ObjectMapper();
        mockMvc = MockMvcBuilders.standaloneSetup(petController).build();      
    }
    
    @Test
    public void getPetsByPetNameTests()throws Exception{
    	PetsResponseDto petresponsedto=new PetsResponseDto();
    	petresponsedto.setPetId(1);
    	petresponsedto.setPetName("rabbit");
    	petresponsedto.setPetPrice(2500.00);
    	List<PetsResponseDto> petsResponseDtolist=new ArrayList<>();
    	ResponseDto responsedto=new ResponseDto();
    	petsResponseDtolist.add(petresponsedto);
    	responsedto.setMessage("list of pets");
    	responsedto.setStatusCode(200);
    	responsedto.setPetsResponseDto(petsResponseDtolist);
    	
    	when(petService.getPetsByPetName("rabbit")).thenReturn(responsedto);
    	 mockMvc.perform(get("/pets/petName").contentType(MediaType.APPLICATION_JSON_VALUE)
    			 .param("petName","rabbit").accept(MediaType.APPLICATION_JSON_VALUE)
    			 .andExpect(status().isOk())
                 .andExpect(jsonPath("$", Matchers.any(LinkedHashMap.class))));

         verify(petService).getPetsByPetName("rabbit");
        
    }
    
    
}
