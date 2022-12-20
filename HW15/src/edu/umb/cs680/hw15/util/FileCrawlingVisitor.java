package edu.umb.cs680.hw15.fs.util;

import java.util.LinkedList;

import edu.umb.cs680.hw15.Directory;
import edu.umb.cs680.hw15.FSVisitor;
import edu.umb.cs680.hw15.File;
import edu.umb.cs680.hw15.Link;

public class FileCrawlingVisitor implements FSVisitor{
	private LinkedList<File> files = new LinkedList<>();
	
	public void visit(Link link) {
		return;
	}

	public void visit(Directory dir) {
		return;
	}

	public void visit(File file) {
		files.add(file);
	}

	public LinkedList<File> getFiles() {
		return files;
	}

}
