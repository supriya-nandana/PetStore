package com.example.petstore.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.petstore.dtos.PetsResponseDto;
import com.example.petstore.exceptions.PetsNotFoundException;
import com.example.petstore.service.PetService;

@RestController
public class PetController {

	@Autowired
	PetService petService;
	
	@GetMapping("/pets/petName")
	public List<PetsResponseDto> SearchByPetName(@RequestParam("petName")String petName) throws PetsNotFoundException{
		return petService.getPetsByPetName(petName);
	}
	
	@ExceptionHandler(PetsNotFoundException.class)
	public ResponseEntity<String> exceptionhandler(PetsNotFoundException exception){
		return new ResponseEntity<String>(exception.getMessage(), HttpStatus.NOT_FOUND);
	}
}
