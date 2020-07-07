package com.example.petstore.service.impl;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import com.example.petstore.dao.PetDao;
import com.example.petstore.dao.PurchaseDao;
import com.example.petstore.dao.UserDao;
import com.example.petstore.dtos.PetsPurchaseDto;
import com.example.petstore.dtos.PurchaseRequestDto;
import com.example.petstore.model.Pet;
import com.example.petstore.model.Purchase;
import com.example.petstore.service.PurchaseService;

@Service
public class PurchaseServiceImpl implements PurchaseService{

	@Autowired
	UserDao userDao;
	
	@Autowired
	PurchaseDao purchaseDao;
	
	@Autowired
	PetDao petDao;
	
	@Override
	public String purchasePets( PurchaseRequestDto purchaseRequestDto) {
		Purchase purchase= new Purchase();
		BeanUtils.copyProperties(purchaseRequestDto, purchase);
		purchase.setDate(LocalDate.now());
		purchase.setTotalPrice(purchaseDao.findPriceBypetid(purchaseRequestDto.getPetId()));
		//purchase.setTotalPrice(purchaseDao.findPriceBypetid(purchaseRequestDto.getPetId())*purchaseRequestDto.getNoOfQuantities());
		Purchase orderplaced=purchaseDao.save(purchase);
		if(orderplaced.getPurchaseId()<=0)return "could not purchase please try agin after sometime";
		return "your purchase has successfully completed, your purchaseid:"+orderplaced.getPurchaseId();
		}

	@Override	
	public List<PetsPurchaseDto> getListOfPetsPurchasedByuserId(int userId) {
      //  logger.info("Inside getBorrowlistByUserId method of ConfirmationServiceImpl");
        List<PetsPurchaseDto> purchaseListDto = new ArrayList<>();
        Optional<List<Purchase>> purchaselist = purchaseDao.findAllByUserId(userId);
        if(purchaselist.isPresent())
        {
            List<Purchase> purchase1 = purchaselist.get();
            return purchase1.stream().map(purchase->getPurchaseDto(purchase)).collect(Collectors.toList());
        }
        else {
            
            return purchaseListDto;
        }
    }
    
    private PetsPurchaseDto getPurchaseDto(Purchase purchase)
    {
    	PetsPurchaseDto purchaselist = new PetsPurchaseDto();
        
        Optional<Pet> pets = petDao.findById(purchase.getPurchaseId());
        if(!pets.isPresent())
        	return null;
        purchaselist.getPurchaseDate();
        purchaselist.setPetName(pets.get().getPetName());
        purchaselist.getTotalPrice();
        purchaselist.setMessage("details of the purchased pets");
        purchaselist.setStatusCode(HttpStatus.OK.value());
        BeanUtils.copyProperties(purchase,purchaselist);
        return purchaselist;
    }
	

}
