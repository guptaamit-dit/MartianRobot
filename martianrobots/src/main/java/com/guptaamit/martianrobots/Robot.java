package com.guptaamit.martianrobots;

/**
 * @author Amit
 *
 */
public class Robot {
	private final Mars mars;
	private Position currentPosition;

	public Robot(Mars mars, Position startingPosition) {
		this.mars = mars;
		this.currentPosition = startingPosition;
	}
	
	public void handle(Instruction instruction) {
		
	}
	
}
