package edu.umb.cs680.HW09;
import static org.junit.jupiter.api.Assertions.*;

import java.time.LocalDateTime;
import java.util.LinkedList;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import edu.umb.cs680.HW09.fs.Directory;
import edu.umb.cs680.HW09.fs.File;
import edu.umb.cs680.HW09.fs.Link;
import edu.umb.cs680.HW09.fs.util.FileSearchVisitor;

public class FileSearchVisitorTest {
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

	@BeforeAll
	static void setUpBeforeClass() throws Exception {
		root = new Directory(null, "root", 0, LocalDateTime.now());
		src = new Directory(root, "src", 0, LocalDateTime.now());
		bin = new Directory(root, "bin", 0, LocalDateTime.now());
		home = new Directory(root, "home", 0, LocalDateTime.now());
		test = new Directory(home, "test", 0, LocalDateTime.now());
		x = new File(src, "x", 10, LocalDateTime.now());
		y = new File(bin, "y", 20, LocalDateTime.now());
		a = new File(test, "a", 30, LocalDateTime.now());
		b = new File(test, "b", 40, LocalDateTime.now());
		c = new File(home, "c", 50, LocalDateTime.now());
		m = new Link(home, "m", 0, LocalDateTime.now(), bin);
		n = new Link(test, "n", 0, LocalDateTime.now(), y);

	}

	@Test
	public void searchFileA() {
		FileSearchVisitor visitor = new FileSearchVisitor("a");
		root.accept(visitor);
		assertSame(a, visitor.getFoundFiles().get(0));
	}
	
	@Test
	public void searchFilesABC() {
		FileSearchVisitor visitor = new FileSearchVisitor("a");
		root.accept(visitor);
		visitor.setFileName("b");
		root.accept(visitor);
		visitor.setFileName("c");
		root.accept(visitor);
		LinkedList<File> actual = visitor.getFoundFiles();
		LinkedList<File> expected = new LinkedList<>();
		expected.add(a);
		expected.add(b);
		expected.add(c);
		assertArrayEquals(expected.toArray(), actual.toArray());
	}

}
