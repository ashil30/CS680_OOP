package edu.umb.cs680.HW09;

import static org.junit.jupiter.api.Assertions.*;

import java.time.LocalDateTime;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import edu.umb.cs680.HW09.fs.Directory;
import edu.umb.cs680.HW09.fs.File;
import edu.umb.cs680.HW09.fs.Link;
import edu.umb.cs680.HW09.fs.util.CountingVisitor;

class CountingVisitorTest {
	private static Directory root;
	private static Directory apps;
	private static Directory bin;
	private static Directory home;
	private static Directory pictures;
	private static File x;
	private static File y;
	private static File a;
	private static File b;
	private static File c;
	private static Link e;
	private static Link d;
	private static CountingVisitor rootVisitor;
	private static CountingVisitor homeVisitor;

	@BeforeAll
	static void setUpBeforeClass() throws Exception {
		root = new Directory(null, "root", 0, LocalDateTime.now());
		apps = new Directory(root, "apps", 0, LocalDateTime.now());
		bin = new Directory(root, "bin", 0, LocalDateTime.now());
		home = new Directory(root, "home", 0, LocalDateTime.now());
		pictures = new Directory(home, "pictures", 0, LocalDateTime.now());
		x = new File(apps, "x", 10, LocalDateTime.now());
		y = new File(bin, "y", 20, LocalDateTime.now());
		a = new File(pictures, "a", 30, LocalDateTime.now());
		b = new File(pictures, "b", 40, LocalDateTime.now());
		c = new File(home, "c", 50, LocalDateTime.now());
		e = new Link(apps, "e", 0, LocalDateTime.now(), x);
		d = new Link(pictures, "d", 0, LocalDateTime.now(), pictures);

		rootVisitor = new CountingVisitor();
		homeVisitor = new CountingVisitor();
		root.accept(rootVisitor);
		home.accept(homeVisitor);
	}

	@Test
	public void verifyDirectoryNumberRoot() {
		int expected = 5;
		int actual = rootVisitor.getDirNum();
		assertEquals(expected, actual);
	}
	
	@Test
	public void verifyFileNumberRoot() {
		int expected = 5;
		int actual = rootVisitor.getFileNum();
		assertEquals(expected, actual);
	}
	
	@Test
	public void verifyLinkNumberRoot() {
		int expected = 2;
		int actual = rootVisitor.getLinkNum();
		assertEquals(expected, actual);
	}
	
	@Test
	public void verifyDirectoryNumberHome() {
		int expected = 2;
		int actual = homeVisitor.getDirNum();
		assertEquals(expected, actual);
	}
	
	@Test
	public void verifyFileNumberHome() {
		int expected = 3;
		int actual = homeVisitor.getFileNum();
		assertEquals(expected, actual);
	}
	
	@Test
	public void verifyLinkNumberHome() {
		int expected = 1;
		int actual = homeVisitor.getLinkNum();
		assertEquals(expected, actual);
	}

}

