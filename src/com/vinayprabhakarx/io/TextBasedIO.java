package com.vinayprabhakarx.io;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class TextBasedIO {
    public static void main(String[] args) {
        String filePath = "src/com/vinayprabhakarx/io/file/text-data.txt";

        // BufferedWriter writes text efficiently by storing characters in memory before flushing to the file.
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(filePath))) {
            writer.write("Line 1: BufferedWriter writes text efficiently.");
            writer.newLine();
            writer.write("Line 2: BufferedReader reads one line at a time.");
        } catch (IOException e) {
            System.out.println("Unable to write text: " + e.getMessage());
            return;
        }

        // BufferedReader reads full lines of text, which is convenient for text files.
        try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
            String line;
            System.out.println("Text from file:");
            while ((line = reader.readLine()) != null) {
                System.out.println(line);
            }
        } catch (IOException e) {
            System.out.println("Unable to read text: " + e.getMessage());
        }
    }
}
