package com.vinayprabhakarx.hibernate.pojo;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
public class StudentResult {
    @Id
    int id;
    @Column
    String name;
    @Column
    int age;
    @Column
    int marks;
    @Column
    String email;
    @Column
    int phone;

    public StudentResult() {
    }

    public StudentResult(int id, String name, int age, String email, int marks, int phone) {
        this.id = id;
        this.name = name;
        this.age = age;
        this.email = email;
        this.marks = marks;
        this.phone = phone;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public int getMarks() {
        return marks;
    }

    public void setMarks(int marks) {
        this.marks = marks;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public int getPhone() {
        return phone;
    }

    public void setPhone(int phone) {
        this.phone = phone;
    }

    @Override
    public String toString() {
        return "Student{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", age=" + age +
                ", marks=" + marks +
                ", email='" + email + '\'' +
                ", phone=" + phone +
                '}';
    }


}
