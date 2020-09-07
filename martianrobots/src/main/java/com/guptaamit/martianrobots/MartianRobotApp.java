package com.guptaamit.martianrobots;

import java.io.IOException;

import com.guptaamit.martianrobots.controller.RobotController;
import com.guptaamit.martianrobots.controller.RobotControllerImpl;
import com.guptaamit.martianrobots.input.FileInput;
import com.guptaamit.martianrobots.input.Input;
import com.guptaamit.martianrobots.parsers.MarsBoundaryParser;
import com.guptaamit.martianrobots.parsers.RobotCommandsParser;

/**
 * Main Program for Martian Robots Application
 *
 */
public class MartianRobotApp 
{
    public static void main( String[] args ) throws IOException
    {
    	Input input = new FileInput("src/inputdata/input.txt");
    	int[] marsDimension = MarsBoundaryParser.parse(input.nextLine());
    	Mars mars = new Mars(marsDimension[0], marsDimension[1]);
    	RobotController robotController = new RobotControllerImpl(mars, System.out);
    	robotController.sendCommand(RobotCommandsParser.parse(input));
    }
}
