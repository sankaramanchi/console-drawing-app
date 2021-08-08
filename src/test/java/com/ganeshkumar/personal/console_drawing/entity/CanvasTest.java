package com.ganeshkumar.personal.console_drawing.entity;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;

public class CanvasTest {
	
	private Canvas canvas;
	
	@Before
	public void init() {
		canvas = new Canvas(10, 5);
	}
	
	@Test
	public void givenRender_whenCanvasAvailable_thenRenderCanvas() {
		canvas = new Canvas(10, 5);
		canvas.render();
		assertEquals(10, canvas.getWidth());
		assertEquals(5, canvas.getHeight());
	}

}
