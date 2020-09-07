package com.guptaamit.martianrobots.parsers;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.List;

import org.apache.commons.lang3.StringUtils;
import org.junit.jupiter.api.Test;

import com.guptaamit.martianrobots.Instruction;

public class MarsBoundaryParserTest {
	
	@Test
	void whenBoundaryFormatInvalidThenThrowException() {
		assertThrows(IllegalArgumentException.class, () -> {
	        InstructionParser.parse("2 3 4");
	    });
		
		assertThrows(IllegalArgumentException.class, () -> {
	        InstructionParser.parse("3 -1");
	    });
		
		assertThrows(IllegalArgumentException.class, () -> {
	        InstructionParser.parse("20 51");
	    });
	}
	
	@Test
	void validateParse() {
		String boundaryLine = "4 5";
		int[] boundary = MarsBoundaryParser.parse(boundaryLine);
		assertTrue(boundary.length == 2);
		assertEquals(4, boundary[0]);
		assertEquals(5, boundary[1]);
	}

}
