package com.vinayprabhakarx.io;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class CharacterStream {
    public static void main(String[] args) {
        String filePath = "src/main/resources/com/vinayprabhakarx/io/file/character-data.txt";

        // FileWriter writes character data such as letters, spaces, and new lines.
        try (FileWriter writer = new FileWriter(filePath)) {
            writer.write("Java");
            writer.write('\n');
            writer.write("Character Stream");
        } catch (IOException e) {
            System.out.println("Unable to write characters: " + e.getMessage());
            return;
        }

        // FileReader reads one character at a time from the text file.
        try (FileReader reader = new FileReader(filePath)) {
            int character;
            System.out.println("Characters from file:");
            while ((character = reader.read()) != -1) {
                System.out.println((char) character);
            }
        } catch (IOException e) {
            System.out.println("Unable to read characters: " + e.getMessage());
        }
    }
}
