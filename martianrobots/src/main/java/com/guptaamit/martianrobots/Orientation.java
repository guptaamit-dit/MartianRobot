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
public enum Orientation {
	NORTH("N"), SOUTH("S"), EAST("E"), WEST("W");
	private final String code;
	
	private static final Map<String, Orientation> codeToOrientationMap  = new HashMap<>();
	static {
		for(Orientation orientation : values()) {
			codeToOrientationMap.put(orientation.code, orientation);
		}
	}
	
	private Orientation(String code) {
		this.code = code;
	}
	
	public String getCode() {
		return code;
	}
	
	public static Orientation of(String code) {
		Orientation orientation = codeToOrientationMap.get(code);
		if(orientation==null) {
			throw new IllegalArgumentException("Wrong Orientation = "+code);
		}
		return codeToOrientationMap.get(code);
	}
}
