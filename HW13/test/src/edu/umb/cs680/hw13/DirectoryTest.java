package edu.umb.cs680.hw13;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.*;

import java.time.LocalDateTime;
import java.util.LinkedList;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import edu.umb.cs680.hw13.Directory;
import edu.umb.cs680.hw13.File;
import edu.umb.cs680.hw13.Link;

public class DirectoryTest {
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

	private String[] dirToStringArray(Directory d) {
		String[] dirInfo = { String.valueOf(d.isDirectory()), d.getOwnerName(), String.valueOf(d.getTotalSize()),
							d.getLastModifiedTime(), String.valueOf(d.countChildren()) };
		return dirInfo;
	}

	@Test
	public void verifyDirectoryEquality() {
		String[] expected = { "true", "defaultOwnerName", "175", "defaultLastModifiedTime", "2" };
		Directory actual = root;
		assertArrayEquals(expected, dirToStringArray(actual));
	}
	
	@Test
	public void verifyDirectoryEqualityHome() {
		String[] expected = { "true", "defaultOwnerName", "125", "defaultLastModifiedTime", "1" };
		Directory actual = home;
		assertArrayEquals(expected, dirToStringArray(actual));
	}
	
	@Test
	public void isDirectoryTestingTrue() {
		assertTrue(root.isDirectory());
	}
	
	@Test
	public void isFileTestingFalse() {
		assertFalse(root.isFile());
	}
	
	@Test
	public void isLinkTestingFalse() {
		assertFalse(root.isLink());
	}
	
	@Test
	public void appendChildrenTestingWithRoot() {
		assertSame(root, bin.getParent());
	}
	
	@Test
	public void countChildrenTesting() {
		assertEquals(2, root.countChildren());;
	}

	@Test
	public void getLinksTestingWithHome() {
		assertSame(m, home.getLinks().get(0));
	}

	@Test
	public void getTotalSizeTesting() {
		assertEquals(125, home.getTotalSize());
	}

}
