package com.vinayprabhakarx.encapsulation;

import java.time.LocalDate;

public class Student {

    private int id;
    private String name;
    private String course;
    private LocalDate admissionDate;

    // Default constructor
    public Student() {
        this.course = "BCA";
        this.admissionDate = LocalDate.now();
    }

    // Parameterized constructor
    public Student(int id, String name) {
        this();
        this.id = id;
        this.name = name;
    }

    // Parameterized constructor
    public Student(int id, String name, String course, LocalDate admissionDate) {
        this.id = id;
        this.name = name;
        this.course = course;
        this.admissionDate = admissionDate;
    }

    // Setter methods (Encapsulation)
    public void setCourse(String course) {
        this.course = course;
    }

    public void setAdmissionDate(LocalDate admissionDate) {
        this.admissionDate = admissionDate;
    }

    // Information method
    public String getStudentInfo() {
        return "Student ID: " + id +
                "\nStudent Name: " + name +
                "\nCourse: " + course +
                "\nAdmission Date: " + admissionDate;
    }

    // Standard Java practice
    @Override
    public String toString() {
        return getStudentInfo();
    }
}
