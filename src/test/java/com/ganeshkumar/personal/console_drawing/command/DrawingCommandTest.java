package com.ganeshkumar.personal.console_drawing.command;

import static org.junit.Assert.assertNotNull;

import org.junit.Before;
import org.junit.Test;

import com.ganeshkumar.personal.console_drawing.entity.Line;
import com.ganeshkumar.personal.console_drawing.entity.Point;

public class DrawingCommandTest {
	
	private DrawringCommand drawringCommand;
	
	@Before
	public void init() {
		drawringCommand = new DrawringCommand(new Line(new Point(1, 2), new Point(3, 4)));
	}
	
	@Test
	public void givenGetShape_whenMethodCalled_thenReturnInitializedShapeObject() {
		assertNotNull(drawringCommand.getShape());
	}

}
