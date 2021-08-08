package com.ganeshkumar.personal.console_drawing.exception;

/**
 * @author Ganesh Kumar. Sankaramanchi
 *
 */

@SuppressWarnings("serial")
public class CanvasNotExistException extends RuntimeException {
	
	private static final String ERROR_CANVAS_NOT_EXISTS = "Canvas does not exists!. create canvas first (example C 20 4)";
	
	public CanvasNotExistException() {
		super(ERROR_CANVAS_NOT_EXISTS);
	}
	
	public CanvasNotExistException(String message) {
		super(message+"\n"+ERROR_CANVAS_NOT_EXISTS);
	}
}
