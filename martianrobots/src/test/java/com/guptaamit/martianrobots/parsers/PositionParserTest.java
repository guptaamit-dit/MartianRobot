package com.guptaamit.martianrobots.parsers;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.Test;

import com.guptaamit.martianrobots.Coordinate;
import com.guptaamit.martianrobots.Orientation;
import com.guptaamit.martianrobots.Position;

public class PositionParserTest {

	@Test
	public void whenInvalidCoordinateThenThrowException() {
		assertThrows(NumberFormatException.class, () -> {
	        PositionParser.parse("1 L N");
	    });
	}
	
	@Test
	public void whenInvalidOrientationThenThrowException() {
		assertThrows(IllegalArgumentException.class, () -> {
	        PositionParser.parse("2 3 A");
	    });
	}
	
	@Test
	public void whenInvalidPositionFormatThenThrowException() {
		assertThrows(IllegalArgumentException.class, () -> {
			PositionParser.parse("23N");
	    });
	}
	
	@Test
	public void validateParse() {
		Position position = PositionParser.parse("2 3 N");
		assertEquals(new Coordinate(2, 3), position.getCoordinate());
		assertEquals(Orientation.NORTH, position.getOrientation());
	}
	
}
