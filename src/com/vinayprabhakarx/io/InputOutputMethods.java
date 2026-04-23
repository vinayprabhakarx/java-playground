package com.vinayprabhakarx.io;

import java.io.File;
import java.io.IOException;

public class InputOutputMethods {
    public static void main(String[] args) {
        String filePath = "src/com/vinayprabhakarx/io/file/input.txt";
        String directoryPath = "src/com/vinayprabhakarx/io/file";

        File file = new File(filePath);
        File directory = new File(directoryPath);

        try {
            // exists() checks whether the file or directory is present.
            System.out.println("File exists: " + file.exists());
            // getAbsolutePath() returns the full path from the filesystem root.
            System.out.println("Absolute path: " + file.getAbsolutePath());
            // getCanonicalPath() returns the normalized unique path.
            System.out.println("Canonical path: " + file.getCanonicalPath());
            // getName() returns only the file or directory name.
            System.out.println("File name: " + file.getName());
            // getParent() returns the parent path as a string.
            System.out.println("Parent directory: " + file.getParent());
            // isFile() checks whether this path points to a regular file.
            System.out.println("Is file: " + file.isFile());
            // isDirectory() checks whether this path points to a directory.
            System.out.println("Is directory: " + directory.isDirectory());
            // canWrite() checks write permission on the file.
            System.out.println("Can write: " + file.canWrite());
            // canRead() checks read permission on the file.
            System.out.println("Can read: " + file.canRead());
            // canExecute() checks execute permission on the file.
            System.out.println("Can execute: " + file.canExecute());
            // length() returns the size of the file in bytes.
            System.out.println("File size in bytes: " + file.length());
            // lastModified() returns the last updated time in milliseconds.
            System.out.println("Last modified: " + file.lastModified());
            // getPath() returns the path used to create the File object.
            System.out.println("Original path: " + file.getPath());
            // list() returns names of files and folders inside a directory.
            String[] directoryContents = directory.list();
            if (directoryContents != null) {
                System.out.println("Items in directory:");
                for (String item : directoryContents) {
                    System.out.println(item);
                }
            }
        } catch (IOException e) {
            System.out.println("Unable to read file details: " + e.getMessage());
        }
    }
}
