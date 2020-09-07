package com.guptaamit.martianrobots;
/**
 * 
 * @author ranck
 *
 */
public class Mars {
	public static final int BOUNDARY_UPPER_LIMIT = 50;
	private final int boundaryX;
	private final int boundaryY;
	private final boolean[][] lostScent;
	
	public Mars(int boundaryX, int boundaryY) {
		this.boundaryX = boundaryX;
		this.boundaryY = boundaryY;
		lostScent = new boolean[this.boundaryX+1][this.boundaryY+1];
	}
	
	/**
	 * This method is inform Mars that robot is lost at this Coordinate
	 * @param coordinate
	 */
	public void lostRobot(Coordinate coordinate) {
		lostScent[coordinate.getX()][coordinate.getY()] = true;
	}
	
	/**
	 * This method returns if the robot has lost at his coordinate before
	 * @param coordinate
	 * @return true if robot has lost before at his location otherwise false
	 */
	public boolean isRobotLostHere(Coordinate coordinate) {
		return lostScent[coordinate.getX()][coordinate.getY()];
	}
	
}
