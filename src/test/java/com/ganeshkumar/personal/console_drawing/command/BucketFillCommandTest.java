package com.ganeshkumar.personal.console_drawing.command;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;

import org.junit.Before;
import org.junit.Test;

import com.ganeshkumar.personal.console_drawing.entity.ColourFiller;
import com.ganeshkumar.personal.console_drawing.entity.Point;

public class BucketFillCommandTest {
	
	private BucketFillCommand bucketFillCommand;
	
	@Before
	public void init() {
		bucketFillCommand = new BucketFillCommand(new Point(1,2), 'x');
	}
	
	@Test
	public void givenGetColourFiller_whenExecuteMethodCalled_thenReturnNewColourFiller() {
		bucketFillCommand.execute();
		ColourFiller colourFiller = bucketFillCommand.getColourFiller();
		assertNotNull(colourFiller);
	}
	
	@Test
	public void givenGetColourFiller_whenExecuteMethodNotCalled_thenReturnNull() {
		ColourFiller colourFiller = bucketFillCommand.getColourFiller();
		assertNull(colourFiller);
	}

}
