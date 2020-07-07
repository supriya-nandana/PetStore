package com.example.petstore.dtos;

public class PurchaseRequestDto {

	private int userId;
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
	public int getUserId() {
		return userId;
	}
	public void setUserId(int userId) {
		this.userId = userId;
	}
	
}
