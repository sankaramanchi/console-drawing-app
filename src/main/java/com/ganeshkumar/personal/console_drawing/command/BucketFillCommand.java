package com.ganeshkumar.personal.console_drawing.command;

import com.ganeshkumar.personal.console_drawing.entity.ColourFiller;
import com.ganeshkumar.personal.console_drawing.entity.Point;

/**
 * @author Ganesh Kumar. Sankaramanchi
 *
 */

public class BucketFillCommand implements Command {
	
	private Point point;
	private char colourToFill;
	private ColourFiller colourFiller;
	
	public BucketFillCommand(Point p, char colourToFill) {
		this.point = p;
		this.colourToFill = colourToFill;
	}
	
	@Override
	public void execute() {
		colourFiller = new ColourFiller(point.getX(), point.getY(), colourToFill);
	}
	
	public ColourFiller getColourFiller() {
		return colourFiller;
	}

}
