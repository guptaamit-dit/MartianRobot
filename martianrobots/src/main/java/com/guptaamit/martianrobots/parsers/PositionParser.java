/**
 * 
 */
package com.guptaamit.martianrobots.parsers;

import com.guptaamit.martianrobots.Coordinate;
import com.guptaamit.martianrobots.Orientation;
import com.guptaamit.martianrobots.Position;

/**
 * @author ranck
 *
 */
public class PositionParser {
	public static final Position parse(String line) {
		String[] parts = line.split(" ");
		Coordinate coordinate = new Coordinate(Integer.parseInt(parts[0]), Integer.parseInt(parts[1]));
		Orientation orientation = Orientation.of(parts[2]);
		return new Position(coordinate, orientation);
	}
}
