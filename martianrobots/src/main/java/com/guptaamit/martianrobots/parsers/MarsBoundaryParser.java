/**
 * 
 */
package com.guptaamit.martianrobots.parsers;

import java.util.Arrays;

import com.guptaamit.martianrobots.Mars;

/**
 * @author Amit
 *
 */
public class MarsBoundaryParser {
	
	public static final int[] parse(String line) {
		int[] boundary = Arrays.stream(line.split(" ")).mapToInt(Integer::parseInt).toArray();
		if(boundary.length!=2) {
			throw new IllegalArgumentException("Invalid Format. Format is <x> <y>");
		}
		if(boundary[0] < 0 || boundary[1] < 0) {
			throw new IllegalArgumentException("Boundary coordinates can not be negative");
		}
		
		if(boundary[0] > Mars.BOUNDARY_UPPER_LIMIT || boundary[1] > Mars.BOUNDARY_UPPER_LIMIT) {
			throw new IllegalArgumentException("Boundary coordinates are too big");
		}
		return boundary;
	}
}
