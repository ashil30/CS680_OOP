package edu.umb.cs680.hw08;

import static org.junit.jupiter.api.Assertions.*;

import java.time.LocalDateTime;
import java.util.Optional;

import org.junit.jupiter.api.Test;

class LinkTest {

	static LocalDateTime localTime = LocalDateTime.now();


	Directory root = new Directory(null,"root",0, localTime);
	Directory apps = new Directory(root,"apps",0, localTime);
	Directory home = new Directory(root,"home",0, localTime);
	Directory bin = new Directory(root,"bin",0, localTime);
	Directory pictures = new Directory(home,"pictures",0, localTime);

	File a = new File(pictures,"a",1,localTime);
	File b = new File(pictures,"b",1,localTime);
	File c = new File(home,"c",1,localTime);


	Link d = new Link(root, "d", 0, localTime, pictures);
	Link e = new Link(root, "e", 0, localTime, apps);

	private String[] LinkToStringArray(Link l) {
		Optional<Directory> optionalDirectory = Optional.ofNullable(l.getParent());
		String[] linkInfo = {Boolean.toString(l.isDirectory()), l.getName(), Integer.toString(l.getSize()), l.getCreationTime().toString(), l.getTarget().getName()};
		return linkInfo;
	}

	@Test
	public void verifyLinksTest() {
		assertFalse(d.isDirectory());
		assertFalse(e.isDirectory());
	}

	@Test
	public void verifyTargetEqualityY() {
		String[] expected={"false","e","0",localTime.toString(),"apps"};
		assertArrayEquals(expected,LinkToStringArray(e));
	}

	@Test
	public void verifyTargetEqualityX() {
		String[] expected={"false","d","0",localTime.toString(),"pictures"};
		assertArrayEquals(expected,LinkToStringArray(d));
	}

	@Test
	public void verifyParentOfTarget() {
		assertSame("home", d.getTarget().getParent().getName());
		assertSame("root", e.getTarget().getParent().getName());
	}

}