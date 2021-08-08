package com.ganeshkumar.personal.console_drawing.entity;

import static org.junit.Assert.assertNotNull;

import org.junit.Before;
import org.junit.Test;

import com.ganeshkumar.personal.console_drawing.exception.CanvasNotExistException;
import com.ganeshkumar.personal.console_drawing.exception.CoordinatesOutOfBoundsException;

public class LineTest {
	
	private Line line;
	private Canvas canvas;
	private Point p1 = new Point(2, 2);
	private Point p2 = new Point(2, 4);
	
	@Before
	public void init() {
		line = new Line(p1, p2);
		canvas = new Canvas(10, 8);
	}
	
	@Test(expected = CanvasNotExistException.class)
	public void givenDraw_whenCanvasIsNotAvailable_thenThrowCanvasNotExistException() {
		line.draw(null);
	}
	
	@Test
	public void givenDraw_whenCanvasIsAvailable_thenFillColourAndReturnCanvas() {
		assertNotNull(line.draw(canvas));
	}
	
	@Test(expected = CoordinatesOutOfBoundsException.class)
	public void givenDraw_whenCoordinatesOutOfBounds_thenThrowCoordinatesOutOfBoundsException() {
		Canvas canvas2 = new Canvas(10, 5);
		line.draw(canvas2);
	}
}
