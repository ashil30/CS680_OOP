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
