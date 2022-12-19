package edu.umb.cs680.hw08;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.*;

import java.time.LocalDateTime;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import edu.umb.cs680.hw08.Directory;
import edu.umb.cs680.hw08.File;

public class FileTest {
	static LocalDateTime localTime = LocalDateTime.now();

	Directory root = new Directory(null, "root", 0, localTime);

	Directory prog = new Directory(root, "prog", 0, localTime);
	File x = new File(prog, "x", 50, localTime);

	Directory bin = new Directory(root, "bin", 0, localTime);
	File y = new File(bin, "y", 60, localTime);

	Directory home = new Directory(root, "home", 0, localTime);

	File c = new File(home, "c", 70, localTime);

	Link m = new Link(home, "m", 0, localTime, bin);
	
	private String[] fileToStringArray(File f) {
		String[] fileInfo = { String.valueOf(f.isDirectory()), f.getName(), String.valueOf(f.getSize()),
				String.valueOf(f.getCreationTime()), f.getParent().getName() };
		return fileInfo;
	}

	@Test
	public void isLinkTesting() {
		assertFalse(c.isLink());
	}

	@Test
	public void verifyFileEqualityX() {
		String[] expected = { "false", "x", "50", String.valueOf(x.getCreationTime()), "prog" };
		File actual = x;
		assertArrayEquals(expected, fileToStringArray(actual));
	}
	
	@Test
	public void verifyFileEqualityA() {
		String[] expected = { "false", "c", "70", String.valueOf(a.getCreationTime()), "home" };
		File actual = c;
		assertArrayEquals(expected, fileToStringArray(actual));
	}

	@Test
	public void isDirectoyTestingFalse() {
		assertFalse(c.isDirectory());
	}

}
