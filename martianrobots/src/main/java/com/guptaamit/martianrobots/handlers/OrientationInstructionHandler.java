/**
 * 
 */
package com.guptaamit.martianrobots.handlers;

import java.util.EnumMap;

import com.guptaamit.martianrobots.Orientation;
import com.guptaamit.martianrobots.Position;

/**
 * @author Amit
 *
 */
public class OrientationInstructionHandler implements InstructionHandler {
	private final EnumMap<Orientation, Orientation> orientationFinderMap;
	
	public OrientationInstructionHandler(final EnumMap<Orientation, Orientation> orientationMapping) {
		orientationFinderMap = orientationMapping;
	}
	
	@Override
	public Position execute(Position currentPosition) {
		Orientation updatedOrientation = orientationFinderMap.get(currentPosition.getOrientation());
		return new Position(currentPosition.getCoordinate(), updatedOrientation);
	}
}
