package com.te.user.services.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.te.user.services.response.Response;

@RestControllerAdvice
public class AppExceptionHandler {

	@ExceptionHandler
	public ResponseEntity<Response> handler(ResourceNotFoundException e){
		return new ResponseEntity<Response>(new Response(true, e.getMessage(), null), HttpStatus.NOT_FOUND);
	}
}
