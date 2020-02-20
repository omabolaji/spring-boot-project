package com.famousbeejay.spring.exception;

import java.util.Date;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import com.famousbeejay.spring.user.UserExceptionHandler;

@ControllerAdvice
@RestController
public class CustomizeResponseEntityExceptionHandler extends  
ResponseEntityExceptionHandler{
	
	//for all classes
	@ExceptionHandler(Exception.class)
	public final ResponseEntity<Object> handleAllException(Exception ex, WebRequest request) 
			throws Exception {
		
		ExceptionResponse exceptionResponse = new ExceptionResponse(
				new Date(), ex.getMessage(), request.getDescription(false));
		
		return new ResponseEntity(exceptionResponse, HttpStatus.INTERNAL_SERVER_ERROR);
	}
	
	
	//for users class
	@ExceptionHandler(UserExceptionHandler.class)
	public final ResponseEntity<Object> handleAllUsersException(Exception ex, WebRequest request) 
			throws Exception {
		
		ExceptionResponse exceptionResponse = new ExceptionResponse(
				new Date(), ex.getMessage(), request.getDescription(false));
		//exceptionResponse.setMessage("You enter invalid Id");
		//exceptionResponse.setDetails("Please try again later");
		
		return new ResponseEntity(exceptionResponse, HttpStatus.NOT_FOUND);
	}
	
	
	//user validation error handler
	@Override
	protected ResponseEntity<Object> handleMethodArgumentNotValid(
			MethodArgumentNotValidException ex, HttpHeaders headers, HttpStatus status, WebRequest request) {

		ExceptionResponse exceptionResponse = new ExceptionResponse(
				new Date(), "Validation Failed!", ex.getBindingResult().toString());
		
		
		return new ResponseEntity(exceptionResponse, HttpStatus.BAD_REQUEST);
		
		//return handleExceptionInternal(ex, null, headers, status, request);
	}
	
	
	
}
