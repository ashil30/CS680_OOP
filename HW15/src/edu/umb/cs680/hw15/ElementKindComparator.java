package edu.umb.cs680.hw13;

import java.util.Comparator;

public class ElementKindComparator implements Comparator<FSElement>{
	
	private int elementKindToInt(FSElement a) {
		if (a.isFile()) {
			return 1;
		}else if (a.isDirectory()) {
			return 0;
		}else {
			return 2;
		}
	}
	
	public int compare(FSElement a1, FSElement a2) {
		return elementKindToInt(a1) - elementKindToInt(a2);
	}

}
