package edu.umb.cs680.hw13;

import java.util.Comparator;

public class SizeComparator implements Comparator<FSElement> {
    public int compare(FSElement fsElement1, FSElement fsElement2){
        return fsElement1.getSize()- fsElement2.getSize();
    }
}
