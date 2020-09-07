package com.guptaamit.martianrobots;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class RobotTest {
	private Robot robot;
	private Position startingPosition;
	private Mars mars;
	
	@BeforeEach
	void setUp() throws Exception {
		startingPosition = new Position(new Coordinate(1, 1), Orientation.EAST);
		mars  = new Mars(3, 4);
		robot = new Robot(mars, startingPosition);
	}
	
	@Test
	void testLeftInstruction() {
		robot.handle(Instruction.LEFT);
		assertEquals(Orientation.NORTH, robot.getPosition().getOrientation());
	}
	
	@Test
	void testRightInstruction() {
		robot.handle(Instruction.RIGHT);
		assertEquals(Orientation.SOUTH, robot.getPosition().getOrientation());
	}
	
	@Test
	void testForwardInstruction() {
		robot.handle(Instruction.FORWARD);
		assertEquals(2, robot.getPosition().getCoordinate().getX());
		assertFalse(robot.isLost());
		assertFalse(mars.isRobotLostHere(robot.getPosition().getCoordinate()));
	}
	
	@Test
	void testRobotIsLost() {
		robot.handle(Instruction.FORWARD);
		robot.handle(Instruction.FORWARD);
		robot.handle(Instruction.FORWARD);
		
		assertEquals(3, robot.getPosition().getCoordinate().getX());
		assertTrue(robot.isLost());
		assertTrue(mars.isRobotLostHere(robot.getPosition().getCoordinate()));
	}
	
	@Test
	void testRobotIsLostAtSameCoordinateAgain() {
		robot.handle(Instruction.FORWARD);
		robot.handle(Instruction.FORWARD);
		robot.handle(Instruction.FORWARD);
		//Assert first Robot is Lost
		assertEquals(3, robot.getPosition().getCoordinate().getX());
		assertTrue(robot.isLost());
		assertTrue(mars.isRobotLostHere(robot.getPosition().getCoordinate()));
		
		Robot robot2 = new Robot(mars, startingPosition);
		robot2.handle(Instruction.FORWARD);
		robot2.handle(Instruction.FORWARD);
		robot2.handle(Instruction.FORWARD);
		//Assert that second robot is not lost
		assertEquals(3, robot2.getPosition().getCoordinate().getX());
		assertFalse(robot2.isLost());
	}
}
