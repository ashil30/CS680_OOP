package edu.umb.cs680.hw13;

import java.time.LocalDateTime;

public abstract class FSElement {
	protected Directory parent;
	protected String name;
	protected int size;
	protected LocalDateTime creationTime;
	public abstract void accept(FSVisitor v);
	
	public FSElement(Directory parent, String name, int size, LocalDateTime creationTime) {
		this.parent = parent;
		this.name = name;
		this.size = size;
		this.creationTime = creationTime;
	}


	
	public Directory getParent() {
		return parent;
	}



	public String getName() {
		return name;
	}

	public int getSize() {
		return size;
	}
	
	public LocalDateTime getCreationTime() {
		return creationTime;
	}
	
	public abstract boolean isDirectory();

	public abstract boolean isFile();
	public abstract boolean isLink();

	public static void main(String[] args) {
		System.out.println("FSElement Class");
	}
	
}
