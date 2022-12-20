package edu.umb.cs680.hw13;

import org.junit.jupiter.api.Test;

import java.time.LocalDateTime;
import java.util.LinkedList;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

public class AlphabeticalComparatorTest {
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
    public void verifyGetChildren(){
        FSElement expected[] = {src, bin, home};
        Directory directory = root;
        LinkedList<FSElement> actual = directory.getChild(new AlphabeticalComparator());
        assertArrayEquals(expected, actual.toArray());
    }

    @Test
    public void verifyGetSubDirectoriesForHome(){
        Directory expected[] = {test};
        Directory dir = home;
        LinkedList<Directory> actual = dir.getSubDirectories(new AlphabeticalComparator());
        assertArrayEquals(expected, actual.toArray());
    }

    @Test
    public void verifyGetFiles(){
        File expected[] = {a, b};
        Directory dir = test;
        LinkedList<File> actual = dir.getFiles(new AlphabeticalComparator());
        assertArrayEquals(expected, actual.toArray());
    }
}
