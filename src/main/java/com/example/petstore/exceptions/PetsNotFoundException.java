package com.example.petstore.exceptions;

public class PetsNotFoundException extends Exception {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public PetsNotFoundException(String exception) {
		super(exception);
	}
}
