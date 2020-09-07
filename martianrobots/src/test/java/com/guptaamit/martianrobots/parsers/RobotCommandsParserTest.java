package com.guptaamit.martianrobots.parsers;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import java.util.List;

import org.junit.jupiter.api.Test;

import com.guptaamit.martianrobots.RobotCommand;
import com.guptaamit.martianrobots.input.Input;

public class RobotCommandsParserTest {

	@Test
	void validateParse() {
		Input input = mock(Input.class);
		when(input.nextLine()).thenReturn("1 1 E", "RFRFRFRF", "3 2 N", "FRRFLLFFRRFLL");
		List<RobotCommand> robotCommands = RobotCommandsParser.parse(input);
		assertEquals(2, robotCommands.size());
	}
	
	

}
