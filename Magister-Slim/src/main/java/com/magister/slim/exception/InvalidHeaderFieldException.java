package com.magister.slim.exception;

public class InvalidHeaderFieldException extends RuntimeException{
	public static final long serialVersionUID=1L;
	private String message;
	public InvalidHeaderFieldException(String message)
	{
		this.setMessage(message);
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	
}