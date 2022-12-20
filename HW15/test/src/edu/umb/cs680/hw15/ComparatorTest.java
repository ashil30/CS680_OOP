package edu.umb.cs680.hw15;

import org.junit.jupiter.api.Test;

import java.time.LocalDateTime;
import java.util.LinkedList;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

public class ComparatorTest {
    static LocalDateTime localTime = LocalDateTime.now();
    static LocalDateTime localTime1 = LocalDateTime.of(2022, 12 , 10, 21, 10);
    static LocalDateTime localTime2 = LocalDateTime.of(2022, 12, 25, 13, 56);

    Directory root = new Directory(null, "root", 0, localTime1);
    Directory apps = new Directory(root, "apps", 0, localTime2);
    Directory bin = new Directory(root, "bin", 0, localTime1);
    Directory home = new Directory(root, "home", 0, localTime2);
    File x = new File(apps, "x", 300, localTime1);
    File y = new File(bin, "y", 300, localTime2);
    File z = new File(root,"z",200,localTime2);
    Directory pictures = new Directory(home, "pictures", 0, localTime2);
    Link d = new Link(root, "d", 200, localTime2, pictures);
    Link e = new Link(root, "e", 200, localTime1, x);
    File c = new File(home, "c", 200, localTime2);
    File a = new File(pictures, "a", 200, localTime2);
    File b = new File(pictures, "b", 200, localTime1);

    @Test
    public void verifyGetChildrenAlphabetical(){
        FSElement expected[] = {apps,bin,home,z};
        Directory directory = root;
        LinkedList<FSElement> actual = directory.getChild((FSElement arg1, FSElement arg2)-> arg1.getName().compareTo(arg2.getName()));
        assertArrayEquals(expected, actual.toArray());
    }

    @Test
    public void verifyGetChildrenReverseAlphabetical(){
        FSElement expected[] = {z,home,bin,apps};
        Directory directory = root;
        LinkedList<FSElement> actual = directory.getChild((FSElement arg1, FSElement arg2)-> -arg1.getName().compareTo(arg2.getName()));
        assertArrayEquals(expected, actual.toArray());
    }
    @Test
    public void verifyGetChildrenTimeStamp(){
        FSElement expected[] = {bin,apps,home,z};
        Directory directory = root;
        LinkedList<FSElement> actual = directory.getChild((FSElement arg1, FSElement arg2)-> arg1.getCreationTime().compareTo(arg2.getCreationTime()));
        assertArrayEquals(expected, actual.toArray());
    }

    @Test
    public void verifyGetSubDirectoriesAlphabetical(){
        Directory expected[] = {apps,bin,home};
        Directory dir = root;
        LinkedList<Directory> actual = dir.getSubDirectories((FSElement arg1, FSElement arg2)-> arg1.getName().compareTo(arg2.getName()));
        assertArrayEquals(expected, actual.toArray());
    }
    @Test
    public void verifyGetSubDirectoriesReverseAlphabetical(){
        Directory expected[] = {home,bin,apps};
        Directory dir = root;
        LinkedList<Directory> actual = dir.getSubDirectories((FSElement arg1, FSElement arg2)-> -arg1.getName().compareTo(arg2.getName()));
        assertArrayEquals(expected, actual.toArray());
    }
    @Test
    public void verifyGetSubDirectoriesTimeStamp(){
        Directory expected[] = {bin,apps,home};
        Directory dir = root;
        LinkedList<Directory> actual = dir.getSubDirectories((FSElement arg1, FSElement arg2)-> arg1.getCreationTime().compareTo(arg2.getCreationTime()));
        assertArrayEquals(expected, actual.toArray());
    }
    @Test
    public void verifyGetFilesAlphabetical(){
        File expected[] = {a, b};
        Directory dir = pictures;
        LinkedList<File> actual = dir.getFiles((FSElement arg1, FSElement arg2)-> arg1.getName().compareTo(arg2.getName()));
        assertArrayEquals(expected, actual.toArray());
    }
    @Test
    public void verifyGetFilesTimeStamp(){
        File expected[] = {b, a};
        Directory dir = pictures;
        LinkedList<File> actual = dir.getFiles((FSElement arg1, FSElement arg2)-> arg1.getCreationTime().compareTo(arg2.getCreationTime()));
        assertArrayEquals(expected, actual.toArray());
    }
    @Test
    public void verifyGetFilesReverseAlphabetical(){
        File expected[] = {b, a};
        Directory dir = pictures;
        LinkedList<File> actual = dir.getFiles((FSElement arg1, FSElement arg2)-> -arg1.getName().compareTo(arg2.getName()));
        assertArrayEquals(expected, actual.toArray());
    }
}
