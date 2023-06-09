package com.zosh.exceptions;

import java.time.LocalDateTime;

public class ErrorMessage {
	
	private String message;
	private String error;
	private LocalDateTime timeStamp;
	
	public ErrorMessage(String message, String error, LocalDateTime timeStamp) {
		super();
		this.message = message;
		this.error = error;
		this.timeStamp = timeStamp;
	}
	
	
	
}
