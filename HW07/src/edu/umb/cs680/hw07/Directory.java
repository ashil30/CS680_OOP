package edu.umb.cs680.hw07;

import java.time.LocalDateTime;
import java.util.LinkedList;


public class Directory extends FSElement{
	private final LinkedList<FSElement> children = new LinkedList<>();
	
	public Directory(Directory parent, String name, int size, LocalDateTime creationTime) {
		super(parent, name, size, creationTime);
	}
	
	public boolean isDirectory() {
		return true;
	}
	
	public LinkedList<FSElement> getChildren(){
		return this.children;
	}
	
	public void appendChild(FSElement child) {
		this.children.add(child);
		child.setParent(this);
	}
	
	public int countChildren() {
		return this.children.size();
	}
	
	public LinkedList<Directory> getSubDirectories() {
		LinkedList<Directory> directory = new LinkedList<>();
		for (FSElement fsElem : children) {
			if (fsElem.isDirectory())
				directory.add((Directory)fsElem);
			}
		}
		return directory;
	}
	
	public LinkedList<File> getFiles(){
		LinkedList<File> files = new LinkedList<>();
		for (FSElement fsElem : children) {
			if (!fsElem.isDirectory()) {
				files.add((File)fsElem);
			}
		}
		return files;
	}
	
	public int getTotalSize() {
		int totalSize = 0;
		for (FSElement fsElem : children) {
			if (fsElem.isDirectory()) {
				totalSize += (Directory)fsElem.getTotalSize();
			}
			else {
				totalSize += fsElem.getSize();
			}
		}
		return totalSize;
	}

}
