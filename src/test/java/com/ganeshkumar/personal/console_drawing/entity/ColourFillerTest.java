package com.ganeshkumar.personal.console_drawing.entity;

import static org.junit.Assert.assertNotNull;

import org.junit.Before;
import org.junit.Test;

import com.ganeshkumar.personal.console_drawing.exception.CanvasNotExistException;

public class ColourFillerTest {
	
	private ColourFiller colourFiller;
	private Canvas canvas;
	
	@Before
	public void init() {
		canvas = new Canvas(10, 5);
		colourFiller = new ColourFiller(5, 2, 'x');
	}
	
	@Test(expected = CanvasNotExistException.class)
	public void givenFillColour_whenCanvasIsNotAvailable_thenThrowCanvasNotExistException() {
		colourFiller.fillColour(null);
	}
	
	@Test
	public void givenFillColour_whenCanvasIsAvailable_thenFillColourAndReturnCanvas() {
		assertNotNull(colourFiller.fillColour(canvas));
	}

}
