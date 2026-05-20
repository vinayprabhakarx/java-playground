package com.vinayprabhakarx.io;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class BufferedReadWrite {
    public static void main(String[] args) {
        String inputPath = "src/main/resources/com/vinayprabhakarx/io/file/input.txt";
        String outputPath = "src/main/resources/com/vinayprabhakarx/io/file/output.txt";

        try (BufferedReader bufferedReader = new BufferedReader(new FileReader(inputPath));
             BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(outputPath))) {
            String line;
            while ((line = bufferedReader.readLine()) != null) {
                bufferedWriter.write(line);
                bufferedWriter.newLine();
            }
            System.out.println("File copied successfully from " + inputPath + " to " + outputPath);
        } catch (IOException e) {
            System.out.println("File operation failed: " + e.getMessage());
        }
    }
}
