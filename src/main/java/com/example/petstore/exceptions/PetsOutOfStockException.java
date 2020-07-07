package com.example.petstore.exceptions;

public class PetsOutOfStockException extends Exception {

	private static final long serialVersionUID = 1L;
 public PetsOutOfStockException(String message) {
	 super(message);
 }
	
}
