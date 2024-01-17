package com.ezen.www.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.servlet.NoHandlerFoundException;

import lombok.extern.slf4j.Slf4j;

//예외처리할때(특수할때) 쓰는 어노테이션 ControllerAdvice
@ControllerAdvice
@Slf4j
public class CommonExceptioAdvice {

	@ExceptionHandler
	public String exception(Exception ex) {
		log.info(">>>exception>"+ex.getMessage());
		return "error_page";
	}
	
	@ResponseStatus(HttpStatus.NOT_FOUND)
	@ExceptionHandler(NoHandlerFoundException.class)
	public String handler404(NoHandlerFoundException ex) {
		log.info(">>>404 exception>>"+ex.getMessage());
		return "custom404";
		
	}
	
	

}
