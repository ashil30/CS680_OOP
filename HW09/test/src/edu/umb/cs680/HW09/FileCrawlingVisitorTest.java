package edu.umb.cs680.hw09;

import static org.junit.Assert.assertArrayEquals;

import java.time.LocalDateTime;
import java.util.LinkedList;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import edu.umb.cs680.hw09..Directory;
import edu.umb.cs680.hw09..File;
import edu.umb.cs680.hw09..Link;
import edu.umb.cs680.hw09..util.FileCrawlingVisitor;

public class FileCrawlingVisitorTest {
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
	private static Link m;
	private static Link n;

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
		m = new Link(home, "m", 0, LocalDateTime.now(), bin);
		n = new Link(pictures, "n", 0, LocalDateTime.now(), y);
		root.appendChild(apps);
		root.appendChild(bin);
		root.appendChild(home);
		apps.appendChild(x);
		apps.appendChild(y);
		home.appendChild(pictures);
		home.appendChild(c);
		home.appendChild(m);
		pictures.appendChild(a);
		pictures.appendChild(b);
		pictures.appendChild(n);
	}

	@Test
	public void verifyFilesInRoot() {
		FileCrawlingVisitor visitor = new FileCrawlingVisitor();
		root.accept(visitor);
		LinkedList<File> actual = visitor.getFiles();
		LinkedList<File> expected = new LinkedList<>();
		expected.add(x);
		expected.add(y);
		expected.add(a);
		expected.add(b);
		expected.add(c);
		assertArrayEquals(expected.toArray(), actual.toArray());
	}
	
	@Test
	public void verifyFilesInHome() {
		FileCrawlingVisitor visitor = new FileCrawlingVisitor();
		home.accept(visitor);
		LinkedList<File> actual = visitor.getFiles();
		LinkedList<File> expected = new LinkedList<>();
		expected.add(a);
		expected.add(b);
		expected.add(c);
		assertArrayEquals(expected.toArray(), actual.toArray());
	}

}
