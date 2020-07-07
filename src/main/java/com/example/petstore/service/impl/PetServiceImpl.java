package com.example.petstore.service.impl;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import com.example.petstore.dao.PetDao;
import com.example.petstore.dtos.PetsResponseDto;
import com.example.petstore.dtos.ResponseDto;
import com.example.petstore.exceptions.PetsNotFoundException;
import com.example.petstore.model.Pet;
import com.example.petstore.service.PetService;

@Service
public class PetServiceImpl implements PetService {

	@Autowired
	PetDao petDao;

	@Override
	public ResponseDto getPetsByPetName(String petName) {
		ResponseDto responselist=new ResponseDto();
		//Pet pets=new Pet();
		Optional<List<Pet>> petsOptional = petDao.getPetsByPetName(petName);	
		if (!petsOptional.isPresent()) {
	     throw new PetsNotFoundException(" no pet found with relevant name"+petName);
		}
		List<PetsResponseDto> petresponsedto=  petsOptional.get()
				.stream().map(pet -> getPetDto(pet)).collect(Collectors.toList());
		responselist.setPetsResponseDto(petresponsedto);
		responselist.setMessage("list of pets");
		responselist.setStatusCode(HttpStatus.OK.value());
		return responselist;
	}

	private PetsResponseDto getPetDto(Pet pet) {
		PetsResponseDto responseDto = new PetsResponseDto();
		BeanUtils.copyProperties(pet, responseDto);
		return responseDto;

	}
}
