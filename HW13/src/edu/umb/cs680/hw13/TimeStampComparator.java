package edu.umb.cs680.hw13;

import java.util.Comparator;

public class TimeStampComparator implements Comparator<FSElement> {
    public int compare(FSElement fsElement1, FSElement fsElement2){
        return fsElement1.getCreationTime().compareTo(fsElement2.getCreationTime());
    }
}
