package com.guptaamit.martianrobots;
/**
 * 
 * @author Amit
 *
 */
public class Position {
	private final Coordinate coordinate;
	private final Orientation orientation;
	
	public Position(Coordinate coordinate, Orientation orientation) {
		this.coordinate = coordinate;
		this.orientation = orientation;
	}
	
	public Coordinate getCoordinate() {
		return coordinate;
	}
	
	public Orientation getOrientation() {
		return orientation;
	}

	@Override
	public String toString() {
		return coordinate + " " + orientation.getCode();
	}	
}
