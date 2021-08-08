package com.ganeshkumar.personal.console_drawing.command;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import org.junit.Before;
import org.junit.Test;

import com.ganeshkumar.personal.console_drawing.exception.InvalidCommandException;

public class CommandFactoryTest {
	
	private CommandFactory commandFactory;
	
	@Before
	public void init() {
		commandFactory = new CommandFactory();
	}
	
	@Test(expected = InvalidCommandException.class)
	public void givenGetCommand_whenCommandIsNull_thenThrowInvalidCommandException() {
		commandFactory.getCommand(null);
	}
	
	@Test(expected = InvalidCommandException.class)
	public void givenGetCommand_whenCommandTypeIsNotValid_thenThrowInvalidCommandException() {
		commandFactory.getCommand("Z");
	}
	
	@Test(expected = InvalidCommandException.class)
	public void givenGetCommand_whenCommandTypeIsCreateCanvasAndCommandIsInvalid_thenThrowInvalidCommandException() {
		commandFactory.getCommand("C 20 10 5");
	}
	
	@Test(expected = InvalidCommandException.class)
	public void givenGetCommand_whenCommandTypeIsCreateCanvasAndCommandParamsAreInvalid_thenThrowInvalidCommandException() {
		commandFactory.getCommand("C c c");
	}
	
	@Test
	public void givenGetCommand_whenCommandTypeIsCreateCanvas_thenReturnCreateCanvasCommand() {
		CreateCanvasCommand createCanvasCommand = (CreateCanvasCommand) commandFactory.getCommand("C 10 5");
		createCanvasCommand.execute();
		assertEquals(7, createCanvasCommand.getCanvas().getHeight());
		assertEquals(12, createCanvasCommand.getCanvas().getWidth());
	}
	
	@Test(expected = InvalidCommandException.class)
	public void givenGetCommand_whenCommandTypeIsDrawLineAndCommandIsInvalid_thenThrowInvalidCommandException() {
		commandFactory.getCommand("L 2 2 15");
	}
	
	@Test(expected = InvalidCommandException.class)
	public void givenGetCommand_whenCommandTypeIsDrawLineAndCommandParamsAreInvalid_thenThrowInvalidCommandException() {
		commandFactory.getCommand("L L 2 15 2");
	}
	
	@Test
	public void givenGetCommand_whenCommandTypeIsDrawLine_thenReturnDrawringCommand() {
		DrawringCommand drawingCommand = (DrawringCommand) commandFactory.getCommand("L 2 2 15 2");
		assertNotNull(drawingCommand.getShape());
	}
	
	@Test(expected = InvalidCommandException.class)
	public void givenGetCommand_whenCommandTypeIsDrawRectangleAndCommandIsInvalid_thenThrowInvalidCommandException() {
		commandFactory.getCommand("R 3 4 16");
	}
	
	@Test(expected = InvalidCommandException.class)
	public void givenGetCommand_whenCommandTypeIsDrawRectangleAndCommandParamsAreInvalid_thenThrowInvalidCommandException() {
		commandFactory.getCommand("R R 4 16 8");
	}
	
	@Test
	public void givenGetCommand_whenCommandTypeIsDrawRectangle_thenReturnDrawringCommand() {
		DrawringCommand drawingCommand = (DrawringCommand) commandFactory.getCommand("R 3 4 16 8");
		assertNotNull(drawingCommand.getShape());
	}
	
	@Test(expected = InvalidCommandException.class)
	public void givenGetCommand_whenCommandTypeIsBucketFillAndCommandIsInvalid_thenThrowInvalidCommandException() {
		commandFactory.getCommand("B 22 1");
	}
	
	@Test(expected = InvalidCommandException.class)
	public void givenGetCommand_whenCommandTypeIsBucketFillAndCommandParamsAreInvalid_thenThrowInvalidCommandException() {
		commandFactory.getCommand("B B 1 o");
	}
	
	@Test
	public void givenGetCommand_whenCommandTypeIsBucketFill_thenReturnBucketFillCommand() {
		BucketFillCommand bucketFillCommand = (BucketFillCommand) commandFactory.getCommand("B 22 1 o");
		bucketFillCommand.execute();
		assertNotNull(bucketFillCommand.getColourFiller());
	}
	
	@Test
	public void givenGetCommand_whenCommandTypeIsQuit_thenReturnQuitCommand() {
		QuitCommand quitCommand = (QuitCommand) commandFactory.getCommand("Q");
		assertNotNull(quitCommand);
	}

}
