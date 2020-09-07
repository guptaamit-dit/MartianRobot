package com.guptaamit.martianrobots;

import java.io.IOException;
import java.util.Arrays;

import com.guptaamit.martianrobots.input.FileInput;
import com.guptaamit.martianrobots.input.Input;
import com.guptaamit.martianrobots.parsers.MarsBoundaryParser;

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
    }
    
    public static int[] parseMarsDimension(String line) {
    	return Arrays.stream(line.split(" ")).mapToInt(Integer::parseInt).toArray();
    }
    
}
