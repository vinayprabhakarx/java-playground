package com.vinayprabhakarx.pojo;

import java.io.Serializable;
import java.util.Objects;

public class Student implements Serializable {
    // Instance variables store student data.
    private int id;
    private String name;
    private int age;
    private double marks;

    // Default constructor creates an object with default values.
    public Student() {
    }

    // Parameterized constructor creates an object with given values.
    public Student(int id, String name, int age, double marks) {
        this.id = id;
        this.name = name;
        this.age = age;
        this.marks = marks;
    }

    // Getter returns the id value.
    public int getId() {
        return id;
    }

    // Setter updates the id value.
    public void setId(int id) {
        this.id = id;
    }

    // Getter returns the name value.
    public String getName() {
        return name;
    }

    // Setter updates the name value.
    public void setName(String name) {
        this.name = name;
    }

    // Getter returns the age value.
    public int getAge() {
        return age;
    }

    // Setter updates the age value.
    public void setAge(int age) {
        this.age = age;
    }

    // Getter returns the marks value.
    public double getMarks() {
        return marks;
    }

    // Setter updates the marks value.
    public void setMarks(double marks) {
        this.marks = marks;
    }

    // toString() returns the object data in readable text form.
    @Override
    public String toString() {
        return "Student{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", age=" + age +
                ", marks=" + marks +
                '}';
    }

    // equals() compares whether two PojoStudent objects have the same data.
    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        Student student = (Student) obj;
        return id == student.id
                && age == student.age
                && Double.compare(marks, student.marks) == 0
                && Objects.equals(name, student.name);
    }

    // hashCode() generates a hash value used in hash-based collections.
    @Override
    public int hashCode() {
        return Objects.hash(id, name, age, marks);
    }
}
