package com.ganeshkumar.personal.console_drawing.command;

import com.ganeshkumar.personal.console_drawing.entity.Line;
import com.ganeshkumar.personal.console_drawing.entity.Point;
import com.ganeshkumar.personal.console_drawing.entity.Rectangle;
import com.ganeshkumar.personal.console_drawing.exception.InvalidCommandException;

/**
 * @author Ganesh Kumar. Sankaramanchi
 *
 */

public class CommandFactory {
	
	private static final String COMMAND_CREATE_CANVAS = "C";
	private static final String COMMAND_DRAW_LINE = "L";
	private static final String COMMAND_DRAW_RECTANGLE = "R";
	private static final String COMMAND_BUCKET_FILL = "B";
	private static final String COMMAND_QUIT = "Q";
	private static final String ELIGIBLE_COMMANDS = "CLRBQ";
	
	public Command getCommand(String commandLine) throws InvalidCommandException {
		
		if (commandLine == null || commandLine.trim().equals(""))
			throw new InvalidCommandException();
		
		String commandType = String.valueOf(commandLine.charAt(0));
		
		if (commandLine.length() <= 0 || !ELIGIBLE_COMMANDS.contains(commandType.toUpperCase()))
			throw new InvalidCommandException();
		
		String[] commandParams = commandLine.split("\\s+");
		
		if(commandType.equalsIgnoreCase(COMMAND_CREATE_CANVAS)) {
			if(commandParams.length != 3) {
				throw new InvalidCommandException();
			}
			try {
				int w = Integer.parseInt(commandParams[1]) + 2;
				int h = Integer.parseInt(commandParams[2]) + 2;
				return new CreateCanvasCommand(w, h);
			}catch(NumberFormatException e) {
				throw new InvalidCommandException(e.getMessage());
			}
		}
		
		if(commandType.equalsIgnoreCase(COMMAND_DRAW_LINE)) {
			if(commandParams.length != 5) {
				throw new InvalidCommandException();
			}
			try {
				Point p1 = new Point(Integer.parseInt(commandParams[1]), Integer.parseInt(commandParams[2]));
				Point p2 = new Point(Integer.parseInt(commandParams[3]), Integer.parseInt(commandParams[4]));
				return new DrawringCommand(new Line(p1, p2));
			}catch(NumberFormatException e) {
				throw new InvalidCommandException(e.getMessage());
			}
		}
		
		if(commandType.equalsIgnoreCase(COMMAND_DRAW_RECTANGLE)) {
			if(commandParams.length != 5) {
				throw new InvalidCommandException();
			}
			try {
				Point p1 = new Point(Integer.parseInt(commandParams[1]), Integer.parseInt(commandParams[2]));
				Point p2 = new Point(Integer.parseInt(commandParams[3]), Integer.parseInt(commandParams[4]));
				return new DrawringCommand(new Rectangle(p1, p2));
			}catch(NumberFormatException e) {
				throw new InvalidCommandException(e.getMessage());
			}
		}
		
		if(commandType.equalsIgnoreCase(COMMAND_BUCKET_FILL)) {
			if(commandParams.length != 4) {
				throw new InvalidCommandException();
			}
			try {
				Point p = new Point(Integer.parseInt(commandParams[1]), Integer.parseInt(commandParams[2]));
				char colour = commandParams[3].trim().charAt(0);
				return new BucketFillCommand(p, colour);
			}catch(NumberFormatException e) {
				throw new InvalidCommandException(e.getMessage());
			}
		}
		
		if(commandType.equalsIgnoreCase(COMMAND_QUIT)) {
			return new QuitCommand();
		}
		
		return null;
	}
}
