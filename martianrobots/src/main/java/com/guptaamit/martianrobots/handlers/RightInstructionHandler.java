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
public class RightInstructionHandler extends OrientationInstructionHandler {
		
	public RightInstructionHandler() {
		super(getOrientationFinderMap());
	}
	
	private static EnumMap<Orientation, Orientation> getOrientationFinderMap() {
		EnumMap<Orientation, Orientation> orientationFinderMap = new EnumMap<>(Orientation.class);
		orientationFinderMap.put(Orientation.NORTH, Orientation.EAST);
		orientationFinderMap.put(Orientation.EAST, Orientation.SOUTH);
		orientationFinderMap.put(Orientation.SOUTH, Orientation.WEST);
		orientationFinderMap.put(Orientation.WEST, Orientation.NORTH);
		return orientationFinderMap;
	}
}
