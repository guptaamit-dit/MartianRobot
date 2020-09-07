package com.guptaamit.martianrobots.controller;

import java.util.List;
import com.guptaamit.martianrobots.RobotCommand;

/**
 * Interface to control the robots
 * @author Amit
 *
 */
public interface RobotController {
	void sendCommand(List<RobotCommand> commands);
}
