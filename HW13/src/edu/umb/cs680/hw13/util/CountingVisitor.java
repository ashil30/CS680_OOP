package edu.umb.cs680.hw13.fs.util;

import edu.umb.cs680.hw13.Directory;
import edu.umb.cs680.hw13.FSVisitor;
import edu.umb.cs680.hw13.File;
import edu.umb.cs680.hw13.Link;

public class CountingVisitor implements FSVisitor{
	private int directoryNum = 0;
	private int fileNum = 0;
	private int linkNum = 0;

	public void visit(Link link) {
		linkNum++;
	}

	public void visit(Directory directory) {
		directoryNum++;
	}

	public void visit(File file) {
		fileNum++;
	}

	public int getDirNum() {
		return directoryNum;
	}

	public int getFileNum() {
		return fileNum;
	}

	public int getLinkNum() {
		return linkNum;
	}

}
