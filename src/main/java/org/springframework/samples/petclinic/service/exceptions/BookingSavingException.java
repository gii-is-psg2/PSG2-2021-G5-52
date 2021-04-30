package org.springframework.samples.petclinic.service.exceptions;

import lombok.AllArgsConstructor;

@AllArgsConstructor
public class BookingSavingException extends Exception {

	/**
	 * 
	 */
	private static final long serialVersionUID = 5069078941173522703L;
	
	private final String message;
	
	@Override
	public String toString() {
		return this.message;
	}
	
	
}
