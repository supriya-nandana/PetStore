package com.example.petstore.exceptions;

import java.util.stream.Collectors;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import com.google.common.net.HttpHeaders;

@RestControllerAdvice
public class ExceptionController extends ResponseEntityExceptionHandler {

	@ExceptionHandler(value = ResourceNotFoundException.class)
	public ResponseEntity<ErrorResponse> exception(ResourceNotFoundException exception) {
		ErrorResponse errorResponse = new ErrorResponse();
		errorResponse.setMessage(" record is not found for the requested user");
		errorResponse.setStatusCode(HttpStatus.NOT_FOUND.value());
		return new ResponseEntity<>(errorResponse, HttpStatus.NOT_FOUND);
	}

	
	 protected ResponseEntity<Object> handleMethodArgumentNotValid(MethodArgumentNotValidException ex, HttpHeaders headers, HttpStatus status, WebRequest request) {
	       ErrorResponse errorResponse = new ErrorResponse();
	       errorResponse.setStatusCode(600);
	       String allErrors = ex.getBindingResult().getFieldErrors().stream().
	    		   map(e->e.getDefaultMessage()).collect(Collectors.joining(","));
	       errorResponse.setMessage(allErrors);
	        return new ResponseEntity<>(errorResponse, HttpStatus.BAD_REQUEST);
	    }
	
	 @ExceptionHandler(value = PetsNotFoundException.class)
		public ResponseEntity<Object> exception(PetsNotFoundException exception) {
		 ErrorResponse errorResponse = new ErrorResponse();
			errorResponse.setMessage(" record is not found for the requested pet");
			errorResponse.setStatusCode(HttpStatus.NOT_FOUND.value());
			return new ResponseEntity<>(exception.getMessage(), HttpStatus.NOT_FOUND);
		}

}
