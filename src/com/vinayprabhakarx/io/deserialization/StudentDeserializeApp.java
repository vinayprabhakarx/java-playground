package com.vinayprabhakarx.io.deserialization;

import com.vinayprabhakarx.pojo.Student;

public class StudentDeserializeApp {
    public static void main(String[] args) {
        String filePath = "src/com/vinayprabhakarx/io/file/student.ser";

        // StudentDeserializeApp uses the generic deserializer for Student objects.
        DeserializeApp<Student> deserializeApp = new DeserializeApp<>();
        deserializeApp.deserialize(filePath, Student.class);
    }
}
