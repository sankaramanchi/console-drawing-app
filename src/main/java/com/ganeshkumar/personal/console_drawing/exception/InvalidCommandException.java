package com.ganeshkumar.personal.console_drawing.exception;

/**
 * @author Ganesh Kumar. Sankaramanchi
 *
 */

@SuppressWarnings("serial")
public class InvalidCommandException extends RuntimeException {
	
	private static final String ERROR_INVALID_COMMAND = "Invalid command. please re-try again. Example of valid commands:"
			+ "\n-----------------------------------------------"
			+ "\n| C 20 4       - create canvas                |"
			+ "\n| L 1 2 6 2    - draw horizontal line         |"
			+ "\n| L 6 3 6 4    - draw vertical line           |"
			+ "\n| R 14 1 18 3  - draw rectangle               |"
			+ "\n| B 10 3 o     - fill colour 'o' is the color |"
			+ "\n| Q            - quit                         |"
			+ "\n-----------------------------------------------";
	
	public InvalidCommandException() {
		super(ERROR_INVALID_COMMAND);
	}
	
	public InvalidCommandException(String message) {
		super(message+"\n"+ERROR_INVALID_COMMAND);
	}
}
