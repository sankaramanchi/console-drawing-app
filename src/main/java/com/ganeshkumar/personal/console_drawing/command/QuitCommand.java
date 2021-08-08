package com.ganeshkumar.personal.console_drawing.command;

/**
 * @author Ganesh Kumar. Sankaramanchi
 *
 */

public class QuitCommand implements Command {

	@Override
	public void execute() {
		System.exit(0);
	}
}
