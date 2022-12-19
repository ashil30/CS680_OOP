package edu.umb.cs680.hw07;

import java.time.LocalDateTime;
import java.util.LinkedList;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import edu.umb.cs680.hw07.Directory;
import edu.umb.cs680.hw07.File;

public class DirectoryTest {

	static LocalDateTime localTime = LocalDateTime.now();

	Directory root = new Directory(null, "root", 0, localTime);  // directory has size 0

	Directory bin = new Directory(root, "bin", 0, localTime);
	File y = new File(bin, "y", 100, localTime);

	Directory home = new Directory(root, "home", 0, localTime);

	Directory pictures = new Directory(home, "pictures", 0, localTime);
	File a = new File(pictures, "a", 100, localTime);
	File b = new File(pictures, "b", 100, localTime);
	File c = new File(home, "c", 45, localTime);

	private String[] dirToStringArray(Directory d) {
		String[] dirInfo = { String.valueOf(d.isDirectory()), d.getName(), String.valueOf(d.getTotalSize()),
				String.valueOf(d.getCreationTime()), String.valueOf(d.countChildren()) };
		return dirInfo;
	}

	@Test
	public void verifyDirectoryEquality() {
		String[] expected = { "true", "root", "345", String.valueOf(root.getCreationTime()), "2" };
		Directory actual = root;
		assertArrayEquals(expected, dirToStringArray(actual));
	}
	
	@Test
	public void verifyDirectoryEqualityHome() {
		String[] expected = { "true", "home", "245", String.valueOf(home.getCreationTime()), "1" };
		Directory actual = home;
		assertArrayEquals(expected, dirToStringArray(actual));
	}
	
	@Test
	public void isDirectory() {

		assertTrue(root.isDirectory());
	}
	
	@Test
	public void appendChildren() {

		assertSame(root, bin.getParent());
	}
	
	@Test
	public void countChildren() {
		assertEquals(2, root.countChildren());;
	}
	
	@Test
	public void countChildrenTestingWithHome() {

		assertSame(1, home.countChildren());
	}
	
	@Test
	public void getTotalSizeTesting() {

		assertEquals(345, root.getTotalSize());
	}
	
	@Test
	public void getTotalSizeTestingWithHome() {

		assertEquals(245, home.getTotalSize());
	}

}
