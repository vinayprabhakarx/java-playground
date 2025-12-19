package com.vinayprabhakarx.encapsulation;

import java.time.LocalDate;

public class StudentTest {

    public static void main(String[] args) {

        Student student1 = new Student(101, "Vinay Prabhakar");
        System.out.println(student1);

        System.out.println("------------------------------------");

        Student student2 = new Student(102, "Amit Kumar");
        student2.setCourse("MCA");
        student2.setAdmissionDate(LocalDate.of(2024, 7, 15));
        System.out.println(student2);

        System.out.println("------------------------------------");

        Student student3 = new Student(
                103,
                "Kunal Kumar",
                "BBA",
                LocalDate.of(2025, 2, 20));
        System.out.println(student3);
    }
}
