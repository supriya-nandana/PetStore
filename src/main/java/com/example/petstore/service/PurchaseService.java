package com.example.petstore.service;

import java.util.List;

import com.example.petstore.dtos.PetsPurchaseDto;
import com.example.petstore.dtos.PurchaseRequestDto;

public interface PurchaseService {

	String purchasePets(PurchaseRequestDto purchaseRequestDto);

	public List<PetsPurchaseDto> getListOfPetsPurchasedByuserId(int userId);

	
}
