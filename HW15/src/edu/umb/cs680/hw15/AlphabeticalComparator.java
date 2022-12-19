package edu.umb.cs680.hw13;

import java.util.Comparator;

public class AlphabeticalComparator implements Comparator<FSElement>{

	public int compare(FSElement a1, FSElement a2) {
		return a1.getName().compareTo(a2.getName());
	}

}
