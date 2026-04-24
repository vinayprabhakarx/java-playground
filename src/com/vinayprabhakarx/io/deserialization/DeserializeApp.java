package com.vinayprabhakarx.io.deserialization;

import java.io.FileNotFoundException;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InvalidClassException;
import java.io.InvalidObjectException;
import java.io.ObjectInputStream;
import java.io.OptionalDataException;
import java.io.StreamCorruptedException;

public class DeserializeApp<T> {

    // deserialize() reads bytes from a file and rebuilds the original object.
    public T deserialize(String filePath, Class<T> type) {
        try (FileInputStream fileInputStream = new FileInputStream(filePath);
             ObjectInputStream objectInputStream = new ObjectInputStream(fileInputStream)) {
            Object object = objectInputStream.readObject();
            T result = type.cast(object);
            System.out.println("Deserialized " + type.getSimpleName() + ":");
            System.out.println(result);
            return result;
        } catch (FileNotFoundException e) {
            System.out.println("Serialization file not found: " + e.getMessage());
        } catch (InvalidClassException e) {
            System.out.println("Deserialization failed because class versions do not match: " + e.getMessage());
        } catch (StreamCorruptedException e) {
            System.out.println("File does not contain a valid serialized object stream: " + e.getMessage());
        } catch (OptionalDataException e) {
            System.out.println("Unexpected primitive data found during deserialization: " + e.getMessage());
        } catch (InvalidObjectException e) {
            System.out.println("Serialized object data is invalid: " + e.getMessage());
        } catch (ClassNotFoundException e) {
            System.out.println("Class definition not found during deserialization: " + e.getMessage());
        } catch (ClassCastException e) {
            System.out.println("Deserialized object type does not match " + type.getSimpleName());
        } catch (IOException e) {
            System.out.println("I/O error during deserialization: " + e.getMessage());
        }
        System.out.println(type.getSimpleName() + " deserialization failed.");
        return null;
    }
}
