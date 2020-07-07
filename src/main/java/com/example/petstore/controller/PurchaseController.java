package com.example.petstore.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.petstore.dtos.PetsPurchaseDto;
import com.example.petstore.dtos.PurchaseRequestDto;
import com.example.petstore.service.PurchaseService;

@RestController
public class PurchaseController {

	@Autowired
	PurchaseService purchaseService;
	
	@PostMapping("/users/purchases")
	public String purchasePetsByUserId(@RequestBody PurchaseRequestDto purchaseRequestDto) {
		return purchaseService.purchasePets(purchaseRequestDto);
	}
	
	@GetMapping("/{userId}/purchasepets")
    public ResponseEntity<List<PetsPurchaseDto>> getListOfPetsPurchasedByuserId(@PathVariable("userId")int userId) 
    {  
        return new ResponseEntity<>(purchaseService.getListOfPetsPurchasedByuserId(userId),HttpStatus.OK);
    }
}
