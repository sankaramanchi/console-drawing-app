package com.ganeshkumar.personal.console_drawing.command;

import com.ganeshkumar.personal.console_drawing.entity.Shape;

/**
 * @author Ganesh Kumar. Sankaramanchi
 *
 */

public class DrawringCommand implements Command {
	
	private Shape shape;
	public DrawringCommand(Shape shape) {
		this.shape = shape;
	}
	
	@Override
	public void execute() {
		
	}
	
	public Shape getShape() {
		return shape;
	}
}
