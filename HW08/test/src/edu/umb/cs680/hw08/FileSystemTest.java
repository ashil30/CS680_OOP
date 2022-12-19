package edu.umb.cs680.hw08;

import java.time.LocalDateTime;
import java.util.LinkedList;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;
import edu.umb.cs680.hw08.Directory;
import edu.umb.cs680.hw08.FileSystem;

public class FileSystemTest {

	@Test
	public void getFileSystemNonNull() {
		assertNotNull(FileSystem.getFileSystem());
	}

	@Test
	public void getFileSystemIdentical() {
		FileSystem f1 = FileSystem.getFileSystem();
		FileSystem f2 = FileSystem.getFileSystem();
		assertSame(f1, f2);
	}

}
