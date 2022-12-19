package edu.umb.cs680.hw13;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.*;

import java.time.LocalDateTime;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import edu.umb.cs680.hw13.Directory;
import edu.umb.cs680.hw13.File;
import edu.umb.cs680.hw13.Link;

public class FileTest {
	static LocalDateTime localTime = LocalDateTime.now();

	Directory root = new Directory(null, "root", 0, localTime);  // directory has size 0

	Directory bin = new Directory(root, "bin", 0, localTime);
	File y = new File(bin, "y", 50, localTime);

	Directory home = new Directory(root, "home", 0, localTime);

	Directory pictures = new Directory(home, "pictures", 0, localTime);
	File a = new File(pictures, "a", 50, localTime);
	File b = new File(pictures, "b", 50, localTime);
	File c = new File(home, "c", 25, localTime);
	Link m = new Link(home, "m", 0, localTime, bin);
	
	private String[] fileToStringArray(File f) {
		String[] fileInfo = { String.valueOf(f.isFile()), f.getOwnerName(), String.valueOf(f.getSize()),
							f.getLastModifiedTime(), f.getParent().getName() };
		return fileInfo;
	}


	
	@Test
	public void verifyFileEquality() {
		String[] expected = { "true", "defaultOwnerName", "50", "defaultLastModifiedTime", "pictures" };
		File actual = a;
		assertArrayEquals(expected, fileToStringArray(actual));
	}

	@Test
	public void isDirectoryTestingFalse() {
		assertFalse(b.isDirectory());
	}
	
	@Test
	public void isFileTestingWithTrue() {
		assertTrue(b.isFile());
	}
	
	@Test
	public void isLinkTestingWithFalse() {
		assertFalse(b.isLink());
	}

}
