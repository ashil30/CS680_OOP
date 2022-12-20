package edu.umb.cs680.hw13;

import java.util.Comparator;

public class ElementComparator implements Comparator<FSElement> {

    private int elementEncoding(FSElement fsElement){
        if(fsElement.isFile()){
            return 1;
        } else if (fsElement.isDirectory()) {
            return 0;
        }
        else{
            return 2;
        }
    }

    public int compare(FSElement fsElement1, FSElement fsElement2){
        return elementEncoding(fsElement1) - elementEncoding(fsElement2);
    }
}
