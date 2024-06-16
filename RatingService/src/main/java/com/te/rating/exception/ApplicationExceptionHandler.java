package com.te.rating.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.te.rating.response.Response;

@RestControllerAdvice
public class ApplicationExceptionHandler {

	@ExceptionHandler(ResourceNotFoundException.class)
	public ResponseEntity<Response> handler(ResourceNotFoundException e){
		return new ResponseEntity<Response>(new Response(true, e.getMessage(), null), HttpStatus.BAD_REQUEST);
	}
}
