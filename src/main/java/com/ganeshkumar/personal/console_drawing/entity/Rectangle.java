package com.ganeshkumar.personal.console_drawing.entity;

import com.ganeshkumar.personal.console_drawing.exception.CanvasNotExistException;
import com.ganeshkumar.personal.console_drawing.exception.CoordinatesOutOfBoundsException;

/**
 * @author Ganesh Kumar. Sankaramanchi
 *
 */

public class Rectangle implements Shape {

	private static final char DRAW_LINE_CHAR = 'x';
	
	private Point firstPoint;
	private Point secondPoint;
	
	public Rectangle(Point p1, Point p2) {
		this.firstPoint = p1;
		this.secondPoint = p2;
	}

	

	@Override
	public Canvas draw(Canvas canvas) {
		if(canvas == null)
			throw new CanvasNotExistException();
		
		if(!areCoordinatesValid(canvas.getWidth(), canvas.getHeight()))
			throw new CoordinatesOutOfBoundsException();
		
		for(int i = 0; i < canvas.getHeight(); i++) {
			for(int j = 0; j < canvas.getWidth(); j++) {
				canvas.getCANVAS()[i][j] = getCharacterToDraw(i, j, canvas.getCANVAS()[i][j]);
			}
		}
		return canvas;
	}

	
	private Character getCharacterToDraw(int x, int y, char c) {
		if((x == firstPoint.getY() && (y >= firstPoint.getX() && y <= secondPoint.getX()))
				|| (y == firstPoint.getX() && (x >= firstPoint.getY() && x <= secondPoint.getY()))
				|| (x == secondPoint.getY() && (y >= firstPoint.getX() && y <= secondPoint.getX()))
				|| (y == secondPoint.getX() && (x >= firstPoint.getY() && x <= secondPoint.getY()))) {
			return DRAW_LINE_CHAR;
		}
		return c;
	}
	
	private boolean areCoordinatesValid(int w, int h) {
		return (0 < firstPoint.getX() && firstPoint.getX() <= w-2)
				&& (0 < firstPoint.getY() && firstPoint.getY() <= h-2)
				&& (0 < secondPoint.getX() && secondPoint.getX() <= w-2)
				&& (0 < secondPoint.getY() && secondPoint.getY() <= h-2);
	}
	
	public Point getFirstPoint() {
		return firstPoint;
	}

	public Point getSecondPoint() {
		return secondPoint;
	}
}
