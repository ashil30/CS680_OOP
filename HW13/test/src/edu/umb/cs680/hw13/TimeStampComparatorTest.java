package edu.umb.cs680.hw13;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

import java.time.LocalDateTime;
import java.util.LinkedList;


public class TimeStampComparatorTest {
    static LocalDateTime localTime = LocalDateTime.now();


    Directory root = new Directory(null, "root", 0, localTime);
    Directory src = new Directory(root, "src", 0, localTime);
    Directory bin = new Directory(root, "bin", 0, localTime);
    Directory home = new Directory(root, "home", 0, localTime);
    File x = new File(src, "x", 100, localTime);
    File y = new File(bin, "y", 100, localTime);
    Directory test = new Directory(home, "test", 0, localTime);
    Link d = new Link(root, "d", 50, localTime, test);
    Link e = new Link(root, "e", 50, localTime, x);
    File c = new File(home, "c", 50, localTime);
    File a = new File(test, "a", 50, localTime);
    File b = new File(test, "b", 50, localTime);

    @Test
    public void verifySubDirectories(){
        Directory expected[] = {test};
        Directory dir = home;
        LinkedList<Directory> actual = dir.getSubDirectories(new TimeStampComparator());
        assertArrayEquals(expected, actual.toArray());
    }

    @Test
    public void verifyGetFiles(){
        File expected[] = {a, b};
        Directory dir = test;
        LinkedList<File> actual = dir.getFiles(new TimeStampComparator());
        assertArrayEquals(expected, actual.toArray());
    }



}
