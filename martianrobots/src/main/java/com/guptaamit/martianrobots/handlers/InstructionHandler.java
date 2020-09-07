/**
 * 
 */
package com.guptaamit.martianrobots.handlers;

import com.guptaamit.martianrobots.Position;

/** 
 * Interface for handling Instructions. Handlers should return the new Position after handling
 * a instruction 
 * @author Amit
 *
 */
public interface InstructionHandler {
	/**
	 * This method takes the currentPosition and returns the new Position after executing instruction 
	 * @param currentPosition
	 * @return New Position
	 */
	Position execute(Position currentPosition);
}
