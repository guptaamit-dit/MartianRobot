/**
 * 
 */
package com.guptaamit.martianrobots.parsers;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import com.guptaamit.martianrobots.Instruction;
import com.guptaamit.martianrobots.Position;
import com.guptaamit.martianrobots.RobotCommand;
import com.guptaamit.martianrobots.input.Input;

/**
 * 
 * @author Amit
 *
 */
public class RobotCommandsParser {
	public static List<RobotCommand> parse(Input input) {
		List<RobotCommand> commands = new ArrayList<RobotCommand>();
		Optional<RobotCommand> command;
		while((command = getNextCommand(input)).isPresent()) {
			commands.add(command.get());
		}
		return commands;
	}
	
	private static Optional<RobotCommand> getNextCommand(Input input) {
		Optional<Position> startingPosition = getStartingPosition(input);
		List<Instruction> instructions = getRobotInstructions(input);
		if(startingPosition.isEmpty() || instructions.size()==0) {
			return Optional.empty();
		}
		return Optional.of(new RobotCommand(startingPosition.get(), instructions));
	}
	
	private static Optional<Position> getStartingPosition(Input input) {
		String positionLine = input.nextLine();
		if(positionLine==null) {
			return Optional.empty();
		}
		return Optional.of(PositionParser.parse(positionLine));
	}
	
	private static List<Instruction> getRobotInstructions(Input input) {
		String line = input.nextLine();
		if(line==null) {
			return new ArrayList<Instruction>();
		}
		return InstructionParser.parse(line);
	}
}
