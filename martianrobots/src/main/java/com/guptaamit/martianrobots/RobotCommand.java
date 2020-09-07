package com.guptaamit.martianrobots;

import java.util.List;

/**
 * 
 * @author Amit
 *
 */
public class RobotCommand {
	private final Position startingPosition;
	private final List<Instruction> instructions;
	
	public RobotCommand(Position startingPosition, List<Instruction> instructions) {
		this.startingPosition = startingPosition;
		this.instructions = instructions;
	}
	
	public Position getStartingPosition() {
		return startingPosition;
	}
	
	public List<Instruction> getInstructions() {
		return instructions;
	}
}
