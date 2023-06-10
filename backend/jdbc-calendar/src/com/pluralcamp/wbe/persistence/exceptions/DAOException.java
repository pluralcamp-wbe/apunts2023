package com.pluralcamp.wbe.persistence.exceptions;

public class DAOException extends Exception {
	public DAOException() {}
	public DAOException(String message) {
		super(message);
	}
	public DAOException(Exception cause) {
		super(cause);
	}
	public DAOException(String message, Exception cause) {
		super(message,cause);
	}
}
