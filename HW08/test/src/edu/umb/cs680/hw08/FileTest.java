package edu.umb.cs680.hw08;

import static org.junit.jupiter.api.Assertions.*;

import java.time.LocalDateTime;

import org.junit.jupiter.api.Test;

class FileTest {

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

	Link d = new Link(root, "x", 0, localTime, pictures);
	Link e = new Link(root, "y", 0, localTime, apps);

	private String[] FileToStringArray(File f) {
		String fileInfo[] = {Boolean.toString(f.isDirectory()), f.getName(), Integer.toString(f.getSize()), f.getCreationTime().toString(), f.getParent().getName()};
		return fileInfo;
	}

	@Test
	public void verifyFileEqualityA() {
		String[] expected={"false","a","1",localTime.toString(),"pictures"};
		assertArrayEquals(expected,FileToStringArray(a));
	}

	@Test
	public void verifyFileEqualityB() {
		String[] expected={"false","b","1",localTime.toString(),"pictures"};
		assertArrayEquals(expected,FileToStringArray(b));
	}

	@Test
	public void verifyFileEqualityF() {
		String[] expected={"false","y","1",localTime.toString(),"bin"};
		assertArrayEquals(expected,FileToStringArray(y));
	}

	@Test
	public void verifyIfFiles() {
		assertFalse(a.isDirectory());
		assertFalse(b.isDirectory());
		assertFalse(c.isDirectory());
		assertFalse(d.isDirectory());
		assertFalse(e.isDirectory());
		assertFalse(a.isDirectory());
	}

}