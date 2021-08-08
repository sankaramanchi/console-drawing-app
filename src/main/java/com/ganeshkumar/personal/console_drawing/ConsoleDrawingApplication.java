package com.ganeshkumar.personal.console_drawing;

import java.util.Scanner;

import com.ganeshkumar.personal.console_drawing.command.BucketFillCommand;
import com.ganeshkumar.personal.console_drawing.command.Command;
import com.ganeshkumar.personal.console_drawing.command.CommandFactory;
import com.ganeshkumar.personal.console_drawing.command.CreateCanvasCommand;
import com.ganeshkumar.personal.console_drawing.command.DrawringCommand;
import com.ganeshkumar.personal.console_drawing.command.QuitCommand;
import com.ganeshkumar.personal.console_drawing.entity.Canvas;
import com.ganeshkumar.personal.console_drawing.entity.ColourFiller;
import com.ganeshkumar.personal.console_drawing.entity.Shape;
import com.ganeshkumar.personal.console_drawing.exception.CanvasNotExistException;
import com.ganeshkumar.personal.console_drawing.exception.CoordinatesOutOfBoundsException;
import com.ganeshkumar.personal.console_drawing.exception.InvalidCommandException;

/**
 * @author Ganesh Kumar. Sankaramanchi
 *
 */

public class ConsoleDrawingApplication {

	private static Scanner scanner;
	private static CommandFactory commandFactory;
	private static Canvas canvas;

    public static void main( String[] args ) {
    	scanner = new Scanner(System.in);
    	commandFactory = new CommandFactory();

    	System.out.println("enter command: ");
		while (true) {
			processCommand(scanner.nextLine().trim());
			System.out.println("\nenter command: ");
        }
    }

    public static void processCommand(String givenCommand) {
    	Command command = null;
    	try {
    		command = commandFactory.getCommand(givenCommand);
    		if (command instanceof QuitCommand) {        		
            scanner.close();
        		command.execute();
            }
    		if (command instanceof CreateCanvasCommand) {
        		command.execute();
        		canvas = ((CreateCanvasCommand) command).getCanvas();
            }

    		if (command instanceof DrawringCommand) {
    			Shape shape = ((DrawringCommand) command).getShape();
    			canvas = shape.draw(canvas);
            }

    		if (command instanceof BucketFillCommand) {
    			command.execute();
    			ColourFiller colourFiller = ((BucketFillCommand) command).getColourFiller();
    			canvas = colourFiller.fillColour(canvas);
            }
    		canvas.render();
    	}catch(InvalidCommandException | CanvasNotExistException | CoordinatesOutOfBoundsException e) {
    		System.out.println(e.getMessage());
    	}
    }
}
