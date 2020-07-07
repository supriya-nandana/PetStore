package com.example.petstore.service;

import com.example.petstore.dtos.PurchaseRequestDto;

public interface PurchaseService {

	String purchasePets(int userId, PurchaseRequestDto purchaseRequestDto);

}
