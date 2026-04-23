package com.vinayprabhakarx.io;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class ByteStream {
    public static void main(String[] args) {
        String filePath = "src/com/vinayprabhakarx/io/file/byte-data.bin";

        // FileOutputStream writes raw byte values to a file.
        try (FileOutputStream outputStream = new FileOutputStream(filePath)) {
            outputStream.write(72);
            outputStream.write(73);
            outputStream.write(10);
            outputStream.write(74);
            outputStream.write(65);
            outputStream.write(86);
            outputStream.write(65);
        } catch (IOException e) {
            System.out.println("Unable to write bytes: " + e.getMessage());
            return;
        }

        // FileInputStream reads one byte at a time and returns -1 at end of file.
        try (FileInputStream inputStream = new FileInputStream(filePath)) {
            int data;
            System.out.println("Byte values from file:");
            while ((data = inputStream.read()) != -1) {
                System.out.println(data);
            }
        } catch (IOException e) {
            System.out.println("Unable to read bytes: " + e.getMessage());
        }
    }
}
