package edu.umb.cs680.hw07;

import java.time.LocalDateTime;
import java.util.LinkedList;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;
import edu.umb.cs680.hw07.Directory;
import edu.umb.cs680.hw07.FileSystem;

public class FileSystemTest {

	@Test
	public void getFileSystemNonNull() {

		assertNotNull(FileSystem.getFileSystem());
	}

	@Test
	public void getFileSystemIdentical() {
		FileSystem file1 = FileSystem.getFileSystem();
		FileSystem file2 = FileSystem.getFileSystem();
		assertSame(file1, file2);
	}

}
