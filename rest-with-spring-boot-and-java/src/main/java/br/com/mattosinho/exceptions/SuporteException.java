package br.com.mattosinho.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.BAD_REQUEST)
public class SuporteException extends RuntimeException {

	public SuporteException(String ex) {
		super(ex);
	}	

	private static final long serialVersionUID = 1L;

}
