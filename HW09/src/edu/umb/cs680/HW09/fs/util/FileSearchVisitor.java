package edu.umb.cs680.HW09.fs.util;

import java.util.LinkedList;

import edu.umb.cs680.HW09.fs.Directory;
import edu.umb.cs680.HW09.fs.FSVisitor;
import edu.umb.cs680.HW09.fs.File;
import edu.umb.cs680.HW09.fs.Link;
public class FileSearchVisitor implements FSVisitor{

	private String fileName;
	private LinkedList<File> foundFiles;
	public FileSearchVisitor(String fileName) {
		foundFiles = new LinkedList<>();
		this.fileName = fileName;
	}
	public void setFileName(String name) {
		this.fileName = name;
	}

	public String getName() {
		return this.fileName;
	}

	public LinkedList<File> getFoundFiles() {
		return this.foundFiles;
	}

	@Override
	public void visit(Link link) {
		return ;
	}

	@Override
	public void visit(Directory dir) {
		return;
	}

	@Override
	public void visit(File file) {
		if(fileName.equals(file.getName())) {
			foundFiles.add(file);
		}
	}

}