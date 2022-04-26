package com.keila.bookstore.resources.exceptions;

import javax.servlet.ServletRequest;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.keila.bookstore.service.exceptions.DataIntegrityViolationException;
import com.keila.bookstore.service.exceptions.ObjectNotFoundException;

@ControllerAdvice
public class ResourceExceptionHandler {
	
	@ExceptionHandler(ObjectNotFoundException.class)
	public ResponseEntity<StandarError> objectNotFoundException(ObjectNotFoundException e, ServletRequest request){
		StandarError error = new StandarError(System.currentTimeMillis(),HttpStatus.NOT_FOUND.value(), e.getMessage());
		
		return ResponseEntity.status(HttpStatus.NOT_FOUND).body(error);
		
	}
	
	@ExceptionHandler(DataIntegrityViolationException.class)
	public ResponseEntity<StandarError> DataIntegrityViolationException(DataIntegrityViolationException e, ServletRequest request){
		StandarError error = new StandarError(System.currentTimeMillis(),HttpStatus.BAD_REQUEST.value(), e.getMessage());
		
		return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(error);
		
	}
	@ExceptionHandler(MethodArgumentNotValidException.class)
	public ResponseEntity<StandarError> validationErros(MethodArgumentNotValidException e, ServletRequest request){
		ValidationError error = new ValidationError(System.currentTimeMillis(),HttpStatus.BAD_REQUEST.value(), "Erro na validação dos campos");
		for(FieldError x : e.getBindingResult().getFieldErrors()) {
			error.addErros(x.getField(), x.getDefaultMessage());
		}
		return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(error);
		
	}

}
