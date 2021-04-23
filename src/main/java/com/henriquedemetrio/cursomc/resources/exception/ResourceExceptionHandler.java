package com.henriquedemetrio.cursomc.resources.exception;

import javax.servlet.http.HttpServletRequest;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.henriquedemetrio.cursomc.services.exceptions.ObjectNotFoundException;

@ControllerAdvice //classe auxiliar intervir o erro
public class ResourceExceptionHandler {

	
@ExceptionHandler(ObjectNotFoundException.class)//tratador de excessao
public ResponseEntity <StandardError> objectNotFound(ObjectNotFoundException e, HttpServletRequest request){
	
	StandardError err = new StandardError(HttpStatus.NOT_FOUND.value(), e.getMessage(), System.currentTimeMillis());
	return ResponseEntity.status(HttpStatus.NOT_FOUND).body(err);
	
}
}
