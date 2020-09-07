package com.guptaamit.martianrobots;

import java.util.AbstractMap;
import java.util.Map;

import com.guptaamit.martianrobots.handlers.ForwardInstructionHandler;
import com.guptaamit.martianrobots.handlers.InstructionHandler;
import com.guptaamit.martianrobots.handlers.LeftInstructionHandler;
import com.guptaamit.martianrobots.handlers.RightInstructionHandler;

/**
 * @author Amit
 *
 */
public class Robot {
	private final Mars mars;
	private boolean isLost;
	private Position currentPosition;
	private static final Map<Instruction, InstructionHandler> instructionHandlers = 
			Map.ofEntries(
					new AbstractMap.SimpleEntry<Instruction, InstructionHandler>(Instruction.FORWARD, new ForwardInstructionHandler()),
					new AbstractMap.SimpleEntry<Instruction, InstructionHandler>(Instruction.LEFT, new LeftInstructionHandler()),
					new AbstractMap.SimpleEntry<Instruction, InstructionHandler>(Instruction.RIGHT, new RightInstructionHandler())
					);

	public Robot(Mars mars, Position startingPosition) {
		if(!mars.isWithinBoundary(startingPosition.getCoordinate())) {
			throw new IllegalArgumentException("Starting Position is not within Boundary");
		}
		this.mars = mars;
		this.currentPosition = startingPosition;
	}
	
	public void handle(Instruction instruction) {
		Position newPosition = instructionHandlers.get(instruction).execute(currentPosition);
		boolean movingOutOfBoundary = !mars.isWithinBoundary(newPosition.getCoordinate());
		if(mars.isRobotLostHere(currentPosition.getCoordinate()) && movingOutOfBoundary) {
			return;
		}
		//If Robot is lost, then update the lost scent to avoid future losses of robots
		if(movingOutOfBoundary) {
			isLost = true;
			mars.lostRobot(currentPosition.getCoordinate());
		} else {
			currentPosition = newPosition;
		}
	}
	
	public boolean isLost() {
		return isLost;
	}
	
	Position getPosition() {
		return currentPosition;
	}
	
	public String getPrettyPrintPosition() {
		return isLost() ? currentPosition.toString() + " LOST"
				: currentPosition.toString();
	}
	
}
