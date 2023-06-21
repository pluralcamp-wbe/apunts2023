package com.pluralcamp.demo.exceptions;

public class ResourceNotFoundException extends Exception {

	//Les excepcions han de ser serializables
	//que es puguin guardar en disc o enviar per la xarxa (que tb guarda en disc)
	//per ex. quan volen fer un log de l'excepció
	//per ex. es vol enviar una excepció al client
	private static final long serialVersionUID = 1L;
	
	public ResourceNotFoundException(String message) {
		super(message);
	}
	
}
