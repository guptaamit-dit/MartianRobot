/**
 * 
 */
package com.guptaamit.martianrobots.handlers;

import com.guptaamit.martianrobots.Coordinate;
import com.guptaamit.martianrobots.Orientation;
import com.guptaamit.martianrobots.Position;

/**
 * @author Amit
 *
 */
public class ForwardInstructionHandler implements InstructionHandler {

	@Override
	public Position execute(Position currentPosition) {
		final Orientation orientation = currentPosition.getOrientation();
		final Coordinate coordinate = currentPosition.getCoordinate();
		if (orientation == Orientation.NORTH) {
			return updateYCoordinate(orientation, coordinate, 1);
		} else if (orientation == Orientation.SOUTH) {
			return updateYCoordinate(orientation, coordinate, -1);
		} else if (orientation == Orientation.EAST) {
			return updateXCoordinate(orientation, coordinate, 1);
		} else {
			return updateXCoordinate(orientation, coordinate, -1);
		}
	}

	private Position updateXCoordinate(Orientation orientation, Coordinate coordinate, int step) {
		return newPosition(coordinate.getX()+step, coordinate.getY(), orientation);
	}
	
	private Position updateYCoordinate(Orientation orientation, Coordinate coordinate, int step) {
		return newPosition(coordinate.getX(), coordinate.getY()+step, orientation);
	}
	
	private Position newPosition(int x, int y, Orientation orientation) {
		return new Position(new Coordinate(x, y), orientation);
	}
}
