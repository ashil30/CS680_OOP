package edu.umb.cs680.HW09;

import static org.junit.jupiter.api.Assertions.*;

import java.time.LocalDateTime;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import edu.umb.cs680.HW09.fs.Directory;
import edu.umb.cs680.HW09.fs.File;
import edu.umb.cs680.HW09.fs.Link;
import edu.umb.cs680.HW09.fs.util.CountingVisitor;

public class CountingVisitorTest {
	private static Directory root;
	private static Directory src;
	private static Directory bin;
	private static Directory home;
	private static Directory test;
	private static File x;
	private static File y;
	private static File a;
	private static File b;
	private static File c;
	private static Link m;
	private static Link n;
	private static CountingVisitor rootVisitor;
	private static CountingVisitor homeVisitor;

	@BeforeAll
	static void setUpBeforeClass() throws Exception {
		root = new Directory(null, "root", 0, LocalDateTime.now());
		src = new Directory(root, "src", 0, LocalDateTime.now() );
		bin = new Directory(root, "bin", 0, LocalDateTime.now() );
		home = new Directory(root, "home", 0, LocalDateTime.now() );
		test = new Directory(home, "test", 0, LocalDateTime.now() );
		x = new File(src, "x", 10, LocalDateTime.now() );
		y = new File(bin, "y", 20, LocalDateTime.now());
		a = new File(test, "a", 30, LocalDateTime.now());
		b = new File(test, "b", 40, LocalDateTime.now());
		c = new File(home, "c", 50, LocalDateTime.now());
		m = new Link(home, "m", 0, LocalDateTime.now(), bin);
		n = new Link(test, "n", 0, LocalDateTime.now(), y);

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
		int expected = 2;
		int actual = homeVisitor.getLinkNum();
		assertEquals(expected, actual);
	}

}

