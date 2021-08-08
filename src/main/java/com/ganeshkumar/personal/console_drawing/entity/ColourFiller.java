package com.ganeshkumar.personal.console_drawing.entity;

import java.util.ArrayDeque;
import java.util.Deque;

import com.ganeshkumar.personal.console_drawing.exception.CanvasNotExistException;
import com.ganeshkumar.personal.console_drawing.exception.CoordinatesOutOfBoundsException;

/**
 * @author Ganesh Kumar. Sankaramanchi
 *
 */

public class ColourFiller {

	private int x;
	private int y;
	private char colourToFill;

	public ColourFiller(int x, int y, char colourToFill) {
		this.x = x;
		this.y = y;
		this.colourToFill = colourToFill;
	}

	public Canvas fillColour(Canvas canvas) {
		if(canvas == null)
			throw new CanvasNotExistException();
		
		if(!isValidPoint(canvas.getWidth(), canvas.getHeight()))
			throw new CoordinatesOutOfBoundsException();
		
		char selectedCoordinate = canvas.getCANVAS()[y][x];
		Deque<Point> coordinateQueue = new ArrayDeque<>();
		coordinateQueue.add(new Point(y, x));
		while (!coordinateQueue.isEmpty()) {
			
			Point point = coordinateQueue.pop();
			
			if (canvas.getCANVAS()[point.getX()][point.getY()] == selectedCoordinate) {
				canvas.getCANVAS()[point.getX()][point.getY()] = colourToFill;
			}
			if (point.getX() - 1 >= 0 && canvas.getCANVAS()[point.getX() - 1][point.getY()] == selectedCoordinate) {
				coordinateQueue.add(new Point(point.getX() - 1, point.getY()));
			}
			if (point.getX() + 1 < canvas.getHeight() && canvas.getCANVAS()[point.getX() + 1][point.getY()] == selectedCoordinate) {
				coordinateQueue.add(new Point(point.getX() + 1, point.getY()));
			}
			if (point.getY() - 1 >= 0 && canvas.getCANVAS()[point.getX()][point.getY() - 1] == selectedCoordinate) {
				coordinateQueue.add(new Point(point.getX(), point.getY() - 1));
			}
			if (point.getY() + 1 < canvas.getWidth() && canvas.getCANVAS()[point.getX()][point.getY() + 1] == selectedCoordinate) {
				coordinateQueue.add(new Point(point.getX(), point.getY() + 1));
			}
		}
		return canvas;
	}
	
	private boolean isValidPoint(int w, int h) {
		return (0 < x && x <= w-2) && (0 < y && y <= h-2);
	}

}
