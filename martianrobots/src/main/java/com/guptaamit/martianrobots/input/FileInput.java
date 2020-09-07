/**
 * 
 */
package com.guptaamit.martianrobots.input;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.junit.platform.commons.util.StringUtils;

/** Class to return the contents of File line by line.
 * This class is not thread safe
 * @author Amit
 *
 */
public class FileInput implements Input {
	private final List<String> lines;
	private int index = 0;
	public FileInput(String fileName) throws IOException {
		try (Stream<String> stream = Files.lines(Paths.get(fileName))) {
			lines = stream
					.filter(line -> StringUtils.isNotBlank(line))
					.collect(Collectors.toList());
		}
		System.out.println(lines);
	}
	@Override
	public String nextLine() {
		if(index < lines.size()) {
			return lines.get(index++);
		}
		return null;
	}
}
