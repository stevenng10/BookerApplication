package com.pointwest.bootcamp.exception.exceptions;

public class GroceryException extends Exception{

	private final String userFriendlyErrorMessage;
	
	public GroceryException(Exception e, String message) {
		super(e);
		this.userFriendlyErrorMessage = message;
	}
		
	public GroceryException(String message) {
		this.userFriendlyErrorMessage = message;
	}

	public String getUserFriendlyErrorMessage() {
		return userFriendlyErrorMessage;
	}

}
