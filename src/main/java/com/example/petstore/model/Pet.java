package com.example.petstore.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Pet {

	@Id
	@GeneratedValue(strategy = GenerationType.TABLE)
	private int petId;
	private String petName;
	private double petPrice;
	public int getPetId() {
		return petId;
	}
	public void setPetId(int petId) {
		this.petId = petId;
	}
	public String getPetName() {
		return petName;
	}
	public void setPetName(String petName) {
		this.petName = petName;
	}
	public double getPetPrice() {
		return petPrice;
	}
	public void setPetPrice(double petPrice) {
		this.petPrice = petPrice;
	}
	
	
}
