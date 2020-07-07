package com.example.petstore.dtos;

import java.util.List;

public class ResponseDto {

	List<PetsResponseDto> petsResponseDto;
	private String message;
	private Integer statusCode;
	
	
	public Integer getStatusCode() {
		return statusCode;
	}
	public void setStatusCode(Integer statusCode) {
		this.statusCode = statusCode;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	public List<PetsResponseDto> getPetsResponseDto() {
		return petsResponseDto;
	}
	public void setPetsResponseDto(List<PetsResponseDto> petsResponseDto) {
		this.petsResponseDto = petsResponseDto;
	}
	
	
}
