package com.famousbeejay.spring.user;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class UserExceptionHandler extends RuntimeException {

	public UserExceptionHandler(String arg0) {
		super(arg0);
	}

	
}
