package com.test.avianca.test.tata.exceptions;

public class NotFindFlightsException extends AssertionError {
	public static final long serialVersionUID = 1L;

	public NotFindFlightsException(String message, Throwable cause) {
		super(message, cause);
	}
}
