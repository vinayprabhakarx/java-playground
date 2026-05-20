package com.vinayprabhakarx.io.serialization;

import com.vinayprabhakarx.pojo.Student;

public class StudentSerializeApp {
    public static void main(String[] args) {
        String filePath = "src/main/resources/com/vinayprabhakarx/io/file/student.ser";
        Student student = new Student(101, "Vinay", 22, 95.0);

        // StudentSerializeApp uses the generic serializer for Student objects.
        SerializeApp<Student> serializeApp = new SerializeApp<>();
        serializeApp.serialize(student, filePath);
    }
}
