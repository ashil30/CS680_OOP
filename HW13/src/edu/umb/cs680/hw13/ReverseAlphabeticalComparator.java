package edu.umb.cs680.hw13;

import java.util.Comparator;

public class ReverseAlphabeticalComparator implements Comparator<FSElement> {

    public int compare(FSElement ele1, FSElement ele2){
        return -ele1.getName().compareTo(ele2.getName());
    }
}
