package edu.umb.cs680.hw15;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.*;

import java.time.LocalDateTime;
import java.util.LinkedList;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import edu.umb.cs680.hw15.Directory;
import edu.umb.cs680.hw15.FSElement;
import edu.umb.cs680.hw15.File;
import edu.umb.cs680.hw15.Link;
import edu.umb.cs680.hw15.ElementKindComparator;
import edu.umb.cs680.hw15.ReverseAlphabeticalComparator;

public class DirectoryTest {
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

	private String[] dirToStringArray(Directory d) {
		String[] dirInfo = { String.valueOf(d.isDirectory()), d.getOwnerName(), String.valueOf(d.getTotalSize()),
							d.getLastModifiedTime(), String.valueOf(d.countChildren()) };
		return dirInfo;
	}

	@Test
	public void verifyDirectoryEqualityRoot() {
		String[] expected = { "true", "defaultOwnerName", "150", "defaultLastModifiedTime", "3" };
		Directory actual = root;
		assertArrayEquals(expected, dirToStringArray(actual));
	}
	
	@Test
	public void verifyDirectoryEqualityHome() {
		String[] expected = { "true", "defaultOwnerName", "120", "defaultLastModifiedTime", "3" };
		Directory actual = home;
		assertArrayEquals(expected, dirToStringArray(actual));
	}
	
	@Test
	public void isDirectoyTestingWithRoot() {
		assertTrue(root.isDirectory());
	}
	
	@Test
	public void isFileTestingWithRoot() {
		assertFalse(root.isFile());
	}
	
	@Test
	public void isLinkTestingWithRoot() {
		assertFalse(root.isLink());
	}
	
	@Test
	public void appendChildrenTestingWithRoot() {
		assertSame(root, apps.getParent());
	}
	
	@Test
	public void appendChildrenTestingWithHome() {
		assertSame(home, c.getParent());
	}
	
	@Test
	public void countChildrenTestingWithRoot() {
		assertEquals(3, root.countChildren());;
	}
	
	@Test
	public void countChildrenTestingWithHome() {
		assertSame(3, home.countChildren());
	}
	
	@Test
	public void getChildrenOfHome() {
		FSElement[] expected = new FSElement[3];
		expected[0] = c;
		expected[1] = m;
		expected[2] = pictures;
		FSElement[] actual = new FSElement[3];
		LinkedList<FSElement> children = home.getChildren();
		actual[0] = children.get(0);
		actual[1] = children.get(1);
		actual[2] = children.get(2);
		assertArrayEquals(expected, actual);
	}
	
	@Test
	public void getChildrenOfHomeBasedReverseAlphabetical() {
		FSElement[] expected = new FSElement[3];
		expected[0] = pictures;
		expected[1] = m;
		expected[2] = c;
		FSElement[] actual = new FSElement[3];
		LinkedList<FSElement> children = home.getChildren(new ReverseAlphabeticalComparator());
		actual[0] = children.get(0);
		actual[1] = children.get(1);
		actual[2] = children.get(2);
		assertArrayEquals(expected, actual);
	}
	
	@Test
	public void getChildrenOfHomeBasedElementKind() {
		FSElement[] expected = new FSElement[3];
		expected[0] = pictures;
		expected[1] = c;
		expected[2] = m;
		FSElement[] actual = new FSElement[3];
		LinkedList<FSElement> children = home.getChildren(new ElementKindComparator());
		actual[0] = children.get(0);
		actual[1] = children.get(1);
		actual[2] = children.get(2);
		assertArrayEquals(expected, actual);
	}
	
	@Test
	public void getSubDirectoriesOfRoot() {
		Directory[] expected = new Directory[3];
		expected[0] = apps;
		expected[1] = bin;
		expected[2] = home;
		Directory[] actual = new Directory[3];
		LinkedList<Directory> subDirectories = root.getSubDirectories();
		actual[0] = subDirectories.get(0);
		actual[1] = subDirectories.get(1);
		actual[2] = subDirectories.get(2);
		assertArrayEquals(expected, actual);
	}
	
	@Test
	public void getSubDirectoriesOfRootBasedReverseAlphabetical() {
		Directory[] expected = new Directory[3];
		expected[0] = home;
		expected[1] = bin;
		expected[2] = apps;
		Directory[] actual = new Directory[3];
		LinkedList<Directory> subDirectories = root.getSubDirectories(new ReverseAlphabeticalComparator());
		actual[0] = subDirectories.get(0);
		actual[1] = subDirectories.get(1);
		actual[2] = subDirectories.get(2);
		assertArrayEquals(expected, actual);
	}
	
	@Test
	public void getSubDirectoriesOfRootBasedElementKind() {
		Directory[] expected = new Directory[3];
		expected[0] = apps;
		expected[1] = bin;
		expected[2] = home;
		Directory[] actual = new Directory[3];
		LinkedList<Directory> subDirectories = root.getSubDirectories(new ElementKindComparator());
		actual[0] = subDirectories.get(0);
		actual[1] = subDirectories.get(1);
		actual[2] = subDirectories.get(2);
		assertArrayEquals(expected, actual);
	}
	
	@Test
	public void getSubDirectoriesTestingWithHome() {
		assertSame(pictures, home.getSubDirectories().get(0));
	}
	
	@Test
	public void getFilesTestingWithHome() {
		assertSame(c, home.getFiles().get(0));
	}
	
	@Test
	public void getFilesOfPictures() {
		File[] expected = new File[2];
		expected[0] = a;
		expected[1] = b;
		File[] actual = new File[2];
		LinkedList<File> files = pictures.getFiles();
		actual[0] = files.get(0);
		actual[1] = files.get(1);
		assertArrayEquals(expected, actual);
	}
	
	@Test
	public void getFilesOfPicturesBasedReverseAlphabetical() {
		File[] expected = new File[2];
		expected[0] = b;
		expected[1] = a;
		File[] actual = new File[2];
		LinkedList<File> files = pictures.getFiles(new ReverseAlphabeticalComparator());
		actual[0] = files.get(0);
		actual[1] = files.get(1);
		assertArrayEquals(expected, actual);
	}
	
	@Test
	public void getFilesOfPicturesBasedElementKind() {
		File[] expected = new File[2];
		expected[0] = a;
		expected[1] = b;
		File[] actual = new File[2];
		LinkedList<File> files = pictures.getFiles(new ElementKindComparator());
		actual[0] = files.get(0);
		actual[1] = files.get(1);
		assertArrayEquals(expected, actual);
	}
	
	@Test
	public void getLinksTestingWithHome() {
		assertSame(m, home.getLinks().get(0));
	}
	
	@Test
	public void getLinksTestingWithPictures() {
		assertSame(n, pictures.getLinks().get(0));
	}
	
	@Test
	public void getTotalSizeTestingWithRoot() {
		assertEquals(150, root.getTotalSize());
	}
	
	@Test
	public void getTotalSizeTestingWithHome() {
		assertEquals(120, home.getTotalSize());
	}

}
