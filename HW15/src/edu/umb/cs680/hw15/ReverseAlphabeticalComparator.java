package edu.umb.cs680.hw13;

import java.util.Comparator;

public class ReverseAlphabeticalComparator implements Comparator<FSElement>{

	public int compare(FSElement a1, FSElement a2) {
		return a2.getName().compareTo(a1.getName());
	}

}
