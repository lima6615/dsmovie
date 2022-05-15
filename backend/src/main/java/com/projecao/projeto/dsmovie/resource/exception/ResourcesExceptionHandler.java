package com.projecao.projeto.dsmovie.resource.exception;

import java.time.OffsetDateTime;

import javax.servlet.http.HttpServletRequest;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.projecao.projeto.dsmovie.service.exception.ResourceNotFoundException;



@ControllerAdvice
public class ResourcesExceptionHandler {

	@ExceptionHandler(ResourceNotFoundException.class)
	public ResponseEntity<StandardError> resourceNotFound(ResourceNotFoundException e, HttpServletRequest request){
		
		String error = "Resource not found";
		HttpStatus status = HttpStatus.NOT_FOUND;
		StandardError standardError = new StandardError(status.value(),error,e.getMessage(),OffsetDateTime.now(),request.getRequestURI());
		
		return ResponseEntity.status(status).body(standardError);
	}
	

//	@ExceptionHandler(ResourceAlreadyExistsException.class)
//	public ResponseEntity<StandardError> resourceAlreadyExists(ResourceAlreadyExistsException e, HttpServletRequest request){
//		
//		String error = "Resource already exists";
//		HttpStatus status = HttpStatus.NOT_FOUND;
//		StandardError standardError = new StandardError(status.value(),error,e.getMessage(),OffsetDateTime.now(),request.getRequestURI());
//		
//		return ResponseEntity.status(status).body(standardError);
//	}
}
