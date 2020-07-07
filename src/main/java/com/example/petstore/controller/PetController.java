package com.example.petstore.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.petstore.dtos.ResponseDto;
import com.example.petstore.exceptions.PetsNotFoundException;
import com.example.petstore.exceptions.PetsOutOfStockException;
import com.example.petstore.service.PetService;

@RestController
public class PetController {

	@Autowired
	PetService petService;
	
	
     @GetMapping("/pets/petName")
	public ResponseEntity<ResponseDto> SearchByPetName(@RequestParam("petName") String petName) throws PetsNotFoundException, PetsOutOfStockException {
			return new ResponseEntity<>(petService.getPetsByPetName(petName), HttpStatus.OK);
	}
	
}
