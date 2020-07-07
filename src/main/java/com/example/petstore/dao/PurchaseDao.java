package com.example.petstore.dao;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.example.petstore.model.Purchase;

@Repository
public interface PurchaseDao extends CrudRepository<Purchase, Integer> {

	@Query(value="select p.price from pet p where p.pet_id=:petId",nativeQuery = true)
	int findPriceByproductid(int petId);

}
