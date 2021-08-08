package com.ganeshkumar.personal.console_drawing.command;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;

import org.junit.Before;
import org.junit.Test;

import com.ganeshkumar.personal.console_drawing.entity.Canvas;

public class CreateCanvasCommandTest {
	
	private CreateCanvasCommand createCanvasCommand;
	
	@Before
	public void init() {
		createCanvasCommand = new CreateCanvasCommand(1, 2);
	}
	
	@Test
	public void givenGetCanvas_whenExecuteMethodCalled_thenReturnNewCanvasObject() {
		createCanvasCommand.execute();
		Canvas canvas = createCanvasCommand.getCanvas();
		assertNotNull(canvas);
		assertEquals(1, canvas.getWidth());
		assertEquals(2, canvas.getHeight());
	}
	
	@Test
	public void givenGetCanvas_whenExecuteMethodNotCalled_thenReturnNull() {
		Canvas canvas = createCanvasCommand.getCanvas();
		assertNull(canvas);
	}

}
