package com.ganeshkumar.personal.console_drawing.entity;

import static org.junit.Assert.assertNotNull;

import org.junit.Before;
import org.junit.Test;

import com.ganeshkumar.personal.console_drawing.exception.CanvasNotExistException;
import com.ganeshkumar.personal.console_drawing.exception.CoordinatesOutOfBoundsException;

public class RectangleTest {
	
	private Rectangle rectangle;
	private Canvas canvas;
	private Point p1 = new Point(2, 2);
	private Point p2 = new Point(2, 4);
	
	@Before
	public void init() {
		rectangle = new Rectangle(p1, p2);
		canvas = new Canvas(10, 8);
	}
	
	@Test(expected = CanvasNotExistException.class)
	public void givenDraw_whenCanvasIsNotAvailable_thenThrowCanvasNotExistException() {
		rectangle.draw(null);
	}
	
	@Test
	public void givenDraw_whenCanvasIsAvailable_thenFillColourAndReturnCanvas() {
		assertNotNull(rectangle.draw(canvas));
	}
	
	@Test(expected = CoordinatesOutOfBoundsException.class)
	public void givenDraw_whenCoordinatesOutOfBounds_thenThrowCoordinatesOutOfBoundsException() {
		Canvas canvas = new Canvas(10, 5);
		rectangle.draw(canvas);
	}
}
