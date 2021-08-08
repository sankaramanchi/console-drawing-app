package com.ganeshkumar.personal.console_drawing.exception;

/**
 * @author Ganesh Kumar. Sankaramanchi
 *
 */

@SuppressWarnings("serial")
public class CoordinatesOutOfBoundsException extends RuntimeException {
	
	private static final String ERROR_COORDINATES_OUTOF_BOUNDS = "Co-ordinates are out of bounds with Canvas size";
	
	public CoordinatesOutOfBoundsException() {
		super(ERROR_COORDINATES_OUTOF_BOUNDS);
	}
	
	public CoordinatesOutOfBoundsException(String message) {
		super(message+"\n"+ERROR_COORDINATES_OUTOF_BOUNDS);
	}
}
