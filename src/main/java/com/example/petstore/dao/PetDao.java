package com.example.petstore.dao;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import com.example.petstore.model.Pet;

public interface PetDao extends CrudRepository<Pet, Integer>{

	@Query(value="select * from pet p where p.pet_name like %:apple%",nativeQuery = true)
	Optional<List<Pet>> getPetsByPetName(@Param("apple")String petName);

}
