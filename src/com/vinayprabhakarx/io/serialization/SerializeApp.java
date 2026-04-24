package com.vinayprabhakarx.io.serialization;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InvalidClassException;
import java.io.NotSerializableException;
import java.io.ObjectOutputStream;
import java.io.Serializable;

// T extends Serializable means this serializer only accepts objects that Java can serialize.
public class SerializeApp<T extends Serializable> {

    // serialize() converts an object into bytes and stores it in a file.
    public boolean serialize(T object, String filePath) {
        try (FileOutputStream fileOutputStream = new FileOutputStream(filePath);
             ObjectOutputStream objectOutputStream = new ObjectOutputStream(fileOutputStream)) {
            objectOutputStream.writeObject(object);
            System.out.println("Object serialized to " + filePath);
            System.out.println("Serialized " + object.getClass().getSimpleName() + ":");
            System.out.println(object);
            return true;
        } catch (FileNotFoundException e) {
            System.out.println("Unable to create serialization file: " + e.getMessage());
        } catch (NotSerializableException e) {
            System.out.println("Object does not implement Serializable: " + e.getMessage());
        } catch (InvalidClassException e) {
            System.out.println("Serialization failed because class definition is invalid: " + e.getMessage());
        } catch (IOException e) {
            System.out.println("I/O error during serialization: " + e.getMessage());
        }
        System.out.println(object.getClass().getSimpleName() + " serialization failed.");
        return false;
    }
}
