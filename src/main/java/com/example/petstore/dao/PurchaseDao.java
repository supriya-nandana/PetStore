package com.example.petstore.dao;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.example.petstore.model.Purchase;

@Repository
public interface PurchaseDao extends CrudRepository<Purchase, Integer> {

	@Query(value="select p.pet_price from pet p where p.pet_id=:petId",nativeQuery = true)
	int findPriceBypetid(int petId);

	Optional<List<Purchase>> findAllByUserId(int userId);

}
