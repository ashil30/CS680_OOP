package edu.umb.cs680.HW09.fs;

import java.time.LocalDateTime;

public class Link extends FSElement{

	private FSElement target;

	public Link(Directory parent, String name, int size, LocalDateTime creationTime, FSElement target) {
		super(parent, name, size, creationTime);
		this.target=target;
		parent.appendChild(this);
	}

	public FSElement getTarget() {
		return this.target;
	}

	@Override
	public boolean isDirectory() {
		return false;
	}

	public void accept(FSVisitor v) {
		v.visit(this);
	}
}
