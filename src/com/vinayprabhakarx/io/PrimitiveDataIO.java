package com.vinayprabhakarx.io;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class PrimitiveDataIO {
    public static void main(String[] args) {
        String filePath = "src/com/vinayprabhakarx/io/primitive-data.dat";

        // DataOutputStream writes Java primitive values in binary form.
        try (DataOutputStream outputStream = new DataOutputStream(new FileOutputStream(filePath))) {
            outputStream.writeInt(101);
            outputStream.writeDouble(95.5);
            outputStream.writeBoolean(true);
            outputStream.writeUTF("Java IO");
        } catch (IOException e) {
            System.out.println("Unable to write primitive data: " + e.getMessage());
            return;
        }

        // DataInputStream reads primitive values back in the same order they were written.
        try (DataInputStream inputStream = new DataInputStream(new FileInputStream(filePath))) {
            int id = inputStream.readInt();
            double score = inputStream.readDouble();
            boolean active = inputStream.readBoolean();
            String course = inputStream.readUTF();

            System.out.println("Primitive data from file:");
            System.out.println("Id: " + id);
            System.out.println("Score: " + score);
            System.out.println("Active: " + active);
            System.out.println("Course: " + course);
        } catch (IOException e) {
            System.out.println("Unable to read primitive data: " + e.getMessage());
        }
    }
}
