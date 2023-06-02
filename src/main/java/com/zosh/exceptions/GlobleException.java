package com.zosh.exceptions;

import java.time.LocalDateTime;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;



@ControllerAdvice
public class GlobleException {
	
	@ExceptionHandler(UserException.class)
	public ResponseEntity<ErrorMessage> userExceptionHandler(TaskException te, WebRequest req){
		
		ErrorMessage error=new ErrorMessage(te.getMessage(),req.getDescription(false),LocalDateTime.now());
		
		return new ResponseEntity<ErrorMessage>(error, HttpStatus.BAD_REQUEST);
	}
	
	@ExceptionHandler(TaskException.class)
	public ResponseEntity<ErrorMessage> taskExceptionHandler(TaskException te, WebRequest req){
		
		ErrorMessage error=new ErrorMessage(te.getMessage(),req.getDescription(false),LocalDateTime.now());
		
		return new ResponseEntity<ErrorMessage>(error, HttpStatus.BAD_REQUEST);
	}
	
	

}
