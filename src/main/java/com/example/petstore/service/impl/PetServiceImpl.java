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
import com.example.petstore.exceptions.PetsNotFoundException;
import com.example.petstore.model.Pet;
import com.example.petstore.service.PetService;

@Service
public class PetServiceImpl implements PetService {

	@Autowired
	PetDao petDao;

	@Override
	public List<PetsResponseDto> getPetsByPetName(String petName) throws PetsNotFoundException {
		Optional<List<Pet>> petsOptional = petDao.getPetsByPetName(petName);
		if (petsOptional.isPresent()) {

			return petsOptional.get().stream().map(pet -> getPetDto(pet)).collect(Collectors.toList());
		}
		// List<ProductsResponseDto> responseList= new ArrayList<ProductsResponseDto>();
		throw new PetsNotFoundException("There exists no pets with the given product name:" + petName);
	}

	private PetsResponseDto getPetDto(Pet pet) {
		PetsResponseDto responseDto = new PetsResponseDto();
		responseDto.setMessage("details of the pets");
		responseDto.setStatusCode(HttpStatus.OK.value());
		BeanUtils.copyProperties(pet, responseDto);
		return responseDto;

	}
}
