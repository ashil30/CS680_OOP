package edu.umb.cs680.hw13;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.*;

import java.time.LocalDateTime;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import edu.umb.cs680.hw13.Directory;
import edu.umb.cs680.hw13.File;
import edu.umb.cs680.hw13.Link;

public class LinkTest {
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
	
	private String[] linkToStringArray(Link l) {
		String[] linkInfo = { String.valueOf(l.isLink()), l.getOwnerName(), String.valueOf(l.getSize()),
						l.getLastModifiedTime(), l.getParent().getName(), l.getTarget().getName() };
		return linkInfo;
	}

	@Test
	public void verifyLinkEquality() {
		String[] expected = { "true", "defaultOwnerName", "0", "defaultLastModifiedTime", "home", "bin" };
		Link actual = m;
		assertArrayEquals(expected, linkToStringArray(actual));
	}
	

	@Test
	public void isDirectoyTestingFalse() {
		assertFalse(m.isDirectory());
	}
	
	@Test
	public void isFileTestingFalse() {
		assertFalse(m.isFile());
	}
	
	@Test
	public void isLinkTestingTrue() {
		assertTrue(m.isLink());
	}
	
	@Test
	public void getTargetTestingTrue() {
		assertSame(bin, m.getTarget());
	}
	
	@Test
	public void setTargetTesting() {
		m.setTarget(bin);
		assertSame(bin, m.getTarget());
	}

}
