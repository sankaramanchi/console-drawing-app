package com.ganeshkumar.personal.console_drawing.entity;

import com.ganeshkumar.personal.console_drawing.exception.CanvasNotExistException;

/**
 * @author Ganesh Kumar. Sankaramanchi
 *
 */

public class Canvas {

	private int width;
	private int height;
	private char CANVAS[][] = null;

	private static final char TOP_BOTTOM_EDGE_CHAR = '-';
	private static final char LEFT_RIGHT_EDGE_CHAR = '|';
	
	public Canvas(int w, int h) {
		this.width = w;
		this.height = h;
		init();
	}

	private void init() {
		CANVAS = null;
		CANVAS = new char[height][width];
		for(int i = 0; i < height; i++) {
			for(int j = 0; j < width; j++) {
				char element = ' ';
				if(j == 0 || j == width - 1) {
					if(i == 0 || i == height - 1) {
						element = TOP_BOTTOM_EDGE_CHAR;
					}else {
						element = LEFT_RIGHT_EDGE_CHAR;
					}
				}else {
					if(i == 0 || i == height - 1) {
						element = TOP_BOTTOM_EDGE_CHAR;
					}
				}
				CANVAS[i][j] = element;
			}
		}
	}
	

	public void render() {
		if(CANVAS == null) {
			throw new CanvasNotExistException();
		}
		for(int k = 0; k < height; k++) {
			System.out.println(String.valueOf(CANVAS[k]));
		}
	}
	
	public int getWidth() {
		return width;
	}

	public int getHeight() {
		return height;
	}
	
	public char[][] getCANVAS() {
		return CANVAS;
	}

}
