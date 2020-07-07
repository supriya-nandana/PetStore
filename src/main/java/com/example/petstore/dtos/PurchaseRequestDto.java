package com.example.petstore.dtos;

public class PurchaseRequestDto {

	private int petId;
	private int noOfQuantities;
	public int getPetId() {
		return petId;
	}
	public void setPetId(int petId) {
		this.petId = petId;
	}
	public int getNoOfQuantities() {
		return noOfQuantities;
	}
	public void setNoOfQuantities(int noOfQuantities) {
		this.noOfQuantities = noOfQuantities;
	}
	
}
