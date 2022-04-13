package br.com.fiap.jpa.exception;

public class IdNotFoundException extends Exception {

	public IdNotFoundException() {
		super("Id não encontrado");
	}

	public IdNotFoundException(String message) {
		super(message);
	}
	
}