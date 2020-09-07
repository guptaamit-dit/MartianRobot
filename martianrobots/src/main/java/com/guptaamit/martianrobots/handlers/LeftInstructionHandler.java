/**
 * 
 */
package com.guptaamit.martianrobots.handlers;

import java.util.EnumMap;
import com.guptaamit.martianrobots.Orientation;

/**
 * @author Amit
 *
 */
public class LeftInstructionHandler extends OrientationInstructionHandler {
	
	public LeftInstructionHandler() {
		super(getOrientationFinderMap());
	}
	
	private static EnumMap<Orientation, Orientation> getOrientationFinderMap() {
		EnumMap<Orientation, Orientation> orientationFinderMap = new EnumMap<>(Orientation.class);
		orientationFinderMap.put(Orientation.NORTH, Orientation.WEST);
		orientationFinderMap.put(Orientation.WEST, Orientation.SOUTH);
		orientationFinderMap.put(Orientation.SOUTH, Orientation.EAST);
		orientationFinderMap.put(Orientation.EAST, Orientation.NORTH);
		return orientationFinderMap;
	}
}
