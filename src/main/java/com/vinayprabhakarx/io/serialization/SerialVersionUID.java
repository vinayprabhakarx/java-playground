package com.vinayprabhakarx.io.serialization;

import com.vinayprabhakarx.pojo.SerialVersionStudent;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectStreamClass;
import java.io.ObjectOutputStream;

public class SerialVersionUID {
    public static void main(String[] args) {
        String filePath = "src/main/resources/com/vinayprabhakarx/io/file/serial-version-student.ser";
        SerialVersionStudent student = new SerialVersionStudent(101, "Vinay");

        System.out.println(student);
        printSerialVersionUID(SerialVersionStudent.class);

        // ObjectOutputStream writes the object with its serialVersionUID metadata.
        try (FileOutputStream fileOutputStream = new FileOutputStream(filePath);
             ObjectOutputStream objectOutputStream = new ObjectOutputStream(fileOutputStream)) {
            objectOutputStream.writeObject(student);
            System.out.println("SerialVersionStudent serialized to " + filePath);
        } catch (IOException e) {
            System.out.println("Unable to serialize SerialVersionStudent: " + e.getMessage());
        }
    }

    private static void printSerialVersionUID(Class<?> type) {
        // ObjectStreamClass shows the serialVersionUID used by Java serialization.
        ObjectStreamClass objectStreamClass = ObjectStreamClass.lookup(type);
        System.out.println(type.getSimpleName() + " serialVersionUID: "
                + objectStreamClass.getSerialVersionUID());
    }
}
