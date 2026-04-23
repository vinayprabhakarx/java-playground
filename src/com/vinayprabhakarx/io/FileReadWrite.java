package com.vinayprabhakarx.io;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class FileReadWrite {

    public static void main(String[] args) {
        String fileName = "src/com/vinayprabhakarx/io/file/sample.txt";

        try (BufferedWriter writer = new BufferedWriter(new FileWriter(fileName))) {
            writer.write("Java IO Example");
            writer.newLine();
            writer.write("Reading and writing a file using java.io");
        } catch (IOException e) {
            System.out.println("Unable to write file: " + e.getMessage());
            return;
        }

        try (BufferedReader reader = new BufferedReader(new FileReader(fileName))) {
            String line;
            System.out.println("File content:");
            while ((line = reader.readLine()) != null) {
                System.out.println(line);
            }
        } catch (IOException e) {
            System.out.println("Unable to read file: " + e.getMessage());
        }
    }
}
