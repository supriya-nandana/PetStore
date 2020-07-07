package com.example.petstore.service.impl;

import java.time.LocalDate;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.petstore.dao.PurchaseDao;
import com.example.petstore.dtos.PurchaseRequestDto;
import com.example.petstore.model.Purchase;
import com.example.petstore.service.PurchaseService;

@Service
public class PurchaseServiceImpl implements PurchaseService{

	@Autowired
	PurchaseDao purchaseDao;
	
	@Override
	public String purchasePets(int userId, PurchaseRequestDto purchaseRequestDto) {
		Purchase purchase= new Purchase();
		BeanUtils.copyProperties(purchaseRequestDto, purchase);
		purchase.setDate(LocalDate.now());
		purchase.setTotalPrice(purchaseDao.findPriceByproductid(purchaseRequestDto.getPetId())*purchaseRequestDto.getNoOfQuantities());
		Purchase orderplaced=purchaseDao.save(purchase);
		if(orderplaced.getPurchaseId()<=0)return "could not place order please try agin after sometime";
		return "order placed successfully, your orderid:"+orderplaced.getPurchaseId();
		}
		

}
