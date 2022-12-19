package edu.umb.cs680.hw08;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.*;

import java.time.LocalDateTime;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import edu.umb.cs680.hw08.Directory;
import edu.umb.cs680.hw08.File;
import edu.umb.cs680.hw08.Link;

public class LinkTest {



	static LocalDateTime localTime = LocalDateTime.now();

	Directory root = new Directory(null, "root", 0, localTime);  // directory has size 0

	Directory bin = new Directory(root, "bin", 0, localTime);
	File y = new File(bin, "y", 30, localTime);

	Directory home = new Directory(root, "home", 0, localTime);

	Directory pictures = new Directory(home, "pictures", 0, localTime);
	File a = new File(pictures, "a", 30, localTime);
	File b = new File(pictures, "b", 30, localTime);
	File c = new File(home, "c", 15, localTime);
	Link m = new Link(home, "m", 0, localTime, bin);
	
	private String[] linkToStringArray(Link l) {
		String[] linkInfo = { String.valueOf(l.isLink()), l.getName(), String.valueOf(l.getSize()),
				String.valueOf(l.getCreationTime()), l.getParent().getName(), l.getTarget().getName() };
		return linkInfo;
	}

	@Test
	public void verifyLinkEquality() {
		String[] expected = { "true", "m", "0", String.valueOf(m.getCreationTime()), "home", "bin" };
		Link actual = m;
		assertArrayEquals(expected, linkToStringArray(actual));
	}

	@Test
	public void isDirectory() {
		assertFalse(m.isDirectory());
	}
	
	@Test
	public void isFile() {
		assertFalse(m.isFile());
	}
	
	@Test
	public void isLink() {
		assertTrue(m.isLink());
	}
	
	@Test
	public void getTargetTesting() {
		assertSame(bin, m.getTarget());
	}
	
	@Test
	public void setTargetTesting() {
		m.setTarget(apps);
		assertSame(apps, m.getTarget());
	}

}
