package com.example.petstore.service;

import java.util.List;

import com.example.petstore.dtos.PetsResponseDto;
import com.example.petstore.exceptions.PetsNotFoundException;

public interface PetService {

	List<PetsResponseDto> getPetsByPetName(String petName) throws PetsNotFoundException;

	
}
