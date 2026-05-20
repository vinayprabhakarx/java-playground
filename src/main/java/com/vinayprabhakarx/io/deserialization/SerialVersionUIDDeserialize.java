package com.vinayprabhakarx.io.deserialization;

import com.vinayprabhakarx.pojo.SerialVersionStudent;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectStreamClass;

public class SerialVersionUIDDeserialize {
    public static void main(String[] args) {
        String filePath = "src/main/resources/com/vinayprabhakarx/io/file/serial-version-student.ser";

        printSerialVersionUID(SerialVersionStudent.class);

        // Deserialization works only when the saved and current serialVersionUID match.
        try (FileInputStream fileInputStream = new FileInputStream(filePath);
             ObjectInputStream objectInputStream = new ObjectInputStream(fileInputStream)) {
            SerialVersionStudent student = (SerialVersionStudent) objectInputStream.readObject();
            System.out.println("Deserialized student:");
            System.out.println(student);
        } catch (IOException | ClassNotFoundException e) {
            System.out.println("Unable to deserialize SerialVersionStudent: " + e.getMessage());
        }
    }

    private static void printSerialVersionUID(Class<?> type) {
        ObjectStreamClass objectStreamClass = ObjectStreamClass.lookup(type);
        System.out.println(type.getSimpleName() + " serialVersionUID: "
                + objectStreamClass.getSerialVersionUID());
    }
}
