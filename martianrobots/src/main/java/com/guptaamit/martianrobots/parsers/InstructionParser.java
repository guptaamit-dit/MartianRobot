/**
 * 
 */
package com.guptaamit.martianrobots.parsers;

import static java.util.stream.Collectors.toList;

import java.util.List;
import java.util.stream.Stream;

import com.guptaamit.martianrobots.Instruction;

/**
 * @author Amit
 *
 */
public class InstructionParser {
	public static final int MAXIMUM_INS_LENGTH = 100;
	public static final List<Instruction> parse(String line) {
		if(line.length() > MAXIMUM_INS_LENGTH) {
			throw new IllegalArgumentException("Instruction length needs to be less than "+MAXIMUM_INS_LENGTH);
		}
		List<Instruction> instructions = Stream.of(line.split("")).map(code -> Instruction.of(code)).collect(toList());
		return instructions;
	}
}
