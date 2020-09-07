package com.guptaamit.martianrobots.parsers;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.List;

import org.apache.commons.lang3.StringUtils;
import org.junit.jupiter.api.Test;

import com.guptaamit.martianrobots.Instruction;

public class InstructionParserTest {

	@Test
	void whenInstructionLongerThenThresholdThenThrowException() {
		Exception exception = assertThrows(IllegalArgumentException.class, () -> {
	        InstructionParser.parse(StringUtils.repeat("L", InstructionParser.MAXIMUM_INS_LENGTH+1));
	    });
		
		String expectedMessage = "Instruction length needs to be less than "+InstructionParser.MAXIMUM_INS_LENGTH;
	    String actualMessage = exception.getMessage();
	 
	    assertTrue(actualMessage.contains(expectedMessage));
	}
	
	@Test
	void whenInstructionInvalidThenThrowException() {
		assertThrows(IllegalArgumentException.class, () -> {
	        InstructionParser.parse("LRAL");
	    });

	}
	
	@Test
	void validateParse() {
		String instructionText = "LRF" + StringUtils.repeat("L", InstructionParser.MAXIMUM_INS_LENGTH-3);
		List<Instruction> instructions = InstructionParser.parse(instructionText);
		assertTrue(instructions.size()==InstructionParser.MAXIMUM_INS_LENGTH);
		assertEquals(Instruction.LEFT, instructions.get(0));
		assertEquals(Instruction.RIGHT, instructions.get(1));
		assertEquals(Instruction.FORWARD, instructions.get(2));
	}

}
