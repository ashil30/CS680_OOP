package edu.umb.cs680.hw13;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

import java.time.LocalDateTime;
import java.util.LinkedList;


public class TimeStampComparatorTest {
    static LocalDateTime localTime = LocalDateTime.now();


    Directory root = new Directory(null, "root", 0, localTime);
    Directory apps = new Directory(root, "apps", 0, localTime);
    Directory bin = new Directory(root, "bin", 0, localTime);
    Directory home = new Directory(root, "home", 0, localTime);
    File x = new File(apps, "x", 100, localTime);
    File y = new File(bin, "y", 100, localTime);
    Directory pictures = new Directory(home, "pictures", 0, localTime);
    Link d = new Link(root, "d", 50, localTime, pictures);
    Link e = new Link(root, "e", 50, localTime, x);
    File c = new File(home, "c", 50, localTime);
    File a = new File(pictures, "a", 50, localTime);
    File b = new File(pictures, "b", 50, localTime);

    @Test
    public void verifySubDirectories(){
        Directory expected[] = {pictures};
        Directory dir = home;
        LinkedList<Directory> actual = dir.getSubDirectories(new TimeStampComparator());
        assertArrayEquals(expected, actual.toArray());
    }

    @Test
    public void verifyGetFiles(){
        File expected[] = {a, b};
        Directory dir = pictures;
        LinkedList<File> actual = dir.getFiles(new TimeStampComparator());
        assertArrayEquals(expected, actual.toArray());
    }



}
