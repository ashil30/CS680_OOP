package edu.umb.cs680.HW09.fs.util;

import java.util.LinkedList;

import edu.umb.cs680.HW09.fs.Directory;
import edu.umb.cs680.HW09.fs.FSVisitor;
import edu.umb.cs680.HW09.fs.File;
import edu.umb.cs680.HW09.fs.Link;

public class FileCrawlingVisitor implements FSVisitor{
	private LinkedList<File> files = new LinkedList<>();
	
	public void visit(Link link) {
		return;
	}

	public void visit(Directory dir) {
		return;
	}

	public void visit(File file) {
		this.files.add(file);
	}

	public LinkedList<File> getFiles() {
		return files;
	}

}
