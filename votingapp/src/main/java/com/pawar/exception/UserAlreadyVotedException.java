package com.pawar.exception;

public class UserAlreadyVotedException extends RuntimeException {

	public UserAlreadyVotedException(String message) {
		super(message);
	}
	
}
