package edu.umb.cs680.hw07;

import static org.junit.jupiter.api.Assertions.*;

import java.time.LocalDateTime;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import edu.umb.cs680.hw07.Directory;
import edu.umb.cs680.hw07.File;

public class FileTest {
	static LocalDateTime localTime = LocalDateTime.now();

	Directory root = new Directory(null, "root", 0, localTime);

	Directory prog = new Directory(root, "prog", 0, localTime);
	File x = new File(prog, "x", 110, localTime);

	Directory bin = new Directory(root, "bin", 0, localTime);
	File y = new File(bin, "y", 120, localTime);

	Directory home = new Directory(root, "home", 0, localTime);

	File c = new File(home, "c", 130, localTime);
	
	private String[] fileToStringArray(File f) {
		String[] fileInfo = { String.valueOf(f.isDirectory()), f.getName(), String.valueOf(f.getSize()),
				String.valueOf(f.getCreationTime()), f.getParent().getName() };
		return fileInfo;
	}

	@Test
	public void verifyFileEqualityX() {
		String[] expected = { "false", "x", "110", String.valueOf(x.getCreationTime()), "prog" };
		File actual = x;
		assertArrayEquals(expected, fileToStringArray(actual));
	}
	
	@Test
	public void verifyFileEqualityA() {
		String[] expected = { "false", "c", "130", String.valueOf(c.getCreationTime()), "home" };
		File actual = c;
		assertArrayEquals(expected, fileToStringArray(actual));
	}

	@Test
	public void isDirectoyTestingFalse() {
		assertFalse(c.isDirectory());
	}

}
