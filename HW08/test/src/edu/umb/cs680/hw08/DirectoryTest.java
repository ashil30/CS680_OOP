package edu.umb.cs680.hw08;

import static org.junit.jupiter.api.Assertions.*;

import java.time.LocalDateTime;
import java.util.Optional;

import org.junit.jupiter.api.Test;

class DirectoryTest {

	static LocalDateTime localTime = LocalDateTime.now();


	Directory root = new Directory(null,"root",0, localTime);
	Directory apps = new Directory(root,"apps",0, localTime);
	Directory home = new Directory(root,"home",0, localTime);
	Directory bin = new Directory(root,"bin",0, localTime);
	Directory pictures = new Directory(home,"pictures",0, localTime);

	File a = new File(pictures,"a",1,localTime);
	File b = new File(pictures,"b",1,localTime);
	File c = new File(home,"c",1,localTime);
	File y = new File(bin,"y",1,localTime);
	File x = new File(apps,"e",1,localTime);


	private String[] dirToStringArray(Directory d) {
		Optional<Directory> optionalDirectory = Optional.ofNullable(d.getParent());
		String[] dirInfo = {Boolean.toString(d.isDirectory()), d.getName(), Integer.toString(d.getSize()), d.getCreationTime().toString(), Integer.toString(d.countChildren()), Integer.toString(d.getTotalSize()), optionalDirectory.isPresent()?d.getParent().getName():null};
		return dirInfo;
	}

	@Test
	public void verifyDirectoryEqualityHome() {
		String[] expected={"true","home","0",localTime.toString(),"2","3","root"};
		assertArrayEquals(expected,dirToStringArray(home));
	}
	@Test
	public void verifyDirectoryEqualityRoot() {
		String expected[] = {"true", "root", "0", localTime.toString(), "3", "5",null};
		assertArrayEquals(expected, dirToStringArray(root));
	}
	@Test
	public void verifyDirectoryEqualityapps() {
		String expected[] = {"true", "apps", "0", localTime.toString(), "1", "1", "root"};
		assertArrayEquals(expected, dirToStringArray(apps));
	}

	@Test
	public void verifyDirectoryEqualitybin() {
		String expected[] = {"true", "bin", "0", localTime.toString(), "1", "1", "root"};
		assertArrayEquals(expected, dirToStringArray(bin));
	}

	@Test
	public void verifyDirectoryEqualitypictures() {
		String expected[] = {"true", "pictures", "0", localTime.toString(), "2", "2", "home"};
		assertArrayEquals(expected, dirToStringArray(pictures));
	}

	@Test
	public void DirectoryFileTest() {
		assertTrue(apps.isDirectory());
		assertFalse(a.isDirectory());
		assertTrue(root.isDirectory());
		assertTrue(home.isDirectory());
		assertTrue(bin.isDirectory());
		assertFalse(b.isDirectory());
	}

	@Test
	public void subFilesAndFolderNumberTest() {
		assertEquals(3,root.countChildren());
		assertEquals(1,bin.countChildren());
		assertEquals(1,apps.countChildren());
		assertEquals(2,home.countChildren());
		assertEquals(2,pictures.countChildren());
	}

}