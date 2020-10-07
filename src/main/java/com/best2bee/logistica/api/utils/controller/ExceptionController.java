package com.best2bee.logistica.api.utils.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.best2bee.logistica.api.utils.Exceptions.ItemNotFoundException;

@RestControllerAdvice
public class ExceptionController {
	
	@ExceptionHandler(ItemNotFoundException.class)
	public ResponseEntity<String> trataItemNotFound(ItemNotFoundException e){
		return ResponseEntity
				.notFound()
				.header("error-code", "DATA_NOT_FOUND")
				.header("error-value", String.valueOf(e.getCnpj()))
				.build();
	}

}
