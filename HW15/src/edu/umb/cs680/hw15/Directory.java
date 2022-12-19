package edu.umb.cs680.hw13;

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

	public boolean isFile() {
		return false;
	}

	public boolean isLink() {
		return false;
	}
	
	public LinkedList<FSElement> getChildren(){
		Collections.sort(this.children, Comparator.comparing(e -> e.getName()));
		return this.children;
	}
	
	public void appendChild(FSElement child) {
		this.children.add(child);
		child.setParent(this);
		Collections.sort(this.children, Comparator.comparing(e -> e.getName()));
	}
	
	public int countChildren() {
		return this.children.size();
	}
	
	public LinkedList<Directory> getSubDirectories() {
		LinkedList<Directory> directory = new LinkedList<>();
		for (FSElement fsElem : children) {
			if (fsElem.isDirectory())
				dirList.add((Directory)fsElem);
			}
		}
		Collections.sort(directory, Comparator.comparing(e -> e.getName()));
		return directory;
	}
	
	public LinkedList<File> getFiles(){
		LinkedList<File> files = new LinkedList<>();
		for (FSElement fsElem : children) {
			if (!fsElem.isDirectory()) {
				files.add((File)fsElem);
			}
		}
		Collections.sort(files, Comparator.comparing(e -> e.getName()));
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
	public void accept(ApfsFSVisitor v) {
		v.visit(this);
		for (ApfsFSElement e : children) {
			e.accept(v);
		}
	}
	public LinkedList<FSElement> getChildren(Comparator<FSElement> comparator){
		Collections.sort(this.children, comparator);
		return this.children;
	}

	public LinkedList<Directory> getSubDirectories(Comparator<FSElement> comparator) {
		LinkedList<Directory> subDirs = getSubDirectories();
		Collections.sort(subDirs, comparator);
		return subDirs;
	}

	public LinkedList<File> getFiles(Comparator<FSElement> comparator) {
		LinkedList<File> files = getFiles();
		Collections.sort(files, comparator);
		return files;
	}

}
