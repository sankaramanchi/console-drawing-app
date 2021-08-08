package com.ganeshkumar.personal.console_drawing.entity;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;

public class PointTest {
	
	private Point p;
	
	@Before
	public void init() {
		p = new Point(2, 2);
	}
	
	@Test
	public void givenPoint_whenObjectCreated_thenInitializeCoordinates() {
		assertEquals(2, p.getX());
		assertEquals(2, p.getY());
	}
}
