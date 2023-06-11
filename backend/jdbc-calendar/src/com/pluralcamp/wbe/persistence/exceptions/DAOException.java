package com.pluralcamp.wbe.persistence.exceptions;

public class DAOException extends Exception {

	private static final long serialVersionUID = 1L;

	public DAOException() {
		this("Error: an error in the persistence layer occurred", null);
	}

	public DAOException(String message) {
		this(message, null);
	}

	public DAOException(Exception cause) {
		this(cause.getMessage(), cause);
	}

	public DAOException(String message, Exception cause) {
		super(message,cause);
	}
}
