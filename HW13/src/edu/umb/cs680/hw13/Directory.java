package edu.umb.cs680.hw13;

import java.time.LocalDateTime;
import java.util.Collections;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;

public class Directory extends FSElement{
	private LinkedList<FSElement> child;
	private LinkedList<Directory> myDir = new LinkedList<Directory>();
	private LinkedList<File> files = new LinkedList<File>();
	private LinkedList<Link> link = new LinkedList<Link>();


	public Directory(Directory parent, String name, int size, LocalDateTime creationTime) {
		super( parent,name, size, creationTime);
		if(parent != null){
			parent.appendChild(this);
		}
	}

	public LinkedList<FSElement> getChild() {
		return child;
	}

	public LinkedList<FSElement> getChild(Comparator comp){
		Collections.sort(child, comp);
		return child;
	}

	@Override
	public boolean isDirectory() {
		return true;
	}

	@Override
	public boolean isFile() {
		return false;
	}

	public void appendChild(FSElement child){
		if(this.child == null){
			this.child = new LinkedList<FSElement>();
		}
		this.child.add(child);
	}

	public LinkedList<Link> getLinks(){
		LinkedList<Link> link = new LinkedList<>();
		for (FSElement fsElement : getChild()){
			if(fsElement instanceof Link){
				link.add((Link) fsElement);
			}
		}
		return link;
	}

	public int countChildren(){
		return getChild().size() - getLinks().size();
	}

	public LinkedList<Directory> getSubDirectories(){
		LinkedList<Directory> dir = new LinkedList<>();
		for (FSElement fsElement : getChild()){
			if (fsElement instanceof Directory){
				dir.add((Directory) fsElement);
			}
		}
		return dir;
	}

	public LinkedList<Directory> getSubDirectories(Comparator<FSElement> comp){
		myDir = getSubDirectories();
		Collections.sort(myDir, comp);
		return myDir;
	}

	public LinkedList<File> getFiles(){
		LinkedList<File> file = new LinkedList<>();
		for (FSElement fsElement : getChild()){
			if (fsElement instanceof File){
				file.add((File) fsElement);
			}
		}
		return file;
	}

	public LinkedList<File> getFiles(Comparator<FSElement> comp){
		files = getFiles();
		Collections.sort(files, comp);
		return files;
	}

	public int getFileSize(){
		FSElement fsElement = this;
		Directory dir = (Directory) fsElement;
		int total = 0;
		for (int child = 0; child < dir.getChild().size(); child++){
			total += dir.getChild().get(child).getSize();
		}
		return total;
	}

	public Directory searchDirectoryByName(String directoryName){
		Directory dir = null;
		if (directoryName.equals(getName())){
			dir = this;
		}
		else {
			for (Directory searchDir : getSubDirectories()){
				if (dir == null){
					dir = searchDir.searchDirectoryByName(directoryName);
				}
				if (directoryName.equals(searchDir.getName())){
					dir = searchDir;
					break;
				}
			}
		}
		return dir;
	}

	public File searchFileByName(String fName){
		File file = null;
		for (File f : getFiles()){
			if(fName.equals(f.getName())){
				file = f;
			}
		}
		if (file == null){
			for (Directory dir: getSubDirectories()){
				file = dir.searchFileByName(fName);
				if (file != null){
					break;
				}
			}
		}
		return file;
	}


	public boolean isLink() {
		return false;
	}
	public void accept(FSVisitor v) {
		v.visit(this);
		for (FSElement e : child) {
			e.accept(v);
		}
	}



		public Link searchLinkByName(String lName){
			Link link = null;
			for (Link l : getLinks()){
				if(lName.equals(l.getName())){
					link = l;
				}
			}
			if (link == null){
				for (Directory dir : getSubDirectories()){
					link = dir.searchLinkByName(lName);
					if (link != null){
						break;
					}
				}
			}
			return link;
		}
	}
