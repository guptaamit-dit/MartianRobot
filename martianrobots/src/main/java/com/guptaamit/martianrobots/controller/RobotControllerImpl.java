package com.guptaamit.martianrobots.controller;

import java.io.PrintStream;
import java.util.List;

import com.guptaamit.martianrobots.Instruction;
import com.guptaamit.martianrobots.Mars;
import com.guptaamit.martianrobots.Robot;
import com.guptaamit.martianrobots.RobotCommand;

public class RobotControllerImpl implements RobotController {
	
	private final Mars mars;
	private final PrintStream output;

	public RobotControllerImpl(Mars mars, PrintStream output) {
		this.mars = mars;
		this.output = output;
	}

	@Override
	public void sendCommand(List<RobotCommand> commands) {
		for(RobotCommand command : commands) {
			Robot robot = new Robot(mars, command.getStartingPosition());
			for(Instruction instruction : command.getInstructions()) {
				robot.handle(instruction);
				if(robot.isLost()) {
					break;
				}
			}
			output.println(robot.getPrettyPrintPosition());
		}
		
	}
	

}
