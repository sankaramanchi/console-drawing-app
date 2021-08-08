package com.ganeshkumar.personal.console_drawing.command;

import com.ganeshkumar.personal.console_drawing.entity.Canvas;

/**
 * @author Ganesh Kumar. Sankaramanchi
 *
 */

public class CreateCanvasCommand implements Command {
	
	private int width;
	private int height;
	private Canvas canvas;
	
	public CreateCanvasCommand(int w, int h) {
		this.width = w;
		this.height = h;
	}
	
	@Override
	public void execute() {
		canvas = new Canvas(width, height);
	}
	
	public Canvas getCanvas() {
		return canvas;
	}

}
