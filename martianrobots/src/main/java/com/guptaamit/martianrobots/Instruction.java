/**
 * 
 */
package com.guptaamit.martianrobots;

import java.util.HashMap;
import java.util.Map;

/**
 * @author Amit
 *
 */
public enum Instruction {
	LEFT("L"), RIGHT("R"), FORWARD("F");
	
	private final String code;
	
	private static final Map<String, Instruction> codeToInstructionMap  = new HashMap<>();
	static {
		for(Instruction instruction : values()) {
			codeToInstructionMap.put(instruction.code, instruction);
		}
	}
	
	Instruction(String code) {
		this.code = code;
	}
	
	public static Instruction of(String code) {
		Instruction instruction = codeToInstructionMap.get(code);
		if(instruction==null) {
			throw new IllegalArgumentException("Wrong Instruction = "+code);
		}
		return instruction;
	}
}
