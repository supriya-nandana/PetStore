package com.example.petstore.service;

import com.example.petstore.dtos.ResponseDto;

public interface PetService {

	public ResponseDto getPetsByPetName(String petName);

	//List<PetsResponseDto> getPetsByPetName(String petName) throws PetsNotFoundException, PetsOutOfStockException;
	
}
